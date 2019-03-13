package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph_AdjacencyLIst {

	private static void addEdge(ArrayList<Edge>[] graph, int u, int v, int wt) {

		graph[u].add(new Edge(v, wt));

		graph[v].add(new Edge(u, wt));

	}

	static class Edge {

		int n;
		int wt;

		Edge(int n, int wt) {
			this.n = n;
			this.wt = wt;

		}

	}

	public static void printpath(ArrayList<Edge>[] graph, int s, int d, String psf, int dsf, boolean[] visited) {

		if (s == d) {
			System.out.println((psf + d) + "@" + dsf);
			return;
		}

		visited[s] = true;

		for (Edge ne : graph[s]) {

			if (visited[ne.n] == false) {

				printpath(graph, ne.n, d, psf + ne.n, dsf + ne.wt, visited);

			}

		}

		visited[s] = false;

	}

	public static void main(String[] args) {

		ArrayList<Edge>[] graph = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {

			graph[i] = new ArrayList<>();

		}

		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);

		printpath(graph, 0, 6, "", 0, new boolean[graph.length]);

	}
}