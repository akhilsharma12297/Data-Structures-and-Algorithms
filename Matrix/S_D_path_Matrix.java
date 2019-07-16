package Recursion;

public class S_D_path_Matrix {

	public static void main(String[] args) {
		int maze[][] = new int[][] { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int visited[][] = new int[maze.length][maze[0].length];
		System.out.println(countWays(maze, 0, 0, visited));
	}

	private static int countWays(int[][] maze, int i, int j, int visited[][]) {

		if (i == maze.length && j == maze[0].length - 1) {
			return 1;
		}

		if (!isvalid(maze, visited, i, j)) {
			return 0;
		}

		visited[i][j] = 1;

		int ans = 0;
		ans += countWays(maze, i, j + 1, visited);
		ans += countWays(maze, i + 1, j, visited);

		visited[i][j] = 0;

		return ans;

	}

	private static boolean isvalid(int[][] maze, int visited[][], int i, int j) {

		if (i < 0 || j < 0 || i > maze.length - 1 || j > maze[0].length - 1 || maze[i][j] == -1 || visited[i][j] == 1) {
			return false;
		}
		return true;
	}

}
