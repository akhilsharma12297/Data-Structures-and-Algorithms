package Graph;

public class Walls_and_Gates {

	public static void main(String[] args) {

		int[][] arr = { { 50, -1, 0, 50 }, { 50, 50, 50, -1 }, { 50, -1, 50, -1 }, { 0, -1, 50, 50 } };

		wg(arr);
	}

	private static void wg(int[][] arr) {

		printGraph(arr);
		System.out.println();

		boolean[][] visited = new boolean[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					dfs(arr, i, j, 0, visited);
				}
			}
		}

		printGraph(arr);
	}

	private static void dfs(int[][] arr, int i, int j, int distance, boolean[][] visited) {

		if (isValid(arr, i, j, visited) == false) {
			return;
		}

		arr[i][j] = Math.min(arr[i][j], distance);

		visited[i][j] = true;

		dfs(arr, i + 1, j, distance + 1, visited);
		dfs(arr, i, j - 1, distance + 1, visited);
		dfs(arr, i - 1, j, distance + 1, visited);
		dfs(arr, i, j + 1, distance + 1, visited);

		visited[i][j] = false;

	}

	private static boolean isValid(int[][] arr, int i, int j, boolean[][] visited) {

		if (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] != -1 && visited[i][j] == false)
			return true;
		return false;
	}

	private static void printGraph(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
