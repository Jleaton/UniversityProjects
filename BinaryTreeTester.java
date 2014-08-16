import junit.framework.TestCase;
import java.util.ArrayList;

public class BinaryTreeTester extends TestCase
{
	private int value;	//is used to store a int number into value for the Binary tree's constructor that request an int argument
	BinaryTree tree;	//initializes tree of type BinaryTree
	ArrayList numList = new ArrayList();	//will hold numbers 1 through 5 stored in numerical order from least to greatest
		


	@Override
	public void setUp()	//sets up the value needed, the BinaryTree to be used and stores numbers 1 through 5 into ArrayList 
	{	
		
		tree = new BinaryTree(0);	//creates a tree with default value of 0
		value = 10;	//sets the value to 10 for use in the constructor test 
		for( int i = 0; i == 5; i++)	//adds numbers 1 through 5 into the array list in order
		{
			numList.add(i);	//adds the counter value possesed to the arraylist

		}	//end for loop
	

	}	//end method setUp


	public void testBinaryTreeConstructor()	//checks if the no argument constructor initializes correctly
	{
	

		assertTrue(tree.getData() == 0);	//checks if the data possessed is equal to 0 if so, we know that it correctly set to 0
		assertTrue(tree.getLeftSubtree() == null);	//checks if the leftsubtree is null, if so we know that it was constructed correctly
		assertTrue(tree.getRightSubtree() == null);	//checks if the rightsubtree is null, if so we know that it was constructed correctly
		assertTrue(tree.getRoot() == null);	//chekcs if the rightsubtree is null, if so we know that it was constructed correctly

	}	//end method testBinaryTreeConstructor

	public void testArgumentConstructor()	//test a the constructor when provided a value argument and also the root, left and right subtree set and get methods
	{

		tree = new BinaryTree(value);	//creates a new binary tree with a predetermined value of 10
		
		BinaryTree root = new BinaryTree(2);	//creates a new binary tree that is to be the root
		BinaryTree left = new BinaryTree(0);	//creates a new binary tree that is to be the left child
		BinaryTree right = new BinaryTree(0);	//creates a new binary tree that is to be the right child
		
		tree.setRoot(root);	//sets the root to a BinaryTree called root 
		tree.setLeftSubtree( left);	//sets the left child to a BinaryTree called left
		tree.setRightSubtree( right);	//sets the right child to a BinaryTree called right
	
		assertTrue(tree.getData() == 10);	//checks if it is true that the number 10 was passed correctly through the constructor
		assertTrue(tree.getRoot() == root);	//checks if the setRoot method correctly set the root provided by comparing it to root
		assertTrue(tree.getLeftSubtree() == left);	//checks if the setLeftSubtree method correctly set the left child 
		assertTrue(tree.getRightSubtree() == right);	//checks if the setRightSubtree method correctly set the right child 

	}	//end method testArgumentConstructor
	
	public void testPrintOrder()	//test if the inOrder method prints the numbers in numerical order
	{
		
		assertTrue( tree.getArrayList().equals(numList) == true);	//compares an arraylist of numerical sorted numbers to a preditermined numericaly sorted arraylist

	}	//end method testPrintOrder

}	//end class BinaryTreeTester
