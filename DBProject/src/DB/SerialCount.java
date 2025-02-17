package DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCount implements Serializable{
	
	public static void ser(int pageCount, String tname) {
		try {
			/*FileOutputStream fileOut = new FileOutputStream("./src/DB"+tname+pageIndex+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();*/
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./src/DB/"+tname+"Count"+".ser"));
			outputStream.writeObject(pageCount);
			outputStream.close();
			
            //System.out.printf("Serialized data is saved in /tmp/employee.ser");
            //System.out.println();s
            //System.out.println("after"+ vecString.get(1));
		} 
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static int deser(String tName) {
	    int x=0;
        try {
           FileInputStream fileIn = new FileInputStream("./src/DB/"+tName+"Count"+".ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           x = (int) in.readObject();
           in.close();
           fileIn.close();
           return x;
        } 
        catch (IOException i) {
           i.printStackTrace();
        } 
        catch (ClassNotFoundException c) {
           System.out.println("Employee class not found");
           c.printStackTrace();
        }
		return x;
	}

}
