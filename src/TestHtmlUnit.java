
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
import java.io.*;
//import org.apache.*;
//import org.apache.commons.collections.MultiMap;
//import org.apache.commons.collections.map.MultiValueMap;

public class TestHtmlUnit  {
	public static DB db= new DB();
	
	public static void FBLogin(String user_name,String password) throws Exception,IOException {
			
		/* turn off annoying htmlunit warnings */
		 java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
		 final WebClient webClient = new WebClient(BrowserVersion.CHROME); 

		 
		 
   		webClient.waitForBackgroundJavaScript(50000);
   		webClient.getCookieManager().setCookiesEnabled(true);
   		webClient.getCurrentWindow().setInnerHeight(60000);

   		try{
   				db.runSql2("TRUNCATE Crawler.friendList");
		
		   		final HtmlPage page1 = webClient.getPage("https://www.facebook.com");
				System.out.println("Page fetched");
				final HtmlForm form = (HtmlForm) page1.getElementById("login_form");
				System.out.println("Form selected");
				JavaScriptEngine engine = new JavaScriptEngine(webClient);
				webClient.setJavaScriptEngine(engine);
				final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputsByValue("Log In").get(0);
				final HtmlTextInput textField = form.getInputByName("email");
				textField.setValueAttribute(user_name);
				final HtmlPasswordInput textField2 = form.getInputByName("pass");
				textField2.setValueAttribute(password);
				System.out.println("Parameters set");
				final HtmlPage homePage = button.click();
				//print page source
				
				
				
				//print page text
				String homePageText = homePage.asText();
				
				//System.out.println("Submitted");
				System.out.println(homePageText);
				
				//Get profilepage URL
				DomNodeList<DomElement> elementsByTagName = homePage.getElementsByTagName("a");
				String profileURL = "";

				for (DomElement element : elementsByTagName) {
				    if (element.getAttribute("title") != null
					    && element.getAttribute("title").equals("Profile")) {
					HtmlAnchor profilebutton = (HtmlAnchor) element;
					profileURL = profilebutton.getHrefAttribute();
					break;
				    }
				}
				
				
				
				//get User Account ID
				String accountID;
				try {
				    if (profileURL.contains("&")) {
					int index = profileURL.indexOf('=') + 1;
					accountID = profileURL.substring(index, profileURL.indexOf("&"));
				    } 
				    
				    else {
					int index = profileURL.indexOf("facebook.com/") + "facebook.com/".length();
					if (profileURL.contains("?")) {
					    accountID = profileURL.substring(profileURL.indexOf("?")+1);
					} 
					else {
					    accountID = profileURL.substring(index);
					}
				    }
				if(accountID==null){
					System.exit(0);
				}
				    else{
				    System.out.println(profileURL);
					System.out.println(accountID);
				    }    
				} catch (Exception ex) {
				    accountID = "Couldn't get ID";
				  System.out.println(accountID);
				    //  Logger.getLogger(FacebookManager.class.getName()).log(Level.WARNING, "Failed to get User ID while logging in");
				}

				String friendsPageURL= getFriendsPageURL(profileURL);
				
				System.out.println(friendsPageURL);

				HtmlPage friendsPage= webClient.getPage(friendsPageURL);
				
				String friendsPageText= friendsPage.asText();
				
				System.out.println(friendsPageText);
				
				String friendsPageSource = friendsPage.asXml();
				
				// write pagesource to file 
				writeFriendsPageSource(friendsPageSource);
			
					
				
			//	HtmlPage aboutPage= webClient.getPage(profileURL+"&sk=about");
			//	String aboutPageSource = aboutPage.asXml(); 
			//	writeLocationPageSource(aboutPageSource);
				new FriendSearch(webClient,0); 
				
				//new FriendSearch(profileURL);
				new Recursive(webClient);
				webClient.close();
	   						
				
		}catch(Exception e){
		
			System.out.println(e);
			}
   		
}


public static void writeFriendsPageSource(String pageSource){
	
	try {
		File file = new File("Friends_page_source.txt");
		System.out.println("");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(pageSource);
		fileWriter.flush();
		fileWriter.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return;
}

public static void writeLocationPageSource(String pageSource){
	
	try {
		File file = new File("Location_page_source.txt");
		System.out.println("");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(pageSource);
		fileWriter.flush();
		fileWriter.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return;
}


public static String getFriendsPageURL(String profilePageURL) {
	String friendsPageURL;
	if (!profilePageURL.contains("id")) {
	    friendsPageURL = (profilePageURL.contains("?")) ? profilePageURL.substring(0, profilePageURL.indexOf("?") + 1) : profilePageURL + "?";
	} else {
	    friendsPageURL = profilePageURL + "&";
	}
	friendsPageURL += "sk=friends";
	return friendsPageURL;
    }
	
	
}
