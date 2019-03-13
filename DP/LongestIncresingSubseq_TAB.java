package DP;

import java.util.ArrayList;

public class LongestIncresingSubseq_TAB {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 3, 13, 11, 7, 15 };
		System.out.println(LIS(arr));

		ArrayList<String> list = new ArrayList<>();

		list.add("9");
		list.add(":");
		list.add("0");
		list.add("0");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == ":") {
				list.remove(i);
			}

		}

		System.out.println(list);

	}

	public static int LIS(int[] arr) {

		if (arr.length == 1) {
			return 1;
		}

		int[] dp = new int[arr.length];

		dp[0] = 1;

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			max = Math.max(max, dp[i]);
		}

		return max;
	}

}
