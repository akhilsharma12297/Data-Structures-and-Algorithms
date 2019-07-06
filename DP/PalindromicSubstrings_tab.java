package DP;

public class PalindromicSubstrings_tab {

	public static void main(String[] args) {

		String str = "";

		func(str);

	}

	public static void func(String str) {

		int ctr = 0;
		boolean[][] dp = new boolean[str.length()][str.length()];

		for (int diag = 0; diag < str.length(); diag++) {

			int sp = 0;
			int ep = diag;

			while (ep < str.length()) {

				if (diag == 0) {

					dp[sp][ep] = true;
				} else if (diag == 1) {

					if (str.charAt(sp) == str.charAt(ep)) {
						dp[sp][ep] = true;
					}
				} else {
					if (str.charAt(sp) == str.charAt(ep) && dp[sp + 1][ep - 1] == true) {
						dp[sp][ep] = true;
					}
				}

				if (dp[sp][ep] == true) {
					ctr++;
				}

				sp++;
				ep++;

			}
		}

		printMatrix(dp);

		System.out.println(ctr);

	}

	private static void printMatrix(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (dp[i][j] == true) {
					System.out.print("T" + " ");
				} else {
					System.out.print("F" + " ");
				}

			}
			System.out.println();
		}
	}

	public int countSubstrings(String s) {
		int[][] dp;
		if (s == null || s.length() == 0)
			return 0;
		int cnt = 0;
		int n = s.length();
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= i; j--) {
				cnt += isPalindrom(dp, s, i, j) ? 1 : 0;
			}
		}
		return cnt;
	}

	public boolean isPalindrom(int dp[][], String s, int i, int j) {
		if (i >= j)
			return true;
		if (dp[i][j] != 0) {
			return dp[i][j] == 1;
		}
		if (s.charAt(i) != s.charAt(j)) {
			dp[i][j] = -1;
		} else {
			boolean b = isPalindrom(dp, s, i + 1, j - 1);
			dp[i][j] += b ? 1 : -1;
		}
		return dp[i][j] == 1;
	}
}
