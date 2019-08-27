package DP;

public class Submatrix_queries {

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3, 4, 6 }, { 5, 3, 8, 1, 2 }, { 4, 6, 7, 5, 5 }, { 2, 4, 8, 9, 4 } };

		System.out.println(solve(arr.length, arr[0].length, arr, 1, 2, 3, 3));

	}

	public static int solve(int N, int M, int[][] arr, int x1, int y1, int x2, int y2) {

		if (N <= 0 || M <= 0) {
			return 0;
		}

		int dp[][] = new int[N + 1][M + 1];

		dp[0][0] = arr[0][0];

		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i - 1] + arr[0][i];
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		x1--;
		y1--;
		x2--;
		y2--;

		int ans = dp[x2][y2];

		if (x1 > 0) {
			ans -= dp[x1 - 1][y2];
		}

		if (y1 > 0) {
			ans -= dp[x2][y1 - 1];
		}

		if (x1 > 0 && y2 > 0) {
			ans += dp[x1 - 1][y1 - 1];
		}

		return ans;

	}
}
