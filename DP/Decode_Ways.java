package DP;

public class Decode_Ways {

	public static void main(String[] args) {

		func("1224");

	}

	private static void func(String str) {

		int[] dp = new int[str.length() + 1];

		dp[0] = 1;

		dp[1] = str.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i <= str.length(); i++) {
			int onedigit = Integer.valueOf(str.substring(i - 1, i));
			int twodigit = Integer.valueOf(str.substring(i - 2, i));

			if (onedigit >= 1) {
				dp[i] += dp[i - 1];
			}

			if (twodigit >= 10 && twodigit <= 26) {
				dp[i] += dp[i - 2];
			}

		}

		System.out.println(dp[str.length()]);

	}
}
