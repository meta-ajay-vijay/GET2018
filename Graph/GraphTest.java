package Graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphTest {

	@Test
	void test() {
		String path = "H:\\Akv\\Eclipse\\Data Structure\\src\\Graph\\graphData.txt";
		Graph graph = new Graph();
		graph.readData(path);
		int expected1[][] = {
				{0, 1, 2},
				{2, 3, 2},
				{1, 3, 3},
				{4, 6, 4},
				{5, 6, 5},
				{2, 4, 7},
				{5, 7, 8}	
		};
		Assertions.assertArrayEquals(expected1, graph.getMinimumSpanningTree());
		Assertions.assertTrue(graph.isConnected());
		int expected2[] = {0, 1, 2, 3, 4, 5, 6, 7};
		Assertions.assertArrayEquals(expected2, graph.reachable(5));
		Assertions.assertEquals(7,  graph.shortestPath(0, 2));
		Assertions.assertEquals(11,  graph.shortestPath(6, 2));
	}

}