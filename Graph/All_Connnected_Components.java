package Graph;

import java.util.ArrayList;

public class All_Connnected_Components {

	public static void main(String[] args) {
		int graph[][] = { { 1, 2, 0, 0, 0 }, { 0, 3, 0, 0, 4 }, { 5, 0, 0, 6, 7 }, { 0, 0, 0, 0, 0 },
				{ 8, 0, 9, 0, 10 } };

		DFS(graph);

	}

	public static void DFS(int[][] graph) {

		ArrayList<String> component = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {

				if (graph[i][j] != 0) {

					DFS(graph, i, j, component);

					System.out.println(component);

					component = new ArrayList<>();
				}

			}
		}
	}

	private static void DFS(int[][] graph, int i, int j, ArrayList<String> ans) {

		if (i < 0 || j < 0 || i >= graph.length || j >= graph[i].length || graph[i][j] == 0) {
			return;
		}

		ans.add(graph[i][j] + "");

		graph[i][j] = 0;

		DFS(graph, i + 1, j, ans);

		DFS(graph, i - 1, j, ans);

		DFS(graph, i, j + 1, ans);

		DFS(graph, i, j - 1, ans);

	}
}
