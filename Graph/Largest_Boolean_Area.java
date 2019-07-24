package Graph;

public class Largest_Boolean_Area {
	public static void main(String[] args) {

		int mat[][] = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };

		System.out.println(DFS(mat));

	}

	static int count = 0;

	private static int DFS(int[][] mat) {

		int result = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (mat[i][j] != 0) {
					count = 0;

					dfsHelper(mat, i, j);

					result = Math.max(result, count);
				}
			}
		}

		return result;
	}

	private static void dfsHelper(int[][] mat, int i, int j) {

		if (i < 0 || j < 0 || i >= mat.length || j >= mat.length || mat[i][j] == 0) {
			return;
		}

		count++;
		mat[i][j] = 0;
		dfsHelper(mat, i + 1, j);
		dfsHelper(mat, i - 1, j);
		dfsHelper(mat, i, j + 1);
		dfsHelper(mat, i, j - 1);

		dfsHelper(mat, i - 1, j - 1);
		dfsHelper(mat, i + 1, j - 1);
		dfsHelper(mat, i - 1, j + 1);
		dfsHelper(mat, i + 1, j + 1);

	}

}
