package DP;

public class LongestCommon_Subsequence {

	public static void main(String[] args) {
		String str = "AGGTAB";
		String str2 = "GXTXAYB";

		int a = str.length();
		int b = str.length();

		char[] x = str.toCharArray();
		char[] y = str2.toCharArray();

		int[][] dp = new int[a + 1][b + 1];

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {

				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		printMatrix(dp);

		System.out.println(dp[a][b]);

	}

	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}
}
