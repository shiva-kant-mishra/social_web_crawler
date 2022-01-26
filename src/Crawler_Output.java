import javax.swing.*;
import javax.swing.border.Border;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class Crawler_Output extends JFrame
{
	//static Crawler_Output co=new Crawler_Output();
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton b1;
JButton b3;
JButton b4;

JLabel l1;
JLabel l2;

JTextField t1;

public  JTextArea t2;
ImageIcon image;



	public  Crawler_Output()
	{

		


	setTitle("	CRAWLER OUTPUT");
	
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1023,799);

	setResizable(true);
	setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

	//setLayout(new BorderLayout());
	
	setContentPane(new JLabel(new ImageIcon("crawler.jpg")));
	
	
	setLayout(new FlowLayout(FlowLayout.CENTER));
	
	//setLayout(null);
image= new ImageIcon("WEBCRAWLER.gif");

b3=new JButton("    PDF     ");
b3.setBounds(10, 10, 30, 20);

add(b3);

b4=new JButton("    BACK     ");
b4.setBounds(10, 10, 30, 20);

add(b4);
	b1=new JButton("    EXIT     ");
	b1.setBounds(10, 10, 30, 20);

	add(b1);
	
	
	
	
	t2=new JTextArea(40,100);
	b1.setForeground(Color.RED);;
	//t2.setBounds(50,50,50,90);
 	
t2.setBackground(Color.BLACK);
t2.setForeground(Color.RED);
	add(t2);
	
add(new JScrollPane(t2), BorderLayout.SOUTH);

b4.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {crawler_dashboard d=new crawler_dashboard();
	 dispose();

  }
}
);


b3.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
	  try {
		Crawler_pdf.generatePdf();
	} catch (FileNotFoundException | DocumentException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	  JOptionPane.showMessageDialog (null, "PDF", "PDF ahs been Generetaed", JOptionPane.INFORMATION_MESSAGE);

  }
}
);

b1.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
	 System.exit(0);

  }
}
);




	}
	
	
	
	
	
	
	

public static void main(String args[])
{
	
	Crawler_Output c=new Crawler_Output();
	//co.Output();
		//co.setVisible(true);
//	co.show();
}
	



}
