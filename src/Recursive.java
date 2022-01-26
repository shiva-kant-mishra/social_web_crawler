import java.io.*;
import java.sql.*;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;

public class Recursive extends TestHtmlUnit
{
	public static DB db1 = new DB();

	public static ResultSet rs1,rs2;
	//public ReadyQueue rq= new ReadyQueue(); 
	public static int count=0;
	public static String string1;
	public Recursive(WebClient webClient)throws SQLException, IOException
	{
		try
		{
			do{
			String loc=null;
		
		 String sql1="SELECT location_name "+
"FROM locationTable "+
"INNER JOIN (SELECT (RAND() * (SELECT count(*) FROM locationTable)) AS ID) "+
 " AS t ON locationTable.recordId >= t.ID "+
"ORDER BY locationTable.recordId ASC "+
"LIMIT 1"+";"; 
		 
		 rs2= db1.runSql(sql1);
		 
		 if(rs2.next()){
		loc= rs2.getString("location_name");
		System.out.println(loc);
		 }
		 String url=null, friendsPageSource=null;
		 int recordID;
		 recordID= (int)ReadyQueue.getNodeValue();
		 System.out.println(recordID);
			 
		 String sql = "select * from Crawler.friendList where recordId ="+recordID+";";
		 
		  rs1=db1.runSql(sql);
		// string1=rs1.getString("recordId");
		// System.out.print(string1);
		 //count= Integer.parseInt(string1);
		 
			 if(rs1.next())
		 		 { 
					url=rs1.getString("friendURL");
					recordID=rs1.getInt("recordId");
					System.out.println(url);
					HtmlPage friendsPage= webClient.getPage(url+"/friends");
				//	HtmlPage locationPage= webClient.getPage(url+"/about");
					friendsPageSource= friendsPage.asXml();
				//	locationPageSource=  locationPage.asXml();
					writeFriendsPageSource(friendsPageSource);
				//	writeLocationPageSource(locationPageSource);
					
					File f = new File("Friends_page_source.txt");
				//	File l = new File("Location_page_source.txt");
					
					String search = "hc_location=friends_tab";
				//	String search1 = "<div class=\"fsm fwn fcg\"><span>From";
					
				//	System.out.printf("Result of searching for %s in %s was \n", search, f.getName());
				//	FriendSearch.findLocation(l, search1,url);
					FriendSearch.findFriends(webClient,f, search, recordID,loc);	
				//	if(count==100)
				//	{
				//		FriendSearch.getMatrix();
				//	}
					count++;
					//new FriendSearch(); 
				}
			// System.out.println(count);
			// sql="select * from Crawler.friendList where recordId> '"+count+"'";
			// PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// stmt.setLong(1, count);
		//	 rs1 = db1.runSql(sql); 
			 ReadyQueue.removeNode();
		}while(ReadyQueue.toCrawl.size()>0);
	
		 
		// FriendSearch.getMatrix();
		
	}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
