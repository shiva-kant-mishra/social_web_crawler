

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class Google_output extends JFrame
{
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



	public Google_output()
	{

		


	setTitle("	GOOGLE OUTPUT");
	
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1023,799);

	setResizable(true);
	//setLayout(new BorderLayout());
	
	setContentPane(new JLabel(new ImageIcon("crawler.jpg")));
	
	
	setLayout(new FlowLayout(FlowLayout.CENTER));

	setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	//setLayout(null);
image= new ImageIcon("WEBCRAWLER.gif");

b3=new JButton("    SHOW     ");
b3.setBounds(10, 10, 30, 20);

add(b3);
	b1=new JButton("    EXIT     ");
	b1.setBounds(10, 10, 30, 20);

	add(b1);
	
	
	b4=new JButton("    BACK     ");
	b4.setBounds(10, 10, 30, 20);

	add(b4);
	
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
  {Dashboard d=new Dashboard();
	 dispose();

  }
}
);

b3.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
	  JOptionPane.showMessageDialog (null, "Google+ scraping coming soon", "coming soon", JOptionPane.INFORMATION_MESSAGE);

  }
}
);

b1.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {System.exit(0);

  }
}
);


	}


	



}
