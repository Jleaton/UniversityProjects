public class Edge
{
        private final String target;
        private final int weight;


   	public Edge(String target, int weight)
   	{ 	


		this.target = target; 
		this.weight = weight; 


        }


	public String getTarget()
	{

		return this.target;
	}	
	
	public int getWeight()
	{
		return this.weight;

	}
}

