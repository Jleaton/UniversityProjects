/**
* @author Joshua Lewis Eaton
* @date December 5, 2014
* @file Vertex.java
* @brief Class Vertex defines a Vertex in relation to a Graph 
* 
*/
import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>
{
	private String id;
	private ArrayList<Edge> adjacencies;
	private int minDistance;
	private int latitude;
	private int longitude;
	private String prevVertex;

	/**
	* @brief constructs a new vertex with the given vertexID
	* @param String vertexId which expects the ID for the vertex
	*/ 
	public Vertex(String vertexId)
	{
		this.adjacencies = new ArrayList<>();
		this.id = vertexId;
	  	this.latitude = latitude;
		this.longitude = longitude;
		this.minDistance = Integer.MAX_VALUE;
		this.prevVertex = "";
	}
	
	/**
	* @brief adds the given vertex as an adjacency
	* @param Vertex vertex which expects the vertex that is adjacent 
	* @return void
	*/ 
	public void addAdjacency(Edge edge)
	{	this.adjacencies.add(edge); }


	/**
	* @brief sets the Vertex's ID
	* @param String ID which expects the ID for the vertex 
	* @return void
	*/ 
	public void setVertexID(String ID)
	{	this.id = ID; }

	/**
	* @brief sets the latitude coordinate for the Vertex
	* @param double lat which expects a latitude coordinate
	* @return void
	*/ 
	public void setLatitude(int lat)
	{	this.latitude = lat; }
	
	/**
	* @brief sets the longitude coordinate for the Vertex
	* @param double lon which expects a longitude coordinate
	* @return void
	*/ 
	public void setLongitude( int lon)
	{	this.longitude = lon; }
	
	/**
	* @brief sets the minimul distance for the Vertex 
	* @param int minDist which expects the minimum distance 
	* @return void
	*/ 
	public void setMinDistance(int min)
	{	this.minDistance = min; }

	/**
	* @brief sets the previous Vertex's previous Vertex
	* @param Vertex prev which expects the Vertex previous to this one
	* @return void
	*/ 
	public void setPrevVertex(String prev)
	{this.prevVertex = prev;	}

	/**
	* @brief returns the Vertex's adjacent Vertexes
	* @return ArrayList<Vertex> 
	*/ 
	public ArrayList<Edge> getAdjacencies()
	{	return this.adjacencies; }

	/**
	* @brief returns the Vertex's ID
	* @return String
	*/ 
	public String getVertexID()
	{	return this.id; }


	/**
	* @brief returns the Vertex's latitude coordinate
	* @return double
	*/ 
	public int getLatitude()
	{	return this.latitude; }

	/**
	* @brief returns the Vertex's longitude coordinate
	* @return double
	*/ 
	public int getLongitude()
	{	return this.longitude; }

	
	/**
	* @brief returns the Vertex's minDistance
	* @return int
	*/ 
	public int getMinDistance()
	{	 return this.minDistance; }
	
	/**
	* @brief returns the Vertex previous to the this Vertex
	* @return Vertex
	*/ 
	public String getPrevVertex()
	{	return this.prevVertex; }
	
	@Override
	public int compareTo(Vertex vert)
	{
		return Integer.compare(this.minDistance , vert.getMinDistance() );
	}



	
}
