//==========
//Author: Joshua Eaton
//Class: CSCI 2120
//Term: Spring 2014
// 
//
//==========
import java.util.ArrayList;
public class BinaryTree
{
	
	private int data;	//used to hold the int value that each tree object instance will possess
	private BinaryTree leftSubtree;		//creates a leftSubtree of type BinaryTree which will store references to to other tree object
	private BinaryTree rightSubtree;	//creates a rightSubtree of type BinaryTree which will store references to other tree object
	private	BinaryTree root;	//used to store the root tree of the binary tree
	private BinaryTree parentTree;	//parentTree is used to store the parent tree which we can use to compare our current value to 
	private	ArrayList list = new ArrayList();
	


	public BinaryTree(int value)	//constructor which creates our tree
	{
		this.data = value;	//assigns value to this.data which will hold the integer value
		this.leftSubtree = null;	//creates null references for leftSubtree until assigned a tree object
		this.rightSubtree = null;	//creates null references for rightSubtree until assigned a tree object


	}	//end constructor

	public int getData()	//method getData is used to retrieve the private int variable possessed by each instance of a tree object
	{
		return this.data;	//returns the data possessed by this instance of the object

	}	//end method getData

	public BinaryTree getLeftSubtree()
	{	

		return this.leftSubtree;

	}

	public void setLeftSubtree(BinaryTree leftTree)
	{
		this.leftSubtree = leftTree;


	}
	public BinaryTree getRightSubtree()
	{

		return this.rightSubtree;

	}

	public void setRightSubtree(BinaryTree rightTree)	//used to access the private access rightSubtree object object and change it
	{
		this.rightSubtree = rightTree;	//sets the rightSubtree to a new rightSubtree object given

	}

	public void setRoot(BinaryTree newRoot)	//used to access the private access root BinaryTree object and change
	{
		root = newRoot;	//sets the root to the new root provided
		
	}

	public BinaryTree getRoot()	//used to retrieve the BinaryTree object stored in root
	{
		return root;	//returns the object stored in the root

	}

	public ArrayList getArrayList()	//gets the arraylist
	{
		return list;	//returns the ArrayList that stored the values in numerical order

	}


	public void insert( int value)	//this method is used to insert a tree into the proper location
	{	
	
	
	
		BinaryTree currentTree = new BinaryTree(value);	//creates a new current binary tree looking for insertion		
		
		if( root == null)	//adds the first tree which is the root if it is null
		{
			root = new BinaryTree(value);	//creates a new BinaryTree and stores it at the root
		 	parentTree = root;	//assings the root to be the parentTree
			 
			return;
		}	//end of if statement

		
		else
		{
			if( value <= parentTree.getData())	//evaluates if current tree is less then the parentTree if so go on the left
			{
				if( parentTree.leftSubtree == null)	//base case checks if tree's leftSubtree is empty if so then add current tree
				{	
					parentTree.leftSubtree = currentTree;	//places the current tree into the left subtree of the parent
					parentTree = root;	//resets the parentTree to root so that next time we restart at the root for accuracy
					return;	
				}
				
				else	//since the parent tree's leftSubtree is not null we do the following
				{
					parentTree = parentTree.leftSubtree;	//assign the tree that was in the leftSubtree to parentTree 
					insert(value);	//recursive method call to reavaluate the new parentTree; does so until base case is reached

				}
			
			}


			else if(value > parentTree.getData())	//evaluates if current tree is greater then the parentTree if so go on the right
			{
				if( parentTree.rightSubtree == null)	//base case checks if tree's leftSubtree is empty if so then add current tree
				{		
					parentTree.rightSubtree = currentTree;	//places the current tree instance into the rightSubtree
					parentTree = root;	//reasigns the parentTree as the root so that it will restart at the root for accuracy
					return;
				}
				else	//since the parent tree's rightSubtree is not null we do the following
				{	
					parentTree = parentTree.rightSubtree;	//assign the tree that was in the rightSubtree to parentTree
					insert(value);	//recursive method call to reavaluate the new parentTree and continue to check for null children; 
	
				}
			}

			
		}	//end of else statement

	

	}	//end method insert

	public void inOrder(BinaryTree root)	//method inOrder prints the numbers stored in the binary tree in order
	{	
	
		
		
		

		
		if(root != null)	//checks if the root is null if not then it knows there is a tree to traverse
		{
	
		inOrder(root.leftSubtree);	//recursive call that repeatedly checks if there is a left child
		list.add(root.getData());	//adds the value that is printed to the ArrayList
	
		System.out.println( root.getData());	//prints the value held by a tree once it is down to a tree with no left child or and also no right child

		
		inOrder(root.rightSubtree);	//recursive call that repeatedly chekcs if there is a right child
		list.add(root.getData());	//adds the value that is printed to the ArrayList
	
		
		}
	

	}	//end method inOrder




}	




