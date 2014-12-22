/**
* @author Joshua Lewis Eaton
* @date September 18, 2014
* @file SinglyLinkedList.java
* @brief Class SinglyLinkedList is an implementation of a singly linked list. It also inclused iterator and node inner class implementation
* 
*/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.lang.IllegalStateException;

public class SinglyLinkedList<AnyType> implements Iterable<AnyType> 
{		
	private Node<AnyType> head;	//used to hold the first node in the list
	
	
	public SinglyLinkedList()
	{	
		
		this.head = new Node<AnyType>(null , null);	//sets initial head to null
		

	}

	public void add(AnyType element)
	{	
	
		SinglyLinkedListIterator itr = iterator();	//gets an iterator
		
		
		Node<AnyType> newNode = new Node<AnyType>( element ,null );	//holds the new Node
		

		

			while( itr.hasNext() )	//loops until last node is retrieved
			{
		
				itr.next();	//calls next which moves the itr over by one node 					
			}
			
			itr.getCurrentNode().setNextNode(newNode);	// sets the lastNode's nextNode to the new node
		
	}

	public void remove(Node<AnyType> prev)
	{
		try
		{
			if(prev.getNextNode() == null)	//ensures that the prev's next node is not null, if so throws a exception
			{ 
				System.out.println("Can not remove tail");
				throw new IllegalStateException();	//thrown if tail removal is attempted

			}		
		}
		catch( IllegalStateException E)
		{
			System.out.println(" IN REMOVE LINKEDLIST: Tail can not be removed: ILLEGAL STATE EXCEPTION");


		}
		catch( NullPointerException E)
		{
			System.out.println( "IN REMOVE LINKEDLIST:  NULL POINTER caught");

		}
		
		try
		{
			Node<AnyType> tempNode = prev.getNextNode();	//places prev's next node into tempNode
			prev.setNextNode( tempNode.getNextNode());	//sets previous nodes next node to the next node of the node being removed	
		}
		catch(  NullPointerException E)
		{


			System.out.println("IN REMOVE IN LINKLIST: NULL POINTER caught");
		}
			
		
	}

	public void clear()
	{	this.head = new Node<AnyType>(null , null); ;}	//sets head to null thus losing any link to rest of list 

	public AnyType getNthToLast( int n)
	{	
		
		SinglyLinkedListIterator itrOne = iterator();	
		SinglyLinkedListIterator itrTwo = iterator();
		AnyType nthValue = null;	//will hold the value which is in the nth to last node
		int counter = 0;
		
		while(counter < n -1 && itrOne.hasNext() == true)
		{	
			itrOne.next();
			counter++;
		}
		counter = 0;
		while(itrOne.hasNext() != false)
		{
			nthValue = itrTwo.next();
			itrOne.next();
			

		}
		
	

		return nthValue;	
		
	}

	public void print()
	{

		SinglyLinkedListIterator itr = iterator();
	
		try
		{	System.out.println( itr.current.getData());
			while( itr.hasNext())
			{	
				 itr.next();
				System.out.println( itr.current.getData());
			}
		}
		catch(NullPointerException E)
		{
			System.out.println( "The list is empty");

		}
	}

	public SinglyLinkedListIterator iterator()
	{	return new SinglyLinkedListIterator(this.head); }

	public Node<AnyType> getNode(AnyType x)//gets node by the element it contains
	{	
		SinglyLinkedListIterator itr = iterator();
		Node<AnyType> tempNode = this.head;
		Node<AnyType> node = null;
		AnyType data = tempNode.getData();
		
		
		while( x.equals(data) == false && itr.hasNext() == true )
		{
			
			node = tempNode.getNextNode();//gets next node
			data = node.getData();//gets the node with data in it
			itr.next();	//moves the itr over one
			tempNode = itr.getCurrentNode();	
		
		}

		return node;
	}

	

	
	
	protected class SinglyLinkedListIterator implements Iterator<AnyType>
	{
		
		private Node<AnyType> current;	//will hold the current node that the itr is over
		private Node<AnyType> previous;	

		public SinglyLinkedListIterator(Node<AnyType> startingPoint )
		{	
			this.current = startingPoint;	//sets the starting point
			this.previous = startingPoint;
			
		}
		
		public boolean hasNext()
		{	
			boolean hasNext = false;
						
			
			try
			{

				if(this.current != null)
				{
					if(this.current.getNextNode() != null)//checks if there is another node
					{
						hasNext = true;	//sets to true if another node found

					}
					else
					{
						hasNext = false;

					}
				}
				else
				{
					hasNext = false;
				}
			}
			catch( NullPointerException E)
			{

				System.out.println( "IN HASNEXT(): Null pointer caught");

			}
			return hasNext;
		}
		
		public AnyType next()	
		{	
			AnyType value = null;

			if( hasNext() == false)
			{ throw new NoSuchElementException();}
			

			this.previous = this.current;	//saves the old current 
			this.current = this.current.getNextNode();//updates current to the next node since it shifted up one
			
			value = this.current.getData();//gets the value of nextNode which is what the method must return
			
			
			return value;	//returns value which contains the data extracted from the node
		}

		public Node<AnyType> getCurrentNode()
		{
			return this.current;

		}
		
		public void remove() 
		{	
			
			
			if( this.current.getNextNode() == null)
			{ throw new IllegalStateException();} 
		
		
			try
			{
				this.previous.setNextNode(this.current.getNextNode());//sets the previous nodes next to currents next thus skipping over the node to be removed
			
					
				this.current = this.current.getNextNode();
			}
			catch(NullPointerException E)
			{
				System.out.println( "The List is empty");

			}
		}

	
		
	
		public void add(AnyType element)
		{	
			Node<AnyType> newNode = new Node<AnyType>(element, null);
		
			newNode.setNextNode(this.current.getNextNode());	//sets the new nodes next reference to the node current previously referenced which was next

			this.current.setNextNode(newNode);
			
				
		}	//end class
	}
	private class Node<AnyType>
	{	
		private AnyType data;	//holds the data in the node
		private Node<AnyType> nextNode;	//holds reference to the next node

		public Node(AnyType element, Node<AnyType> node)
		{
			this.data = element;	//sets the nodes data to the data passed in
			this.nextNode = node;	//sets the nodes nextNode to the node directly after it

		}
		
		public AnyType getData()
		{	return data;	}

		public Node<AnyType> getNextNode()
		{	return nextNode; }

		public void setNextNode(Node<AnyType> node)
		{	nextNode = node;	}
	}	//end class


}	//end class
