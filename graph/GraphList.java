package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphList {
	int nV = 0;
	LinkedList<Integer>[] adj; 
	
	public GraphList(int nodes) {
		nV = nodes;
		this.adj = new LinkedList[nodes];
		for(int i = 0; i < nodes; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int src, int dest) {
		this.adj[src].add(dest);
		this.adj[dest].add(src);
	}
	
	public void display() {
		System.out.println("::ADJLIST::");
		for(int i = 0; i < nV; i++) {
			System.out.print(i + "-> ");
			for(int w : adj[i]) {
				System.out.print(w + " ");
			}
			System.out.println();
		}
	}
	
	public void bfs(int s) {
		boolean[] visited = new boolean[nV];
		Queue<Integer> q = new LinkedList<>();
		
		visited[s] = true;
		q.offer(s);
		System.out.println(":: BFS ::");
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");
			for(int v : adj[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
	}
	
	public void dfs(int s) {
		boolean[] visited = new boolean[nV];
		Stack<Integer> q = new Stack<>();
		
		visited[s] = true;
		q.push(s);
		System.out.println(":: DFS ITERATIVE ::");
		while(!q.isEmpty()) {
			int u = q.pop();
			System.out.print(u + " ");
			for(int v : adj[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.push(v);
				}
			}
		}
	}
	

	public static void main(String[] args) {
		GraphList g = new GraphList(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		
		g.display();
		System.out.println();
		g.bfs(0);
		System.out.println();
		g.dfs(0);

	}

}
