/**
* @author Joshua Lewis Eaton
* @date December 5, 2014
* @file GraphInitializer.java
* @brief Class GraphInitializer is used to fill the Graph with the data from input files 
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GraphInitializer
{
	private String inputFileName;
	private String cordinateFile;	
	
	public GraphInitializer()
	{		}	

	/**
	* @brief constructs the GraphInitializer 
	* @param String inputFile which expects the input file containing the vertex data 
	*/ 
	public GraphInitializer(String inputFile)
	{
		this.inputFileName = inputFile;

	}
	
	/**
	* @brief creates the graph with the Vertexes and their adjacent edges and distances 
	* @return Graph which is the newly created graph
	*/ 
	public Graph createGraph()
	{
		File dataFile;
		Scanner input = null;
		Scanner lineScan = null;
		
		Graph graph = new Graph();;
		

		try
		{
			dataFile = new File(this.inputFileName);
			input = new Scanner(dataFile);

		}
		catch(FileNotFoundException e)
		{
			System.out.println(" File not found");
		
		}


		try
		{

		while(input.hasNextLine() || !input.nextLine().equals(""))
		{
			String line = input.nextLine();
			
			lineScan = new Scanner(line);
			
			String lineDefiner = lineScan.next();
				

			if(lineDefiner.equals("a"))
			{
				while(lineScan.hasNext())
				{
			
			
					String vertex = lineScan.next();
				
					
					String adjVertex = lineScan.next();
				
					int adjacentVertexDistance = Integer.parseInt(lineScan.next());
									
					Edge edge = new Edge(adjVertex , adjacentVertexDistance);
					graph.addVertex(vertex , edge);				
				}


			}
		}
		
		}
		catch(NoSuchElementException e)
		{
			System.out.println("End of file");
		}
		
		return graph;
	
	}

	/**
	* @brief assigns latitude and longitude cordinates to each Vertex
	* @param Graph graph which expects the graph that is to have its Vertexes' cordinates set
	* @param File cordFile which expects the file containing the cordinates for the Vertexes
	* @return Graph which is the newly created graph with cordinates 
	*/ 
	public Graph setCordinates(Graph graph , File cordFile )
	{
		Scanner input = null;
		Scanner lineScan = null;
		

		try
		{
			input = new Scanner(cordFile);

		}
		catch(FileNotFoundException e)
		{
			System.out.println(" File not found");
		
		}


		try
		{

			while(input.hasNextLine())
			{
				String line = input.nextLine();
				lineScan = new Scanner(line);
				
				String lineDefiner = lineScan.next();
				
				if(lineDefiner.equals("v"))
				{
					while(lineScan.hasNext())
					{
				
						String vertex = lineScan.next();
											
						int latitude = Integer.parseInt(lineScan.next());
						
						int longitude = Integer.parseInt(lineScan.next());
																
						Vertex vert = graph.getVertex(vertex);
						vert.setLatitude(latitude);
						vert.setLongitude(longitude);				
					}

	
				}
			}
		
		}
		catch( NullPointerException e)
		{

			System.out.println("Error: File either not found or not formatted correctly");

		}
		return graph;
		
	}



}
