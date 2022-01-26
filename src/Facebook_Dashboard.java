import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.sql.SQLException;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class  Facebook_Dashboard extends JFrame
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton friendlist;
JButton adjmatrix;
JButton adjlist;
JButton graph;
JButton fbcrawl;
JLabel l1;
JLabel l2;

public String email,pwd;

JTextField jTextField1 = new JTextField();
JPasswordField jPasswordField1=new JPasswordField();

ImageIcon image;



	public  Facebook_Dashboard()
	{

		


	setTitle("	FACEBOOk DASHBOARD");
	
	//setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1300,799);

	setResizable(true);
	setLayout(null);
	setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

	//setBackground(Color.BLUE);
	setContentPane(new JLabel(new ImageIcon("Dasboard_fb.png")));
	fbcrawl=new JButton("   FB CRAWLING     ");
	fbcrawl.setBounds(900, 100, 150, 50);
    add(fbcrawl);
	
	friendlist=new JButton("   FRIENDLIST     ");
	friendlist.setBounds(900, 200, 150, 50);
    add(friendlist);
    adjmatrix=new JButton("   ADJENCY MATRIX     ");
	adjmatrix.setBounds(900, 300, 150, 50);
    add(adjmatrix);
    adjlist=new JButton("   ADJENCY LIST     ");
	adjlist.setBounds(900, 400, 150, 50);
    add(adjlist);
    graph=new JButton("   GRAPH     ");
	graph.setBounds(900, 500, 150, 50);
    add(graph);
	


    
    fbcrawl.addActionListener(new ActionListener()
   	{
   	  public void actionPerformed(ActionEvent e)
   	  {
   		  
   		 Object[] message = {
   			    "username/emailid:", jTextField1,
   			    "password:", jPasswordField1,};
   			    
   			    int option;
   			    UIManager.put("OptionPane.background", new Color(255,102,51));

   			option = JOptionPane.showConfirmDialog(null, message, "Enter ur facebook login details", JOptionPane.OK_CANCEL_OPTION);
   			if (option == JOptionPane.OK_OPTION)
   			{
   			    
   				 email = jTextField1.getText();
   				 pwd = jPasswordField1.getText();
   			     System.out.println(email);
   			  
  			 // a.setVisible(true);
 						   //  System.out.println(pwd);
 				//aa a=new aa();	
   			     dispose();
 					
// 					Google_output go=new Google_output();

 			//		((Window) go).setVisible(true);
 						   //  d.dispose();
 						  //   StringSearch.obj.setVisible(true);
 						     
 					   
 			     
 		  try {
 			
 			 
 		//  aa a=new aa();
 				TestHtmlUnit.FBLogin(email, pwd);
 		} //Crawler_Main.main11();
  catch (Exception e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
 			     
 			     
 			} 

   	  }
   	}
   );

    
    
    friendlist.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {
		  
		  output_fb_friendlist fblist=new output_fb_friendlist();
		  try {
			fblist.show();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 dispose();

	  }
	}
);

    

    adjmatrix.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  { Output_fb_adjmatrix a=new Output_fb_adjmatrix();
	  a.list();
		 dispose();

	  }
	}
);
   

    
    adjlist.addActionListener(new ActionListener()
	{
  	  public void actionPerformed(ActionEvent e)
  	  {
  		Output_fb_list fa=new Output_fb_list();
  		  fa.list();
  		 dispose();
  	  }
  	}
  );


    graph.addActionListener(new ActionListener()
	{
  	  public void actionPerformed(ActionEvent e)
  	  {
		  JOptionPane.showMessageDialog (null, "Visit website www.graphonline.ru for graph", "GRAPH VISUALISTAION", JOptionPane.ERROR_MESSAGE);

  		 
  	  }
  	}
  );

	}


	



}
