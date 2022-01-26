



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class output_fb_friendlist {
	
	
	static Connection conn=null;
	static Statement stmt=null;
	static Scanner sc=new Scanner(System.in);
	static{
		try{
			 Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/crawler";
				conn = DriverManager.getConnection(url,"root","sumit");
				stmt=conn.createStatement();			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void show() throws SQLException
	{
		friendlist a=new friendlist();
	    ResultSet query_set = stmt.executeQuery("select recordId,friendURL,friendName,Location from Crawler.friendlist order by recordId");
	    while (query_set.next()) {                
            String id = query_set.getString(1);
            String url = query_set.getString(2);
            
            
            String name = query_set.getString(3);
            String loc = query_set.getString(4);
            System.out.println(""+id+ "\t"+url+"\t"+name+"\t"+loc);
            a.t2.append(""+id+ "\t"+url+"\t"+name+"\t"+loc);
            
            a.t2.append("\n");
            
            
            }
	    query_set.close();
	}
	
	
	
}
