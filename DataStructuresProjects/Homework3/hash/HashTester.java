import java.util.Scanner;

public class HashTester
{




      
     // Simple main
        public static void main( String [ ] args )
        {	

		
		Scanner input = new Scanner(System.in);
		int userInput = 0;
		
		while(userInput != -1)
		{

		
			System.out.println(" Enter 0 to test literal inserts, enter 1 to test repetition inserts");

			userInput = input.nextInt();


			if( userInput == 0)
			{

				testOne();

			}
			else
			if( userInput == 1)
			{
				int counter = 27;
				double averageTime = 0;

				System.out.println( " Enter insert repetitions to test for");
				Scanner in = new Scanner(System.in);
				int reps = in.nextInt();
				System.out.println( " Testing for " + reps + " inserts" );
				System.out.print( "For " + reps + "elements, the insert time is " );


						
				while(counter != 0)
				{
				
					double startTime = System.nanoTime();
					testTwo(reps);
					double endTime = System.nanoTime();

					double duration = (endTime - startTime);
					System.out.printf("%.1f\n", duration);
					
					if(counter != 27)
					{
					averageTime = averageTime + duration;
					}
					
					counter--;			
					
				}

				
				averageTime = averageTime/27;				


				System.out.println( " THE AVERAGE IS " + averageTime);


				
			}
			else
			{
				System.out.println(" No choice");
			}
	

		}
	


      
	}


	public static void testOne()
	{
	      QuadraticProbingHashTable H = new QuadraticProbingHashTable( );


	
             int[] data = {1 , 20, 50 , 100 , 1000, -7 , 17 , 89 , 57 , 0 , -42};  
	
	     for( int i = 0; i < data.length; i++)
	     {
         	double startTime = System.nanoTime();
			H.insert(  new MyInteger(i));
	
		double endTime = System.nanoTime();
	
		double duration = (endTime - startTime);
		System.out.print( "For " + data[i] + " the insert time is " );
		System.out.printf("%.1f\n", duration);
	     }



	}

	public static void testTwo(int inserts)
	{
		 QuadraticProbingHashTable H = new QuadraticProbingHashTable( );
			

		 int counter = 0;

		while( counter <= inserts)
		{
			H.insert(  new MyInteger(counter));
						
			counter++;
			
		}

	}

} 
