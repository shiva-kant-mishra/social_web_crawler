import javax.swing.*;
import javax.swing.border.Border;

import com.itextpdf.text.DocumentException;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class crawler_dashboard extends JFrame
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton b1;
JButton b2;
JButton b3;

JTextField jTextField1 = new JTextField();
JTextField jTextField2 = new JTextField();



public static String crawlerurl,crawlertype;

	public crawler_dashboard()
	{

		


		setTitle("	CRAWLER DASHBOARD");
		
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	    this.setLocationRelativeTo(null);
		setBounds(30,0,1300,799);

		setResizable(true);
		setLayout(null);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		//setBackground(Color.BLUE);
		setContentPane(new JLabel(new ImageIcon("crawler.jpg")));
		b1=new JButton("   CRAWL    ");
		b1.setBounds(600, 200, 150, 50);
	    add(b1);
	    b2=new JButton("   SHOW    ");
		b2.setBounds(600, 300, 150, 50);
	    add(b2);
	    b3=new JButton("   BACK     ");
		b3.setBounds(600, 400, 150, 50);
	    add(b3);
	 
		

b1.addActionListener(new ActionListener()
{
 

public void actionPerformed(ActionEvent e)
  {
	  Object[] message = {
			    "Seed_URL:", jTextField1,
			    "Https/Http:",  jTextField2,};
			    
			    int option;
			    UIManager.put("OptionPane.background", new Color(255,102,51));

			option = JOptionPane.showConfirmDialog(null, message, "Enter crawling  details", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION)
			{
			    
			     crawlerurl = jTextField1.getText();
			     crawlertype =  jTextField2.getText();
			   //  System.out.println(email);
			   

				  dispose();
				  try {
					  Crawler_Main.Crawler_Main11(crawlerurl);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   
			     
			     
			}
	  }
  });


b2.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {dbb dbbb=new dbb();
  try {
	dbbb.show();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	 dispose();

  }
}
);

b3.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
	 
	  Dashboard d=new Dashboard();
	  dispose();
}

});





	
	}
	}
