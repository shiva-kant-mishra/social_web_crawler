import javax.swing.*;
import javax.swing.border.Border;

import com.itextpdf.text.DocumentException;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class friendlist extends JFrame
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton b1;
JButton b2;
JButton b3;
JButton b4;

JLabel l1;
JLabel l2;

JTextField t1;

public  JTextArea t2;
ImageIcon image;



	public friendlist()
	{

		


	setTitle("	FACEBOOK FRIENDLIST OUTPUT");
	
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
    this.setLocationRelativeTo(null);
	setBounds(30,0,1300,799);

	setResizable(true);
	//setLayout(new BorderLayout());
	
	setContentPane(new JLabel(new ImageIcon("fb_output.png")));
	
	
	setLayout(new FlowLayout(FlowLayout.RIGHT));

	setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	//setLayout(null);
image= new ImageIcon("WEBCRAWLER.gif");
	b1=new JButton("    PDF     ");
	b1.setBounds(10, 10, 30, 20);

	add(b1);
	b2=new JButton("    BACK     ");
	b2.setBounds(10, 10, 30, 20);

	add(b2);
	b3=new JButton("    EXIT     ");
	b3.setBounds(10, 10, 30, 20);
add(b3);
	
	
	t2=new JTextArea(40,100);
	
	//t2.setBounds(50,50,50,90);
 	
t2.setBackground(Color.BLACK);
t2.setForeground(Color.RED);
	add(t2);
	
add(new JScrollPane(t2), BorderLayout.SOUTH);


b1.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
	  try {
		  Output_fbfrndlist.generatePdf();
	} catch (FileNotFoundException | DocumentException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	  JOptionPane.showMessageDialog (null, "PDF has been Generated", "PDF ", JOptionPane.INFORMATION_MESSAGE);

  }
}
);


b2.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {Facebook_Dashboard d=new Facebook_Dashboard();
	 dispose();

  }
}
);

b3.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {System.exit(0);

  }
}
);

	}


	



}
