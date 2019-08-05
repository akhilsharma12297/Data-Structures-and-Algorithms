package Recursion;

public class Catalan_Number {

	public static void main(String[] args) {
		System.out.println(Catalan_Number(3));
	}

	public static int Catalan_Number(int n) {

		int dp[] = new int[n + 2];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];
	}
}
