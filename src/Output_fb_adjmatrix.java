 import java.io.FileReader;
import java.io.IOException;
 
/**
 * This program demonstrates how to read characters from a text file.
 * @author www.codejava.net
 *
 */
public class Output_fb_adjmatrix {
 
	
     void list() {
        try {
        	
        	
            FileReader reader = new FileReader("Adjacency_Matrix.txt");
            int character;
            adjmatrix aa=new adjmatrix();
           // aa.setVisible(true);
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
              aa.t2.append(""+(char) character);
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     
     
    
   
 
}