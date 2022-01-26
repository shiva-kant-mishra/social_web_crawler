import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.sql.SQLException;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class Dashboard extends JFrame
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton jButton1;
JButton jButton2;
JButton jButton3;
JButton jButton4;

public static String email,pwd;
public static String crawlerurl,crawlertype,gmailemail,gmailpwd;
  Object frame0;
  JPasswordField jPasswordField1=new JPasswordField();
  JPasswordField jPasswordField2=new JPasswordField();
//Dashboard d=new Dashboard();
JTextField jTextField1 = new JTextField();
JTextField jTextField4 = new JTextField();
JTextField jTextField2 = new JTextField();
//JTextField jTextField5 = new JTextField();
JTextField jTextField3 = new JTextField();
	public Dashboard()
	{

		


	setTitle("	DASHBOARD");
	
	//setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1300,799);

	setResizable(true);
	setLayout(null);
	setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

	
	//setBackground(Color.BLUE);
	setContentPane(new JLabel(new ImageIcon("Dashboard_main.png")));
	jButton1=new JButton(" CRAWLER ");
	jButton1.setBounds(700, 150, 250, 50);
	jButton1.setBackground(Color.BLACK);
	jButton1.setForeground(Color.RED);
	jButton1.setFont(new Font("Serif", Font.PLAIN, 32));

	add(jButton1);
    jButton2=new JButton("FACEBOOK");
	jButton2.setBounds(700, 250, 260, 50);
	jButton2.setBackground(Color.BLACK);
	jButton2.setForeground(Color.RED);
	jButton2.setFont(new Font("Serif", Font.PLAIN, 32));

    add(jButton2);
    jButton3=new JButton("   GOOGLE     ");
	jButton3.setBounds(700, 350, 250, 50);
	jButton3.setBackground(Color.BLACK);
	jButton3.setForeground(Color.RED);
	jButton3.setFont(new Font("Serif", Font.PLAIN, 32));

   add(jButton3);
    jButton4=new JButton("WHAT NEXT ?");
	jButton4.setBounds(700, 450, 300, 50);
	jButton4.setBackground(Color.BLACK);
	jButton4.setForeground(Color.RED);
	jButton4.setFont(new Font("Serif", Font.PLAIN, 32));

	add(jButton4);
    
	jButton1.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {
		  crawler_dashboard d=new crawler_dashboard();
		 dispose();

	  }
	}
	);

	

	jButton3.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {
		  Object[] message = {
				    "emailid:", jTextField4,
					    "password:", jPasswordField2,};
					    
					    int option;
					    UIManager.put("OptionPane.background", new Color(255,102,51));


						option = JOptionPane.showConfirmDialog(null, message, "Enter ur gmail login details", JOptionPane.OK_CANCEL_OPTION);
						if (option == JOptionPane.OK_OPTION)
						{
						    
							 gmailemail = jTextField1.getText();
							 gmailpwd = jPasswordField2.getText();
						     System.out.println(email);
						   //  System.out.println(pwd);
					dispose();
//					Google_output go=new Google_output();

			//		((Window) go).setVisible(true);
						   //  d.dispose();
						  //   StringSearch.obj.setVisible(true);
						     
					   
			     
		  try {
				HttpUrlConnectionExample.main2(gmailemail, gmailpwd);
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				//Crawler_Main.main11();
 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			     
			     
			}
	  }
	});


	jButton4.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {	  JOptionPane.showMessageDialog (null, "AnY iDeA???????", "what next??", JOptionPane.INFORMATION_MESSAGE);


	  }
	}
	);
	jButton2.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {		
		  Facebook_Dashboard  fd=new Facebook_Dashboard();
		  dispose();
		  
 
	  }
	});


	}

	



}
