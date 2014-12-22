import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Collection;

public class Dijkstra
{

	

    public static void computePaths(Vertex source , Graph graph)
    {
	PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();	//will hold the Vertexes not visited

	Collection<Vertex> vertCollection =  graph.getVertexMap().values();	
	
	
	for( Vertex vert : vertCollection)	//adds each Vertex into the queue
	{
		if( !vert.getVertexID().equals(source) )
		{	
			vertexQueue.add(vert);
		}		

	}


        source.setMinDistance(0);	//sets the start Vertex minDistance to 0 
        vertexQueue.add(source); //adds the start Vertex as the first element in the queue


	while (!vertexQueue.isEmpty())	//loops until the vertexQueue is empty
	{   



	    Vertex u = vertexQueue.poll(); //retrieves the Vertex at the top of the priority queue
	  
            // Visit each edge exiting u
            for (Edge e : u.getAdjacencies())
            {	


		String stringV = e.getTarget();  
		Vertex v = graph.getVertex(stringV);	//gets the actuall reference to the Vert object in memory             
	        int weight = e.getWeight();
		int distanceThroughU = 0;
		
		distanceThroughU = u.getMinDistance() + weight;
	
		
		if(distanceThroughU < v.getMinDistance())
		{

	            vertexQueue.remove(v); //remove v from the Vertex Queue 
		    
		    v.setMinDistance(distanceThroughU);// sets the min distance for v			
		  
		    v.setPrevVertex(u.getVertexID());	//sets v's prev vertex
		   
		    vertexQueue.add(v);	//addds v back into the queue


		}	//end if


            }	//end for


        }	//end while
	
    }	//end compute

    public static ArrayList<String> getShortestPathTo(Vertex target , Vertex source, Graph graph)
    {
        ArrayList<String> path = new ArrayList<>();	//arraylist to hold the path taken
	
        
		
	for (String vertex = target.getVertexID(); vertex != source.getVertexID(); vertex = graph.getVertex(vertex).getPrevVertex())//for each vertex starting at target go to its previous till null 
	{           		
		path.add(vertex);	//adds the vertex to the path arraylist
	        
	}

	Collections.reverse(path);
        

	return path;
    }




  
}
