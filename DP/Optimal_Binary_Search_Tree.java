package DP;

public class Optimal_Binary_Search_Tree {

	public static int minCost(int input[], int freq[]) {
		int dp[][] = new int[input.length][input.length];

		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = freq[i];
		}
		printMatrix(dp);
		System.out.println();
		for (int l = 2; l <= input.length; l++) {
			for (int i = 0; i <= input.length - l; i++) {
				int j = i + l - 1;
				dp[i][j] = Integer.MAX_VALUE;
				int sum = getSum(freq, i, j);

				for (int k = i; k <= j; k++) {
					int val = sum + (k - 1 < i ? 0 : dp[i][k - 1]) + (k + 1 > j ? 0 : dp[k + 1][j]);
					if (val < dp[i][j]) {
						dp[i][j] = val;
					}
				}
			}
		}
		printMatrix(dp);
		System.out.println();
		return dp[0][input.length - 1];
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				System.out.print(mat[i][j] + " ");

			}
			System.out.println();
		}
	}

	private static int getSum(int freq[], int i, int j) {
		int sum = 0;
		for (int x = i; x <= j; x++) {
			sum += freq[x];
		}
		return sum;
	}

	public static void main(String args[]) {
		int input[] = { 10, 12, 20, 35, 46 };
		int freq[] = { 34, 8, 50, 21, 16 };
		System.out.println(minCost(input, freq));
	}

}
