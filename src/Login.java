import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class Login extends javax.swing.JFrame 
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String email,pwd;
   JButton jButton1;
JButton jButton2;

JTextField jTextField1;
JPasswordField jPasswordField1;
JLabel l1;
JLabel l2;


	public Login()
	{

		


	setTitle("	LOGIN");
	
	//setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1300,799);

	setResizable(true);
	setLayout(null);
	setBackground(Color.BLUE);
	setContentPane(new JLabel(new ImageIcon("Login.png")));
	l1=new JLabel("USER NAME");
	l2=new JLabel("PASSWORD");
	jTextField1=new JTextField();
	jPasswordField1=new JPasswordField();
	l1.setForeground(Color.RED);
	
	setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

	l2.setForeground(Color.RED);
l1.setBounds(500, 280, 150, 50);
	jTextField1.setBounds(670, 280, 190, 30);
	l2.setBounds(500, 340, 150, 50);

	jPasswordField1.setBounds(670, 340, 190, 30);
	
	jButton1=new JButton("   SUBMIT     ");
	jButton1.setBounds(600, 390, 150, 50);
	jButton1.setBackground(Color.BLACK);
	jButton1.setForeground(Color.RED);
	jButton1.setFont(new Font("Serif", Font.PLAIN, 20));

	jButton2=new JButton("   ABOUT US...     ");
	jButton2.setBounds(1100, 600, 200, 50);
	jButton2.setFont(new Font("Serif", Font.PLAIN, 20));

	jButton2.setBackground(Color.DARK_GRAY);
	jButton2.setForeground(Color.RED);
add(l1);
add(jTextField1);
add(l2);
add(jPasswordField1);
	add(jButton1);

	add(jButton2);
	jButton2.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {	  JOptionPane.showMessageDialog (null, "visit@https://www.facebook.com/dswc", "Developers information", JOptionPane.INFORMATION_MESSAGE);


	  }
	}
	);
	
	//button1 action
jButton1.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent e)
	  {
		  
		  
		  
		  
		  String username=jTextField1.getText();
		  String password=jPasswordField1.getText();
		  JTextField jTextField4 = new JTextField();
		  //JTextField jTextField5 = new JTextField();


		  if(username.equals("admin")&&password.equals("dswc"))
		  {
			 
			 dispose();
			 Dashboard d=new Dashboard();
			 // d.setVisible(true);
		  }
		  else{
			  JOptionPane.showMessageDialog (null, "Try Again", "WRONG PASSWORD", JOptionPane.ERROR_MESSAGE);
			    jTextField1.setText("");
			    jPasswordField1.setText("");
			   // Login l=new Login();
		  }  
	  }
	}
);



	}
	
	





}
