

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.*;
import java.util.Set;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import com.google.common.collect.Multiset.Entry;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;


public class FriendSearch {
	public static DB db= new DB();
	public static MultiMap adjList = new MultiValueMap();
	public static MultiMap indexList = new MultiValueMap();
    static int count = 0;
   //static ReadyQueue queue= new ReadyQueue();
	
    FriendSearch(WebClient webClient,int UID) {
	// Testing only
    	try{
    		//db.runSql2("TRUNCATE Crawler.friendList");
    		File f = new File("Friends_page_source.txt");
			String search = "hc_location=friends_tab";
			System.out.printf("Result of searching for %s in %s was \n", search, f.getName());
			FriendSearch.findFriends(webClient,f, search, UID,"Lucknow-India");
		//	File l = new File("Location_page_source.txt");
		//	String search1 = "class="+"\"profileLink\"";
		//	FriendSearch.findLocation(l, search1,profileURL);
		   // FriendSearch.formAdMatrix();
		    } catch(Exception e){
			   System.out.println(e);
		   }
    }

    
    public static void findFriends(WebClient webClient,File f, String searchString,int UID,String location) throws SQLException {
	//boolean result = false;
    String str,sql,urlString= null;
    Scanner in = null;
    int startIndex ;
    int lastIndex ;
   
		try {
			in = new Scanner(new FileReader(f));
			while(in.hasNextLine()) {
				    	
					str= in.nextLine();
				    	
				    if (str.contains(searchString)) {
				    //		System.out.println(str);
				    //		System.out.println(str.indexOf(searchString));
				    		
				   		urlString= str;
				    }
			}
			
			if (urlString==null)
				return;
		      
		    
				    System.out.println(urlString);
				    startIndex = 0;
				    lastIndex = 0;
				    String tempStr= null, name= null,prevStr=null;
				    String findBeginStr= "https://www.facebook.com/";
				    String findEndStr= ";hc_location=friends_tab";
				    int nodeCount= 0;
				   
				    while(startIndex != -1 && lastIndex != -1){
			
				        startIndex = urlString.indexOf(findBeginStr,startIndex);
				        lastIndex = urlString.indexOf(findEndStr,lastIndex);
				        
				      //  System.out.println(startIndex+"-"+lastIndex);
				       
				       if(startIndex != -1 && lastIndex != -1){
				        	tempStr = urlString.substring(startIndex, lastIndex-"?fref=pb&amp".length());
				        	if(!tempStr.contains("</a>")&& !tempStr.contains("profile.php") && !tempStr.equals(prevStr))
				        	{
				        		System.out.println(tempStr);
					        	name= tempStr.substring("https://www.facebook.com/".length());
					        	System.out.println(name);
					        	String sql1=null;
				    		     int tempID;
				                 
					        	
					        	
					        	sql="select * from `Crawler`.`friendList` where friendURL='"+tempStr+"'";
					        	ResultSet rs = db.runSql(sql);
					    			if(rs.next())
					    		    {System.out.println("Already exists"+tempStr);
					                 sql1="select recordID from `Crawler`.`friendList` where friendURL='"+tempStr+"'";
							        	ResultSet rs2 = db.runSql(sql1);
							        	if(rs2.next())
							        		{tempID=rs2.getInt("recordID");
							        		 adjList.put(UID, tempID);
							        		 
							        		}
							        	else{
							        		System.out.println("Record Not found");
							        	}
					    		    }
					    		  else
					    		  	{
					    			//store the URL to database to avoid parsing again
					    			  	System.out.println(tempStr);
							        	sql = "INSERT INTO  `Crawler`.`friendList` " + "(`friendURL`,`friendName`) VALUES " + "(?,?);";
										PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
										stmt.setString(1, tempStr);
										stmt.setString(2, name);
										
										stmt.execute();
							        	count++;
							            getFriendLocation(webClient,tempStr);
							        	sql1="select * from `Crawler`.`friendList` where friendURL='"+tempStr+"'";
							        	ResultSet rs2 = db.runSql(sql1);
							        	if(rs2.next())
							        		{String loc=null;
							        		tempID=rs2.getInt("recordID");
							        		 try{loc= rs2.getString("Location");
							        		 }
							        		 catch(Exception e){
							        			 
							        		 }
							        		 adjList.put(UID, tempID);
							        		 ReadyQueue.addNode(tempID);
								        		
							        		 // ReadyQueue.addNode(tempID);
								        		
							 /*       		 	try{ if(loc==location && nodeCount<4)
							        		 {
							        		 		 ReadyQueue.addNode(tempID);
							        			 nodeCount++;
							        		 }
							        		 else if(loc== null && nodeCount<4)
							        		 {
							        			 ReadyQueue.addNode(tempID);					        			 
							        			 nodeCount++;
							        		 }
							        
							        		 
							        		 
							        		 
							        		}catch(Exception e){}
							        		}
							   */
							        		}
							        		
							        	else{
							        		System.out.println("Record Not found");
							        	}
					    		    	

					    		  	}
				        	}  	
					    			
				        	prevStr= tempStr;
				        	urlString = urlString.substring((urlString.substring(startIndex, lastIndex)).length()+findEndStr.length());
				    		}
				       
						}
				    Set<Object> keys = adjList.keySet();
		        	for(Object key : keys){
		        		System.out.println("////////////////////////////////////////////////////////////////////////////");
		        		
		        		System.out.println(key);
		    //    		Object values = adjList.get(key);
		     //   		System.out.println(values.getClass().getName());
		     //   		ArrayList al = (ArrayList) adjList.get(key);
		     //   		Iterator itr = al.iterator();
		      //  		int i = 1;
		       // 		while(itr.hasNext()){
		      //  			System.out.println(itr.next());
		       // 			System.out.println(i);
		       // 			i++;
		       // 		}
		        		System.out.println(adjList.get(key));
			        
		        		        		        		
		        	}
		        	ReadyQueue.showToCrawl();
				    
			 
		}catch(IOException e) {
						    e.printStackTrace();	
						}
				    
						try { 
							  in.close() ; 
							  } catch(Exception e) { /* ignore */ }	
						  
						
	  }

    
    public static void getFriendLocation(WebClient webClient,String url){
    	HtmlPage locationPage= null;
		try {
			locationPage = webClient.getPage(url+"/about");
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String locationPageSource=  locationPage.asXml();
		TestHtmlUnit.writeLocationPageSource(locationPageSource);
		
		File l = new File("Location_page_source.txt");
		
		String search1 = "<div class=\"fsm fwn fcg\"><span>From";
		
		try {
			FriendSearch.findLocation(l, search1,url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
   
   
    
    
    public static void findLocation(File f, String searchString,String profileURL) throws SQLException {
    	//boolean result = false;
        String str,sql,urlString= null;
        Scanner in = null;
    	try {
    	    in = new Scanner(new FileReader(f));
    	    while(in.hasNextLine()) {
    	    	str= in.nextLine();
    	    	
    	    	if (str.contains(searchString)) {
    	    	//	System.out.println(str);
    	    	//	System.out.println(str.indexOf(searchString));
    	    		
    	    		urlString= str;
    	    		break;
    	    	}
    	      }
    	       
    	    if(urlString==null)
    	    	return;
    	    

    	    urlString= urlString.substring(urlString.indexOf("<div class=\"fsm fwn fcg\"><span>From")+"<div class=\"fsm fwn fcg\"><span>From".length());
    		
    	    System.out.println(urlString);
    	    int startIndex = 0;
    	    int lastIndex = 0;
    	    String tempStr= null, name= null,prevStr=null;
    	    String findBeginStr= "href=\"https://www.facebook.com/pages/";
    	    String findEndStr= "?ref=br_rs";
    	    startIndex = urlString.indexOf(findBeginStr);
   	        lastIndex = urlString.indexOf(findEndStr);
   	     //   System.out.println("start "+startIndex+" last "+lastIndex);
   	     //  System.out.println(startIndex+"-"+lastIndex);
    	       
    	        if(startIndex != -1 && lastIndex != -1){
    	        	tempStr = urlString.substring(startIndex+"href=\"https://www.facebook.com/pages/".length(), lastIndex);
    	        	lastIndex= tempStr.indexOf("/");
    	        	tempStr = tempStr.substring(0,lastIndex);
    	        	System.out.println(tempStr);
    	        if(tempStr==null)
    	        	return;
    	        //	System.out.println(tempStr);
		        	sql = "UPDATE  `Crawler`.`friendList` " + "SET location= " + "(?)"+"WHERE friendURL="+ "(?)";
					PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					stmt.setString(1, tempStr);
					stmt.setString(2, profileURL);
					
					stmt.execute();
					
					 sql="select * from `Crawler`.`locationTable` where location_name='"+tempStr+"'";
			        	ResultSet rs2 = db.runSql(sql);
			        if(!rs2.next())
			        {
			        	sql = "INSERT INTO  `Crawler`.`locationTable` " + "(`location_name`) VALUES " + "(?);";
											 stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
											 stmt.setString(1, tempStr);
											 stmt.execute();
								
			        }
    	}
    	}catch(IOException e) {
    	    e.printStackTrace();	
    	}
    	finally {
    	  try { in.close() ; } catch(Exception e) { /* ignore */ }	
    	}
    }
  
    
    
public static void getMatrix(){
	try{
		int nodeNumber=0;
		String sql;
    getIndexList();
	
	System.out.println("################################################################");
	
    sql="select max(recordId) from `Crawler`.`friendList`";
    	ResultSet rs2 = db.runSql(sql);
    	if(rs2.next())
    		{nodeNumber=rs2.getInt("max(recordId)");
    		System.out.println("Max record id id "+nodeNumber);
    		}
	
	int adjMatrix[][] = new int[nodeNumber+1][nodeNumber+1];
	int i,j;
	
	for (i=0;i<nodeNumber+1;i++)
	 {
		 for(j=0;j<nodeNumber+1;j++){
		adjMatrix[i][j]=0;
	 }
		
	 }
	 Set<Object> keys = adjList.keySet();
	 System.out.println("////////////////////////////////////////////////////////////////////////////");
		
	 for(Object key : keys){
 		
 //		System.out.println(key);
 		Object values = adjList.get(key);
 	//	System.out.println(values.getClass().getName());
 		ArrayList al = (ArrayList) adjList.get(key);
 		Iterator itr = al.iterator();
 		while(itr.hasNext()){
 		//	System.out.println(itr.next());
 			i=(int) key;
 			j=(int) itr.next();
 		adjMatrix[i][j]=1;
 			//	System.out.println(i);
 		//	i++;
 		}
 	//	System.out.println(adjList.get(key));
     		
 	}
	 
	
	 

	 for (i=0;i<nodeNumber+1;i++)
	 {
		 for(j=0;j<nodeNumber+1;j++){
		//	 val= adjMatrix[i][j];
			 System.out.print(adjMatrix[i][j]);
		 }
		 System.out.println();
		}
		
		File file1 = new File("Adjacency_Matrix.txt");
//		System.out.println("");
		FileWriter fileWriter=null;
		try {
			fileWriter = new FileWriter(file1);
		//	fileWriter.write("[");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 String val=null;
	 for (i=0;i<nodeNumber+1;i++)
	 {
		// fileWriter.write("[");
		 for(j=0;j<nodeNumber+1;j++){
			 val= Integer.toBinaryString(adjMatrix[i][j]);
		//	 System.out.print(val);
	// }
	//	 System.out.println();
		 	 
	// }
	 
	 
	 try{	
				fileWriter.write(val);
			//	fileWriter.write(",");
				fileWriter.flush();
				
		}catch(Exception e){
				e.printStackTrace();
		}
	 }
		 //fileWriter.write("]");
		 //fileWriter.write(",");
		 fileWriter.write("\n");
			
	}
	 //fileWriter.write("]");
		fileWriter.close();
		 
	}catch(Exception e){
		System.out.println(e);
	}


	}


public static void getIndexList(){
	
	String name;
	int recordId;
	String sql="select * from `Crawler`.`friendList`";
	ResultSet rs;
	try {
		rs = db.runSql(sql);
		while(rs.next())
	    {
         
			name = rs.getString("friendName");
			recordId = rs.getInt("recordId");
			System.out.println(rs.getInt("recordId"));
			indexList.put(name, recordId);
			
	    
	    }
		
		Set<String> keys = indexList.keySet();
		
		for(String key : keys){
    		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    		
    		System.out.println(key);
    		System.out.println(indexList.get(key));
        		
    	}
    	
	} catch (SQLException e) {
	
		e.printStackTrace();
	
	}
		
	
	
}	

public static void getFriendList()
	{
	File file = new File("Adjacency_List.txt");
//	System.out.println("");
	FileWriter fileWriter=null;
	try {
		fileWriter = new FileWriter(file);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String str=null;
	int i,j;
	System.out.println("////////////////////////////////////////////////////////////////////////////");
		
	  Set<Object> keys = adjList.keySet();
  		for(Object key : keys){
  		
  		
  		Object values = adjList.get(key);
  	 	//	System.out.println(values.getClass().getName());
  	 		ArrayList al = (ArrayList) adjList.get(key);
  	 		Iterator itr = al.iterator();
  	 		i=(int) key;
  	 		str= Integer.toString(i);

	 	  		try {
					fileWriter.write("\n");

	 	  			fileWriter.write(str);

					fileWriter.write("\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

  	 		while(itr.hasNext()){
  	 		//	System.out.println(itr.next());
  	 			j=(int) itr.next();
  		
  	 			str= Integer.toString(j);

  	 			try{	fileWriter.write(str+"  ");

  	 		
  	 	  		//System.out.println(key);
  		//str=(String)adjList.get(key);
  		//System.out.println(str);
        
			
 			//fileWriter.write(j);
 			fileWriter.flush();
  	 		
 			
 	}catch(Exception e){
 			e.printStackTrace();
 	}

  	 		}
  		//    		Object values = adjList.get(key);
//   		System.out.println(values.getClass().getName());
//   		ArrayList al = (ArrayList) adjList.get(key);
//   		Iterator itr = al.iterator();
//  		int i = 1;
 // 		while(itr.hasNext()){
//  			System.out.println(itr.next());
 // 			System.out.println(i);
 // 			i++;
 // 		}
  		
  			        		        		
  	}
  		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
}
