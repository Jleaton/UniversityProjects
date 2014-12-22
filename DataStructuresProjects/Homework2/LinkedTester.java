import java.util.Scanner;
public class LinkedTester
{

	public static void main(String[] args)
	{	
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		Scanner user = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 1 to start or -1 to end");
		int input = user.nextInt();
	
	
		System.out.println( "Enter 0 to test add\n1 to remove\n2 to clear\n3 to test getNth\nenter 4 to print\nenter -1 to quit`"); 
			
	while(input != -1)
	{		
	
		input = user.nextInt();
		if( input == 0)
		{	
			

			System.out.println("Enter number to add");
			int number = in.nextInt();

			list.add(number);

		//	System.out.println("added " + number);
			

		}
		else
		if( input == 1)
		{	
			
			int choice = 0;
			
			System.out.println("Enter in the data that is previous to the node to remove");
			choice = in.nextInt();	
			System.out.println("looking for the node that is next to the node containing the value " + choice);
			list.remove(list.getNode(choice));
			System.out.println("Removed");


		}
		else
		if( input == 2)
		{
			list.clear();
			System.out.println("list cleared");
		}
		else
		if( input == 3)
		{	
			int choice = 0;
			
			System.out.println("enter nth element to get");
			choice = in.nextInt();
			
			System.out.println( "The " + choice+"Nth to last is " + list.getNthToLast(choice));


		}
		else
		if( input == 4)
		{

			list.print();
		}
		else
		{	System.out.println("No action erformed");}



		System.out.println("Enter another choice or -1 to quit");

			
	}			
	
		

	}



}
