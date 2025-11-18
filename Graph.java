
/*
Mitchell Levy
CMPT 435 Algorithms and Analysis
Assignment 7
11-9-23
 */



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Graph {

	private int[][] edges; // adjacency matrix
	private LinkedList<Integer>[] adjlist; // adjacency list
	private Object[] labels; // vertex label, i.e, vertex 0, its label = "A", vertex 1, its label = "B"

	public Graph(int n) {
		// n: size of nodes
		// weighted graph
		edges = new int[n][n];
		// edges[i][j] saves the weight of edge i->j, assume weight > 0
		// for unweighted graph
		// set edges[i][j] to 1 if there exists an edge i->j
		// set edges[i][j] to 0 otherwise
		adjlist = new LinkedList[n];
		// adjlist saves the adjacency list of the graph
		// adjlist[i] saves a list of neighboring vertices of vertex i
		
		labels = new Object[n];
	}

	public void setLabel(int vertex, Object label) {
		// vertex: vertex index, label: vertex name
		labels[vertex] = label;

	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}

	public int size() {
		return edges.length;
	}

	public void addEdge(int source, int target, int w) {
		// add an edge from vertex source to vertex target with w as weight
		edges[source][target] = w;

		// edges[target][source] = w;
		// In an undirected graph, set the symmetry element in the matrix with the same
		// weight
	}

	public void addEdge2(int source, int target, int w) {
		// add an edge from vertex source to vertex target with w as weight
		edges[source][target] = w;

		edges[target][source] = w;
		// In an undirected graph, set the symmetry element in the matrix with the same
		// weight
	}

	public boolean isEdge(int source, int target) {
		// if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target) {
		edges[source][target] = 0;
		// edges[target][source] = 0;
		// In an undirected graph, set the symmetry element in the matrix to 0
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		// find neighbors of a given vertex
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public int getUnvisitedNeighbor(int vertex, boolean[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1

		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] == false)
				return i;
		}
		return -1;
	}

	public void getAdjList() {
		// Complete the method to create an adjacency list for the graph
		// Feel free to change the return type
		for(int i = 0; i < edges.length; i++)  // goes through every vertex in graph
		{
			int arr[] = neighbors(i);  // array of a vertex's neighbors
			LinkedList<Integer> link = new LinkedList();  //  linked list of neighbors
			for(int j = 0; j < arr.length; j++)  // fills in array with linked lists of neighbors
			{
				link.add(arr[j]);  // puts vertex into linked list
			}
			adjlist[i] = link;  // puts linked list into array
		}

	}

	public void print() {
		// Print adjacency list
		int n = edges.length;
		for (int i = 0; i < n; i++) {
			System.out.println("Vertex " + i + ":" + adjlist[i].toString());
		}
	}
	

	public void dfs() {// DFS
		// Complete this method to traverse a graph using DFS
		// Start DFS from a randomly selected node in the graph
		// Print nodes in order as visited by DFS
		// Note: Follow the pseudocode of DFS() in slides.

		int n = edges.length - 1;
		Random rng = new Random();
		int rand = rng.nextInt(n + 1); // generates random number between 0 and max of graph
		Stack<Integer> stack = new Stack();
		boolean visited[] = new boolean[edges.length]; // array of T/F to track if nodes are visited
		visited[rand] = true;  // marks that we visited source node
		stack.push(rand);  // pushes source node onto stack
		System.out.println(stack.toString());
		while(!stack.isEmpty())
		{
			int u = stack.peek();
			int w = getUnvisitedNeighbor(u, visited);
			if(w >= 0)  // if we have unvisited neighbors
			{
				visited[w] = true; // mark them as visited
				stack.push(w); // push them on to the stack
				System.out.println(stack.toString());
			}
			else  // no unvisited neighbors
			{
				stack.pop(); // pop top of stack
				System.out.println(stack.toString());
			}
		}
	}


	public static void main(String args[]) {

		// An example to create a graph using the Graph class
		// You should create a new graph to represent the one given in Assignment 7
		// Then test the function dfs() and getAdjList() on the graph you create 
		final Graph t = new Graph(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge2(0, 1, 1);
		t.addEdge2(0, 5, 1);
		t.addEdge2(1, 2, 1);
		t.addEdge2(1, 3, 1);
		t.addEdge2(1, 5, 1);
		t.addEdge2(2, 3, 1);
		t.addEdge2(4, 3, 1);
		t.addEdge2(4, 2, 1);
		t.addEdge2(5, 4, 1);

		// Test adjacency list
		System.out.println("Adjacency List:");
		t.getAdjList();
		t.print();
		System.out.println();
		// Test DFS
		System.out.println("DFS, Undirected Graph:");
		t.dfs();


		System.out.println();

		final Graph m = new Graph(7);
		m.setLabel(0, "0");
		m.setLabel(1, "1");
		m.setLabel(2, "2");
		m.setLabel(3, "3");
		m.setLabel(4, "4");
		m.setLabel(5, "5");
		m.setLabel(6, "6");
		m.addEdge(0, 6, 1);
		m.addEdge(1, 0, 1);
		m.addEdge(2, 0, 1);
		m.addEdge(2, 3, 1);
		m.addEdge(4, 3, 1);
		m.addEdge(4, 6, 1);
		m.addEdge(4, 1, 1);
		m.addEdge(5, 0, 1);
		m.addEdge(5, 1, 1);
		m.addEdge(5, 3, 1);
		m.addEdge(6, 3, 1);

		// Test adjacency list
		System.out.println("Adjacency List:");
		m.getAdjList();
		m.print();
		System.out.println();
		// Test DFS
		System.out.println("DFS, Directed Graph:");
		m.dfs();

	}

}
