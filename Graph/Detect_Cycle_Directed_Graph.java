package Graph;

public class Detect_Cycle_Directed_Graph {

	public static void main(String[] args) {
		boolean arr[][] = new boolean[4][4];

		arr[0][2] = true;
		arr[0][1] = true;
		arr[2][0] = true;
		arr[3][3] = true;

		System.out.println(dfs(arr));
	}

	private static boolean dfs(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == true) {
					if (dfs(arr, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean dfs(boolean[][] arr, int i, int j) {

		if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == false) {
			return false;
		}
		if (arr[i][j] == true && arr[j][i]) {
			return true;
		}

		arr[i][j] = false;

		return dfs(arr, i + 1, j) || dfs(arr, i - 1, j) || dfs(arr, i, j + 1) || dfs(arr, i, j - 1);

	}
}
