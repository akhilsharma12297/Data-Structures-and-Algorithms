package Recursion;

public class find_Celebrity {

	public static void main(String[] args) {

		int[][] arr = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		System.out.println(func(arr, arr.length));
	}

	private static int func(int[][] mat, int n) {

		int c = 0;

		for (int i = 1; i < n; i++) {

			if (knows(mat, c, i)) {
				c = i;
			}
		}

		for (int i = 0; i < n; i++) {

			if (c != i && (knows(mat, c, i) || !knows(mat, i, c))) {
				return -1;
			}

		}
		return c;
	}

	private static boolean knows(int[][] mat, int a, int b) {
		return (mat[a][b] == 1 ? true : false);
	}

}
