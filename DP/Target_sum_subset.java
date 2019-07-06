package DP;

public class Target_sum_subset {

	public static void main(String[] args) {
		int arr[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;

		System.out.println(func(arr, sum));
	}

	public static boolean func(int[] arr, int sum) {

		int n = arr.length - 1;
		boolean subset[][] = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		for (int i = 1; i <= sum; i++) {

			for (int j = 1; j <= n; j++) {

				subset[i][j] = subset[i][j - 1];

				if (i >= arr[j - 1])

					subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
			}

		}

		return subset[sum][n];

	}

	public static int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum < S || (sum + S) % 2 == 1)
			return 0;
		int s = (sum + S) / 2;
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}
}
