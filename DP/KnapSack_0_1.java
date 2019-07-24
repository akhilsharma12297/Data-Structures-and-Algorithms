package DP;

public class KnapSack_0_1 {

	public static int func(int[] val, int[] wt, int cap) {

		if (wt.length == 0 || val.length == 0) {
			return -1;
		}

		if (cap == 0) {
			return 0;
		}

		int[][] dp = new int[val.length + 1][cap + 1];

		for (int i = 0; i <= val.length; i++) {
			for (int j = 0; j <= cap; j++) {

				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}

				if (j - wt[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		printMatrix(dp);
		System.out.println();
		return dp[val.length][cap];

	}

	private static void printMatrix(int[][] cps) {
		for (int i = 0; i < cps.length; i++) {
			for (int j = 0; j < cps[0].length; j++) {

				System.out.print(cps[i][j] + " ");

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int val[] = { 22, 20, 15, 30, 24, 54, 21, 32, 18, 25 };
		int wt[] = { 4, 2, 3, 5, 5, 6, 9, 7, 8, 10 };

		int wt2[] = { 1, 4, 5, 7 };
		int val2[] = { 1, 3, 4, 5 };

		int val3[] = { 60, 100, 120 };
		int wt3[] = { 10, 20, 30 };

		System.out.println(func(val3, wt3, 50));

	}

}
