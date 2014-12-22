/**
* @author Joshua Lewis Eaton
* @date December 5, 2014
* @file FindShortestRoadPath.java
* @brief Class FindShortestRoadPath is used to gather user input data and initialize the graph. 
* It will then perform Dijkstra's Algorithm on the graph and save the results to a text file.
*/

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;

public class FindShortestRoadPath
{


	public static void main(String[] args)
	{

		String inputDataFile = args[0];	//contains the name of the data file
		String sourceNodeID = args[1];	//contains the id for the start node
		String targetNodeID = args[2];	//contains the id for the end node
		String outputFileName = args[3]; //contains the name of the file to save to
		
		
		Graph graph = null;	

		graph = graphInit(inputDataFile); //passes the data into the graph initializer and places the new graph into graph
		
		Scanner input = new Scanner(System.in);
		System.out.println( "Is there a cordinate file to input?\n1 for yes\n2 for no\n");
		int choice = input.nextInt();


		if(choice == 1)
		{
	
			cordinateInit(graph);		

		}
		else	
		{	
			System.out.println( "Graph initialization finished\n");

		}

		
		shortestPath(graph , sourceNodeID , targetNodeID , outputFileName);	//generates the shortest path and creates an output file with the results

	}
	
	/**
	* @brief initializes the Graph with the given input data fie
	* @param String input which expects the name of the input file
	* @return Graph graph which returns the initialized graph
	*/ 
	private static Graph graphInit(String input)
	{
		Graph graph = null;

		GraphInitializer init = new GraphInitializer(input);	//initializes the graph with the given input file name
		graph = init.createGraph();	//gets the newly initialized graph
		
		return graph;	//returns the initialized graph for use
	}

	private static Graph cordinateInit(Graph graph)
	{	
		Scanner input = new Scanner(System.in);
		File cordFile;
		
		System.out.println( "Enter file name\n");
		String cordFileName = input.next();
	

		cordFile = new File(cordFileName);	
		
	
		GraphInitializer init = new GraphInitializer();	
		graph = init.setCordinates(graph , cordFile);

		return graph;
	}

	/**
	* @brief performs Dijkstra's algorithm on the graph provided
	* @param Graph graph which expects the graph that Dijkstra's algorithm will work on
	* @param String source which is the source node's id
	* @param String target which is the target node's id
	* @param String output which expects the name for the output file
	* @return void 
	*/ 
	private static void shortestPath(Graph graph , String source, String target, String output)
	{
		Dijkstra alg = new Dijkstra();
		
		Vertex sourceVertex = graph.getVertex(source);
		alg.computePaths(sourceVertex , graph);	
		
		Vertex targetVertex = graph.getVertex(target);


		ArrayList<String> path = alg.getShortestPathTo(targetVertex , sourceVertex , graph);	//gets the list containing the path of Vertexes

		
		
		PrintWriter writer= null;

		try
		{
			writer = new PrintWriter(output, "UTF-8");

		}
		catch(FileNotFoundException e)
		{
			System.out.println( " File Error");

		}
		catch( UnsupportedEncodingException u)
		{
			System.out.println( " Unsupported encoding error" );
		
		}

		
		writer.println("Cost of path " + targetVertex.getMinDistance());
		writer.println("Start vertex: " + source);
	
		for(String v : path)
		{
		        
			
			writer.println(v);


		}
		
		writer.close();

		System.out.println( "Output file created");

	}

	



}
