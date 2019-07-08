package DP;

public class LongestPalindromic_Subsequence {

	public static void main(String[] args) {

		String str = "agbdba";
		System.out.println(lpsub(str));

		System.out.println();

		System.out.println(lps(str));

	}

	private static int lpsub(String str) {

		int[][] dp = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
		}

		for (int diag = 0; diag < str.length(); diag++) {

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

		return dp[0][dp.length - 1];

	}

	static int lps(String seq) {
		int n = seq.length();
		int i, j, cl;
		// Create a table to store results of subproblems
		int L[][] = new int[n][n];

		// Strings of length 1 are palindrome of lentgh 1
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		// Build the table. Note that the lower
		// diagonal values of table are
		// useless and not filled in the process.
		// The values are filled in a manner similar
		// to Matrix Chain Multiplication DP solution (See
		// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).
		// cl is length of substring
		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
			}
		}

		printMatrix(L);

		return L[0][n - 1];
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
