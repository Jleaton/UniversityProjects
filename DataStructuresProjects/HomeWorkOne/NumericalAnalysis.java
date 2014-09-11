/**
* @author Joshua Lewis Eaton
* @date September 10, 2014
* @file NumericalAnalysis.java
* @brief Class NumericalAnalysis is used to computate f(x) = 0 using binary search.
* you must specify the low and high values.
*/


import java.util.Scanner;

public class NumericalAnalysis
{

	public static void main(String[] args)
	{	
		double root = -1;

		Scanner input = new Scanner(System.in);

		System.out.println( "Enter in a low value ");
		double low = input.nextDouble();	//places the users choice for the low value into low
		System.out.println( "Enter in a high value ");
		double high = input.nextDouble();	//places the users choice for the high value into high
	
		FunctOb function = new FunctOb();	//creats a new FunctOb called function
		root = solveForZero( function , low , high);	//passes the function containing method f , the low value, and the high value and assigns the returned value to root
	
		System.out.println( " the root is " + root );
		

	}
	
	
	/**
	* @param f which expects an object that implements Function interface
	* @param low which expects a double to represent the low end
	* @param high which expects a double to represent the high end
	*/
	public static double solveForZero(FunctOb f, double low , double high)
	{		
		double mid = (low + high) / 2;	//sets currentMid to the middle of low and high
		double currentVal = mid;	//will hold the root when it is found
		double root = -1;	//is -1 until the root is found
		boolean isRoot = false;	//is false until the root is found
		double threshold =  0.0000000000000001;	//ensures exact precision in finding the correct root 

		while( high - low >= threshold && isRoot != true)	//while the subtrahend of high and low is greater or equal to  threshold and isRoot is not true
		{	
			
		
			currentVal = f.f(mid);	//passes mid value to evaluate how close it is to reaching 0 when entered into a specific function
			
			if( f.f(low) == 0 || f.f(high) == 0)	//if either high or low is 0, the return true and set currentVal to either high or lows value
			{	
				currentVal = low;	//sets current val to low's value
				if(f.f(high) == 0)	//if high entered into f(x) returns 0 we know it is the root and thus assign it to currentVal to be returned
				{
					currentVal = high;	//assigns the value of high to currentVal
				}
					isRoot = true;	//isRoot becomes true which breaks the loop

			}
	
			
		
			if( f.f(currentVal) == 0)	//if the value passed  into the function is equal to 0 the root is found thus set isRoot to true
			{
				isRoot = true;	//sets isRoot to true escape the loop
			}



			if( f.f(currentVal) < 0 )	//if the value returned is lower then the value needed to obtain 0 then move higher 
			{	
				low = mid;	//sets the new low to mid's value
				mid = (low + high) / 2;	//updates new mid by dividing the low and high values by 2
		
			}
			
			if( f.f(currentVal) > 0)	//if the value returned is higher then the value needed to obtain 0 the move lower
			{	
				high = mid;	//sets the new high to mid's value

				mid = (high + low) / 2;	//updates mid by dividing the high and low by 2
			}


		
		}	
		
		root = currentVal;	//sets the root to the currentVal  
		
		return root;	
	}




}
