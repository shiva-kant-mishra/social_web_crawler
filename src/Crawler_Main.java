
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class Crawler_Main {
	

	public static Crawler_DB db = new Crawler_DB();
	//static Crawler_Output oc=new Crawler_Output();
                
    
	public static void Crawler_Main11(String crawlerurllocal) throws SQLException, IOException {
		
		System.setProperty("jsse.enableSNIExtension", "false");
		db.runSql2("TRUNCATE Record");
		processPage("https://"+crawlerurllocal);
		
		System.out.println("Index Page crawling finished");
	//	String sql="select * from crawler.Record where recordID>1";
	//	ResultSet rs = db.runSql(sql);
		new Crawler_Recursive();
		 			
	}
 
	public static void processPage(String URL) throws SQLException, IOException
	{
		//check if the given URL is already in database
		String sql = "select * from Record where url = '"+URL+"'";
		ResultSet rs = db.runSql(sql);
		//System.out.println(rs);
		try{
			if(rs.next())
		    {
             System.out.println("Already exists"+URL);
            }
		  else
		  {
			//store the URL to database to avoid parsing again
			  System.out.println(URL);
			sql = "INSERT INTO  `crawler`.`record` " + "(`URL`) VALUES " + "(?);";
			PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, URL);
			stmt.execute();
			//count++;
 
			//get useful information
			Document doc = Jsoup.connect(URL+"/").get();
 
			//if(doc.text().contains("research")){
				//System.out.println(URL);
			//}
			
			  //get all links and Crawler_Recursively call the processPage method
			  Elements questions = doc.select("a[href]");
			   for(Element link: questions)
			   {
				//if(link.attr("href").contains("http://")||link.attr("href").contains("https://"))
					//processPage(link.attr("abs:href"));
				{	System.out.println(link.attr("abs:href"));
					sql = "INSERT INTO  `crawler`.`record` " + "(`URL`) VALUES " + "(?);";
				stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, link.attr("abs:href"));
				stmt.execute();
				}
			   }
		  }   
		}catch(Exception e){
			System.out.println(e);
		}
		
     }
	
	
	public static void processPage2(String URL) throws SQLException, IOException
	{
	try{Document doc = Jsoup.connect(URL+"/").get();
	  Elements questions = doc.select("a[href]");
	   for(Element link: questions)
	   {
			System.out.println(link.attr("abs:href"));
	 		String sql = "INSERT INTO  `crawler`.`record` " + "(`URL`) VALUES " + "(?);";
		PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, link.attr("abs:href"));
		stmt.execute();
		
	   }
	}catch(Exception e){
			System.out.println(e);
	}
    }
	
}