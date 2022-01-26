




import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


public class Output_fbfrndlist {
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

public static void generatePdf() throws DocumentException, SQLException, FileNotFoundException
{	
    /* Define the SQL query */
	 ResultSet query_set = stmt.executeQuery("select recordId,friendURL,friendName,Location from Crawler.friendlist order by recordId");
    /* Step-2: Initialize PDF documents - logical objects */
    Document my_pdf_report = new Document();
    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Facebook_friendlist.pdf"));
    my_pdf_report.open();            
    //we have four columns in our table
    PdfPTable my_report_table = new PdfPTable(4);
    //create a cell object
    PdfPCell table_cell;
    table_cell=new PdfPCell(new Phrase("RecordID"));
    my_report_table.addCell(table_cell);
    table_cell=new PdfPCell(new Phrase("FRIEND URL"));
    my_report_table.addCell(table_cell);
    table_cell=new PdfPCell(new Phrase("FRIEN DNAME"));
    my_report_table.addCell(table_cell);
    table_cell=new PdfPCell(new Phrase("LOCATION"));
    my_report_table.addCell(table_cell);
    while (query_set.next()) {                
                    String id = query_set.getString(1);
                    System.out.println(id);
                    table_cell=new PdfPCell(new Phrase(id));
                    my_report_table.addCell(table_cell);
                    String url=query_set.getString(2);
                    table_cell=new PdfPCell(new Phrase(url));
                    my_report_table.addCell(table_cell);
                    
                    String name = query_set.getString(3);
                    System.out.println(name);
                    table_cell=new PdfPCell(new Phrase(name));
                    my_report_table.addCell(table_cell);
                    String loc=query_set.getString(4);
                    table_cell=new PdfPCell(new Phrase(loc));
                    my_report_table.addCell(table_cell);
                    
                    }
    /* Attach report table to PDF */
    my_pdf_report.add(my_report_table);                       
    my_pdf_report.close();
    
    /* Close all DB related objects */
    query_set.close();
}

public static void main(String args[])
{
try {
	Output_fbfrndlist.generatePdf();
} catch (FileNotFoundException | DocumentException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}

  }
