package DP;

public class LongestPalindromic_SubString {
	public static void main(String[] args) {

		String str = "abbcacbb";

		func(str);

		System.out.println(LPSS("babad"));

	}

	private static void func(String str) {

		int n = str.length();

		int maxLenght = -1;
		int startpoint = -1;
		int endpoint = -1;

		boolean dp[][] = new boolean[n][n];

		for (int diag = 0; diag < n; diag++) {

			int sp = 0;
			int ep = diag;

			while (ep < n) {

				if (diag == 0) {
					dp[sp][ep] = true;
				} else if (diag == 1) {
					if (str.charAt(sp) == str.charAt(ep)) {
						dp[sp][ep] = true;
					}
				} else if (str.charAt(sp) == str.charAt(ep) && dp[sp + 1][ep - 1]) {
					dp[sp][ep] = true;

					if (diag > maxLenght) {
						maxLenght = diag;
						startpoint = sp;
						endpoint = ep;
					}

				}

				sp++;
				ep++;

			}

		}
		printMatrix(dp);

		System.out.println();

		System.out.println(str.substring(startpoint, endpoint + 1));

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

	private static String LPSS(String str) {

		if (str.length() == 1) {
			return str;
		}

		String ans = "";

		for (int i = 0; i < str.length() - 1; i++) {

			String res = isPalindromeCenter(str, i, i);

			if (res.length() > ans.length()) {
				ans = res;
			}

			res = isPalindromeCenter(str, i, i + 1);

			if (res.length() > ans.length()) {
				ans = res;
			}
		}

		return ans;
	}

	private static String isPalindromeCenter(String str, int j, int k) {

		while (j >= 0 && k < str.length() && str.charAt(j) == str.charAt(k)) {
			j--;
			k++;
		}
		return str.substring(j + 1, k);
	}

}