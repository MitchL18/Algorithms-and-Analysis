
/*
Mitchell Levy
CMPT 435 Algorithms and Analysis
Assignment 9
11-27-23
 */

import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {

	// Dijkstra's algorithm to find shortest path from source vertex s to all other nodes in a weighted graph G
		
	public static int[] dijkstra(WeightedGraph G, int s) {

		int[] d = new int[G.size()]; // d[v]: the estimated shortest distance between the source vertex s and v

		int[] pred = new int[G.size()]; // pred[v]: the preceding node of v on the shorest path from s to v

		boolean[] ST = new boolean[G.size()]; 
		// ST[]: shortest path tree rooted at the source vertex s
		// ST[v] is true if v has been added to the shortest path tree rooted at s, false otherwise
		// The tree is empty initially, therefore every element false initially

		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.MAX_VALUE; // set to infinity initially
		}
		
		d[s] = 0; // the shortest distance between source vertex s and s itself must be 0

		/*		
		Complete the method here to find the shortest path from s to every other vertex in the graph
		Return the array pred[]
		Hint: Follow the pseudocode of Dijkstra's algorithm in the slides
		*/

		for(int i = 0; i < Math.abs(G.size()); i++) // go through graph
		{
			int u = minVertex(d, ST); // mind closest vertex
			ST[u] = true; // add it to tree
			int[] neighbors = G.neighbors(u); // find all the neighbors of that vertex
			for(int j = 0; j < neighbors.length; j++) // for every neighbor
			{
				int v = neighbors[j]; // get the neighbor's vertex
				if(d[v] > (d[u] + G.getWeight(u, v))) // if you find a shorter path
				{
					d[v] = d[u] + G.getWeight(u, v); // update the distance array
					pred[v] = u; // update shortest path
				}
			}
		}

		return pred; // Return the preceding node array
	}

	private static int minVertex(int[] d, boolean[] ST) {
		// find a vertex v that has NOT been added to the shortest path tree ST, and has the minimum estimated distance d[v]
		int x = Integer.MAX_VALUE;
		int v = -1; // graph not connected, or all vertices have been added to the shortest path tree
		
		for (int i = 0; i < d.length; i++) {
			// examine nodes one by one
			if (!ST[i] && d[i] < x) { 
				// vertex i has NOT been added to the shorest path tree yet, and has a smaller estimated distance to s
				v = i;
				x = d[i];
			}
		}
		
		return v; 
	}

	public static void printPath(WeightedGraph G, int[] pred, int s, int e) {
		// print the shortest path from s to e
		java.util.ArrayList path = new java.util.ArrayList();
		int x = e;
		while (x != s) {
			// read nodes on the path from s to e one by one backwards, starting from the destination vertex e
			path.add(0, G.getLabel(x));
			// add the node to the front of the path/list
			x = pred[x];
			// read its preceding node on the path
		}
		path.add(0, G.getLabel(s));
		// add the source vertex s to the front of the list/path
		System.out.println(path);
	}

}
