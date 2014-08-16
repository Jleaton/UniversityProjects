import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataList implements Serializable
{

	public static void main(String[] args)
	{
		
		ArrayList data  = new ArrayList();
	
	
		
			data.add(7); 
			data.add(5);
			data.add(21);
			data.add(9);
			data.add(3);
			data.add(23);
			data.add(12);
			data.add(8);
			data.add(19);
			data.add(91);
			data.add(711);
			data.add(42);
			data.add(3006);
			data.add(3030);
			
		
		try
		{
	
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream( "data.ser"));
			out.writeObject(data);
			out.close();

		}
		catch(IOException e)
		{
			System.out.print(" file not found");

		}
	}	
	
}
