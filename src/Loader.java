import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Loader extends javax.swing.JFrame  {
	Timer t;
	int i=0;
	
	public Loader()
	{
		
		  
			 this.setLocationRelativeTo(null);
			    

		


	setTitle("	SOCIAL WEBCRAWLER");
	
	//setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1300,799);

	setResizable(true);
	setLayout(null);
	setContentPane(new JLabel(new ImageIcon("2.gif")));
	

}
	public static void main(String a[])
	{
		
		Loader l=new Loader();
	}

}