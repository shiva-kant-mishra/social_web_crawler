import java.io.*;
import java.sql.*;
public class Crawler_Recursive extends Crawler_Main
{
	//public static DB db1 = new DB();
	public static ResultSet rs1;
	public static int count;
	public static String string1;
	public Crawler_Recursive()throws SQLException, IOException
	{
			
			
			try
			{
			
			 String sql="select * from crawler.record"; 
			 String url=null;
			 rs1=db.runSql(sql);
			 do{
				 while(rs1.next())
			 		 { 
						url=rs1.getString("url");
						System.out.println(url);
						processPage2(url);
						count++;
						//new FriendSearch(); 
					}
				 System.out.println(count);
				 sql="select * from Crawler.record where recordId> '"+count+"'";
				// PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// stmt.setLong(1, count);
				 rs1 = db.runSql(sql); 
			}while(rs1.next());
		}catch(Exception e)
			{
				System.out.println(e);
			}

		}
		/* String sql="select max(recordId) from crawler.record";    
		 rs1=db.runSql(sql);
		 string1=rs1.getString("max(recordId)");
		 System.out.print(string1);
		 count= Integer.parseInt(string1);
		 sql="select * from crawler.record where recordId > ("+string1+");";
		    rs = db.runSql(sql);
			
		 while(rs.next())
		 { 
			String url=rs.getString("URL");
				processPage2(url);
			
		 }
		    sql="select * from crawler.record where recordId > ("+string1+");";
		    rs = db.runSql(sql);
			new Crawler_Recursive(rs);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		*/
//	}
}
