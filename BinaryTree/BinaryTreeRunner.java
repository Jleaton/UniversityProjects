//==========
//Author: Joshua Eaton
//Class: CSCI 2120
//Term: Spring 2014
// 
//
//==========



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.lang.ClassNotFoundException;

public class BinaryTreeRunner
{
	static ArrayList list;	//instantiates ArrayList
	private static int counter = 0;	//initializes counter to 0
	static BinaryTree tree = new BinaryTree(0);	//creates a binary tree


	public static void main(String[] args)
	{	
		ObjectInputStream objectReader;	//instantiates ObjectInputStream
		
	
		try	//try to  deserialize the object that is in data.ser and read it into list of type ArrayList
		{
	
			objectReader = new ObjectInputStream( new FileInputStream( args[0] ));	//stores object that was serialized into objectReader
			list = (ArrayList) objectReader.readObject();	//parses and deserializes the object read from the file into list of type ArrayList
			objectReader.close();	//closes objectReader

		}
		catch(IOException e)	//catches exception if file could not be read
		{

			System.out.println(" The file could not be read");

		}
		catch(ClassNotFoundException n)	//catches exception if class could not be found
		{

			System.out.println( "Class was not found");
		}

	
		addTree();	//calls method addTree to add tree
		
		if(counter == list.size())	//checkts to make sure all the values have been inserted into the tree if so the it traverses in order to print
		{
			tree.inOrder(tree.getRoot());	//prints out the numbers stored in the binary tree in numerical order
		}
		
		
		
	}

	public static void addTree()	//recursive method that will continually add treess to the tree
	{	
	
		if(counter >= list.size())	//base case states that if counter is bigger then amount of numbers provided stop making trees to insert
		{
			return;	//return back to the main method once the base case is reached

		}
		else
		{
						
			
			int number;	//stores the value of int type
		
			number = (int)list.get(counter);	//cast the returned value to int since arrayList is being used 
			counter++;	//adds one to counter	
		
			
		
			tree.insert(number);
			addTree();	//calls addNode recursively to add a node to the binary tree
			
		}

		


	}	//end method addTree

	public int getListSize()
	{
		int n = list.size();
		
		return n;
	
	}



		


}	//end class BinaryTreeRunner
