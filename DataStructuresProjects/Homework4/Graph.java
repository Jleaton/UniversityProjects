/**
* @author Joshua Lewis Eaton
* @date December 5, 2014
* @file Graph.java
* @brief Class Graph defines a graph that is made of vertexes and edges, the underlying implementation is a hashmap
*
*/

import java.util.HashMap;

public class Graph
{
	private HashMap<String , Vertex> graph;
	private int vertexCount;

	public Graph()
	{
	
		this.graph = new HashMap<>();
		this.vertexCount = 0;

	}

	public void addVertex(String vertexID , Edge edge)
	{
		
		if(this.graph.containsKey(vertexID) == false)	//if vertex does not exist then create a new vertex
		{	
		 	
			Vertex vertex = new Vertex(vertexID);	//creates a new vertex and assigns it its id key
			vertex.addAdjacency(edge);	//adds the adjacency to the newly created vertex's adjacecny list
			this.graph.put(vertexID , vertex);	//puts the new vertex into the hashmap

			this.vertexCount++;
		}
		else	//else the vertex exist so we only add our adjacency to the existing vertex adjacency list
		{	
			Vertex vertex = null;
			vertex = this.graph.get(vertexID);	//gets the existing vertex with provided id key
			vertex.addAdjacency(edge);	//adds the adjacent vertex to the existing vertex adjacency list

		}
	}

	public Vertex getVertex(String vertexID)
	{
		Vertex vertex = null;
		vertex = this.graph.get(vertexID);
		
		return vertex;

	}

	public boolean hasVertex(String vertexID)
	{	

		boolean containsVertex = false;
		containsVertex = this.graph.containsKey(vertexID);
		
		return containsVertex;
	
	}
	
	public int getVertexCount()
	{	return this.vertexCount++; }

	public HashMap<String , Vertex> getVertexMap()
	{	return this.graph; }


}
