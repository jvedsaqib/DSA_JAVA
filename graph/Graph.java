package com.graph;

public class Graph {
	int adj[][];
	int nV=0;
	
	public Graph(int nodes) {
		nV = nodes;
		this.adj = new int[nodes][nodes];
	}
	
	public void addEdge(int src, int dest) {
		this.adj[src][dest] = 1;
		this.adj[dest][src] = 1;
	}
	
	public void display() {
		for(int i = 0; i<nV; i++) {
			for(int j = 0; j<nV; j++) {
				System.out.print(adj[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.display();
		
		System.out.println();
		
		Graph g1 = new Graph(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(0, 4);
		g1.display();
		
	}

}
