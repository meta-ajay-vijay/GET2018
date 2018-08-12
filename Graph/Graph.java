package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Graph implements UndirWeightGraph{
	public static final String filePath = "H:\\\\Akv\\\\Eclipse\\\\Data Structure\\\\src\\\\Graph\\\\graphData.txt";

	private int totalVertex;
	private Vertex vertices[];
	private List<Edge> edgeList = new LinkedList<Edge>();
	
	Graph(){}
	
	/**
	 * pair class for shortest path method
	 * @author User29
	 *
	 */
	class Pair{
		private int weight;
		private int vertex;
		
		Pair(int weight, int vertex){
			this.weight = weight;
			this.vertex = vertex;
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public int getVertex() {
			return  this.vertex;
		}
	}
	
	/**
	 * Comparator for Sort By edge weight
	 * @author User29
	 *
	 */
	class sortPairByWeight implements Comparator<Pair>{

		public int compare(Pair pair1, Pair pair2) {
			return pair1.getWeight() - pair2.getWeight();
		}
		
	}
	
	/**
	 * Comparator for Sort By edge weight
	 * @author User29
	 *
	 */
	class sortEdgeByWeight implements Comparator<Edge>{

		public int compare(Edge edge1, Edge edge2) {
			return edge1.getEdgeWeight() - edge2.getEdgeWeight();
		}
		
	}
	
	/**
	 * Read data from text file
	 * @param filePath - file path
	 */
	public void readData(String filePath) {
		try {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			this.totalVertex = Integer.parseInt(br.readLine());
			this.vertices = new Vertex[this.totalVertex];
			for(int i=0; i<this.totalVertex; i++) {
				this.vertices[i] = new Vertex();
			}
			String string;
			while((string = br.readLine()) != null) {
				String tokens[] = string.split(" ");
				this.addVertices(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Add neighbour to vertex
	 * @param vertex1 - Vertex
	 * @param vertex2 - neighbour vertex
	 * @param edgeWeight - edge weight of vertex1 and vertex2
	 */
	private void addVertices(int vertex1, int vertex2, int edgeWeight) {
		this.edgeList.add(new Edge(vertex1, vertex2, edgeWeight));
		this.vertices[vertex1].addNeighbour(vertex2, edgeWeight);
		this.vertices[vertex2].addNeighbour(vertex1, edgeWeight);
	}
	
	/**
	 * Depth First Search of graph
	 * @param source - Source vertex
	 * @return - List of visited vertices
	 */
	private Set<Integer> dfs(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visitedVertex = new HashSet<Integer>();
		stack.push(source);
		int vertex;
		while(!stack.isEmpty()) {
			vertex = stack.pop();
			if(visitedVertex.contains(vertex)) {
				continue;
			}
			visitedVertex.add(vertex);
			for(Neighbour neighbour : this.vertices[vertex].getNeighbourList()) {
				stack.push(neighbour.getNeighbourVertex());
			}
		}
		return visitedVertex;
	}

	/**
	 * @return - true if graph is connected otherwise false
	 */
	public boolean isConnected() {
		return this.dfs(0).size() == this.totalVertex;
	}

	/**
	 * Find all vertices which are reachable from given vertex
	 * @param vertex -  vertex of a graph
	 * @return - List of reachable vertices from given vertex
	 */
	public int[] reachable(int vertex) {
		Set<Integer> visitedVertex = this.dfs(vertex);
		int reachableList[] = new int[visitedVertex.size()];
		Iterator it = visitedVertex.iterator();
		int index = 0;
		while(it.hasNext()) {
			reachableList[index] = (Integer)it.next();
			index ++;
		}
		Arrays.sort(reachableList);
		return reachableList;
	}
	
	/**
	 * Find root of vertex in union-find set
	 * @param rootOf - Hash map of vertex with their roots
	 * @param vertex - vertex 
	 * @return - root of vertex
	 */
	private int root(HashMap<Integer, Integer> rootOf, int vertex) {
		while(rootOf.get(vertex) != vertex) {
			vertex = rootOf.get(vertex);
		}
		return vertex;
	}
	
	/**
	 * Check whether given vertex makes cycle or not
	 * @param rootOf -  Hash map of vertex with their roots
	 * @param vertex1 - vertex1 
	 * @param vertex2 - vertex2
	 * @return - true if cycle present otherwise false
	 */
	private boolean isCycle(HashMap<Integer, Integer> rootOf, int vertex1, int vertex2) {
		int root1 = root(rootOf, vertex1);
		int root2 = root(rootOf, vertex2);
		if(root1 == root2) {
			return true;
		}
		rootOf.put(root1, root2);
		return false;
	}

	/**
	 * Get Minimum Spanning tree
	 * @return - Spanning tree with vertices and weight
	 */
	public int[][] getMinimumSpanningTree() {
		Collections.sort(this.edgeList, new sortEdgeByWeight());
		int mst[][] = new int[this.totalVertex-1][3];
		HashMap<Integer, Integer> rootOf = new HashMap<Integer, Integer>();
		for(int i=0; i<this.totalVertex; i++) {
			rootOf.put(i, i);
		}
		int index = 0;
		for(Edge edge:this.edgeList) {
			if(index >= this.totalVertex-1) {
				break;
			}
			if(!isCycle(rootOf, edge.getStartVertex(), edge.getEndVertex())) {
				mst[index][0] = edge.getStartVertex();
				mst[index][1] = edge.getEndVertex();
				mst[index][2] = edge.getEdgeWeight();
				index ++;
			}
		}
		return mst;
	}

	/**
	 * Dijkstra algorithm implementation
	 * @param source - Source vertex
	 * @return - Distance of all vertices from source
	 */
	private int[] dijkstra(int source) {
		int dist[] = new int[this.totalVertex];
		for(int i=0; i<this.totalVertex; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		Set<Integer> visited = new HashSet<Integer>();
		dist[source] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(this.totalVertex, new sortPairByWeight());
		pq.add(new Pair(0, source));
		while(!pq.isEmpty()) {
			Pair pair = pq.peek();
			pq.remove();
			if(visited.contains(pair.getVertex())) {
				continue;
			}
			visited.add(pair.getVertex());
			for(Neighbour neighbour : this.vertices[pair.getVertex()].getNeighbourList()) {
				if(dist[neighbour.getNeighbourVertex()] > dist[pair.getVertex()] + neighbour.getEdgeWeight()) {
					dist[neighbour.getNeighbourVertex()] = dist[pair.getVertex()] + neighbour.getEdgeWeight();
					pq.add(new Pair(dist[neighbour.getNeighbourVertex()], neighbour.getNeighbourVertex()));
				}
			}
		}
		return dist;
	}
	
	/**
	 * Find shortest path distance between two vertex
	 * @param source - starting vertex
	 * @param destination - ending vertex
	 * @return Shortest distance between source and destination
	 */
	public int shortestPath(int source, int destination) {
		int dist[] = this.dijkstra(source);
		return dist[destination];
	}
}