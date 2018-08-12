package Graph;
public class Edge {

	private int startVertex;
	private int endVertex;
	private int edgeWeight;
	
	Edge(int vertex1, int vertex2, int edgeWeight){
		this.startVertex = vertex1;
		this.endVertex = vertex2;
		this.edgeWeight = edgeWeight;
	}
	
	/**
	 * 
	 * @return - start vertex of edge
	 */
	public int getStartVertex() {
		return this.startVertex;
	}
	
	/**
	 * 
	 * @return - end vertex of edge
	 */
	public int getEndVertex() {
		return this.endVertex;
	}
	
	/**
	 * 
	 * @return - Weight of edge
	 */
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}