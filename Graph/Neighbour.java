package Graph;

public class Neighbour{
	
	private int neighbourVertex;
	private int edgeWeight;
		
	Neighbour(int vertex, int edgeWeight){
		this.neighbourVertex = vertex;
		this.edgeWeight = edgeWeight;
	}
		
	/**
	 * 
	 * @return - neighbour vertex data
	 */
	public int getNeighbourVertex() {
		return this.neighbourVertex;
	}
	
	/**
	 * 
	 * @return - edge weight of neighbour vertex from source vertex
	 */
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}