package DP;

public class Stock_buy_sell_k_Times {

	public static void main(String[] args) {

	}

	private static int Ktimes(int[] arr, int k) {
		int n = arr.length;
		int[][] profit = new int[k + 1][n + 1];

		// For day 0, you can't
		// earn money irrespective
		// of how many times you trade
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// profit is 0 if we don't
		// do any transation
		// (i.e. k =0)
		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		// fill the table in
		// bottom-up fashion
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int max_so_far = 0;

				for (int m = 0; m < j; m++)
					max_so_far = Math.max(max_so_far, arr[j] - arr[m] + profit[i - 1][m]);

				profit[i][j] = Math.max(profit[i][j - 1], max_so_far);
			}
		}

		return profit[k][n - 1];
	}
}
