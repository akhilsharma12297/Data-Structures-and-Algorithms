package DP;

public class LongestPalindromic_Subsequence {

	public static void main(String[] args) {

		String str = "BBABCBCAB";
		System.out.println(lpsub(str));

	}

	private static int lpsub(String str) {

		int[][] dp = new int[str.length() + 1][str.length() + 1];

		for (int diag = 1; diag < str.length(); diag++) {

			int sp = 0;
			int ep = diag;

			while (ep < str.length()) {
				if (diag == 2 && str.charAt(sp) == str.charAt(ep)) {
					dp[sp][ep] = 2;
				} else if (str.charAt(sp) == str.charAt(ep)) {
					dp[sp][ep] = dp[sp + 1][ep - 1] + 2;
				} else {
					dp[sp][ep] = Math.max(dp[sp][ep - 1], dp[sp + 1][ep]);
				}

				sp++;
				ep++;

			}
		}

		printMatrix(dp);

		return dp[0][dp.length - 2];

	}

	private static void printMatrix(int[][] cps) {
		for (int i = 0; i < cps.length; i++) {
			for (int j = 0; j < cps[0].length; j++) {

				System.out.print(cps[i][j] + " ");

			}
			System.out.println();
		}
	}
}
