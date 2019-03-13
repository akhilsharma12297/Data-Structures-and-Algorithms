package DP;

import java.util.List;

public class DP_prac {

	public static int fibmem(int n, int[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (qb[n] != 0) {
			return qb[n];
		}
		int fm1 = fibmem(n - 1, qb);
		int fm2 = fibmem(n - 2, qb);

		int fn = fm1 + fm2;

		qb[n] = fn;
		return fn;

	}

	public static int fibtab(int n) {
		int[] arr = new int[n + 1];

		arr[0] = 0;
		arr[1] = 1;

		for (int x = 2; x <= n; x++) {
			arr[x] = arr[x - 1] + arr[x - 2];
		}
		return arr[n];

	}

	public static int cbp(int s, int d) {

		int pathfstd = 0;
		if (s == d) {
			return 1;
		}

		for (int dice = 1; dice <= 6 && s + dice <= d; dice++) {
			int inter = dice + s;
			int pathfromintod = cbp(inter, d);
			pathfstd = pathfstd + pathfromintod;

		}
		return pathfstd;
	}

	public static int cbpmem(int s, int d, int[] qb) {

		int pathfstd = 0;
		if (s == d) {
			return 1;
		}
		if (qb[s] != 0) {
			return qb[s];
		}
		for (int dice = 1; dice <= 6 && s + dice <= d; dice++) {
			int inter = dice + s;
			int pathfromintod = cbp(inter, d);
			pathfstd = pathfstd + pathfromintod;

		}
		qb[s] = pathfstd;
		return pathfstd;
	}

	public static int cbptab(int s, int d) {
		int[] arr = new int[d + 1];
		arr[d] = 1;
		for (int i = d; i >= s; i--) {
			for (int dice = 1; dice <= 6; dice++) {
				if (i + dice <= d) {
					arr[i] += arr[i + dice];
				}
			}
		}
		return arr[s];
	}

	public static int countpath2dtab(int sr, int sc, int dr, int dc) {
		int[][] arr = new int[dr + 1][dc + 1];
		arr[dr][dc] = 1;

		// not using the answer for arr[dr][dc]=1;
		// loop from arr.length-1
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr[0].length - 2; j >= 0; j--) {

				arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
			}
		}

		return arr[sr][sc];
	}

	public static int mincost(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = cost[i][j];
				} else if (i == dp.length - 1) {
					dp[i][j] = cost[i][j] + dp[i][j + 1];
				} else if (j == dp[0].length - 1) {
					dp[i][j] = cost[i][j] + dp[i + 1][j];
				} else {
					dp[i][j] = cost[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
				}

			}
		}
		return dp[0][0];
	}

	public static int max(int... vals) {
		int max = vals[0];
		for (int i = 1; i < vals.length; i++) {
			max = Math.max(max, vals[i]);
		}
		return max;
	}

	public static int goldmine(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];

		for (int j = dp[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < dp.length; i++) {
				if (j == dp[0].length - 1) {
					dp[i][j] = cost[i][j];
				} else if (i == 0) {
					dp[i][j] = cost[i][j] + max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == dp.length - 1) {
					dp[i][j] = cost[i][j] + max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = cost[i][j] + max(dp[i + 1][j + 1], dp[i][j + 1], dp[i - 1][j + 1]);
				}
			}
		}
		int max1 = dp[0][0];
		for (int i = 0; i < dp.length; i++) {
			max1 = Math.max(max1, dp[i][0]);
		}
		return max1;
	}

	public static void printpathgoldmine(int[][] cost, int r, int c, int asf) {
		if (c > cost[0].length - 1) {
			System.out.println(asf);
			return;
		}
		for (int j = cost[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < cost.length; i++) {

			}
		}
	}

	public static boolean[][] targetsum(int[] arr, int tar) {
		boolean[][] dp = new boolean[arr.length + 1][tar + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp[i][j];
				} else

				{
					if (j - arr[i - 1] >= 0) {
						dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		System.out.println(dp[arr.length][tar]);
		return dp;
	}

	public static void printpath(boolean[][] dp, int[] arr, int i, int j, String asf) {
		if (i == 0) {

			if (j == 0) {
				System.out.print(asf);
			}
			return;
		}
		if (dp[i - 1][j] == true) {
			printpath(dp, arr, i - 1, j, asf);
		}
		if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == true) {
			printpath(dp, arr, i - 1, j - arr[i - 1], asf + " " + arr[i - 1]);
		}
	}

	public static int knapsack1(int[] wts, int[] prices, int vidx, int rc, int[][] qb) {
		if (vidx == wts.length) {
			return 0;
		}
		if (qb[vidx][rc] != 0) {
			return qb[vidx][rc];
		}

		int ans = 0;
		int valno = knapsack1(wts, prices, vidx + 1, rc, qb);
		if (wts[vidx] <= rc) {
			int valyes = prices[vidx] + knapsack1(wts, prices, vidx + 1, rc - wts[vidx], qb);
			ans = Math.max(valno, valyes);
		} else {
			ans = valno;
		}
		qb[vidx][rc] = ans;
		return ans;
	}

	public static boolean[][] countpalinsub(String str) {
		boolean[][] arr = new boolean[str.length()][str.length()];
		int count = 0;
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); j++, i++) {
				if (gap == 0) {
					arr[i][j] = true;
				} else if (gap == 1) {
					arr[i][j] = str.charAt(i) == str.charAt(j);
				} else {
					arr[i][j] = str.charAt(i) == str.charAt(j) && arr[i + 1][j - 1] == true;
				}
				if (arr[i][j] == true) {
					count++;
				}
			}
		}
		return arr;
	}

	public static int minpalcut(String s, int i, int j, boolean[][] palindrome, int[][] qb) {
		if (palindrome[i][j] == true) {
			return 0;
		}

		if (qb[i][j] != 0) {
			return qb[i][j];
		}
		int minc = Integer.MAX_VALUE;
		for (int cp = i; cp < j; cp++) {
			int lc = minpalcut(s, i, cp, palindrome, qb);
			int rc = minpalcut(s, cp + 1, j, palindrome, qb);
			int tc = lc + rc + 1;
			minc = Math.min(minc, tc);
		}

		qb[i][j] = minc;
		return minc;
	}

	public static int mcm(int[] dims, int i, int j) {
		if (j - i == 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = i + 1; k < j; k++) {
			int leftside = mcm(dims, i, k);
			int rightside = mcm(dims, k, j);

			int costmatrix = dims[i] * dims[j] * dims[k];
			min = Math.min(min, leftside + rightside + costmatrix);
		}
		return min;
	}

	public static int mcmtab(int[] dims) {
		int[][] dp = new int[dims.length][dims.length];

		for (int gap = 1; gap < dims.length; gap++) {
			for (int i = 0, j = i + gap; j < dims.length; i++, j++) {
				if (gap == 1) {
					dp[i][j] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for (int cp = i + 1; i <= j - 1; i++) {
						int upppart = dp[i][cp];
						int lowerprt = dp[cp][j];
						int cost = dims[i] * dims[cp] * dims[j];

						int tc = upppart + lowerprt + cost;

						min = Math.min(min, tc);
						dp[i][j] = min;
					}

				}

			}
		}
		return dp[0][dims.length - 1];
	}

	public static void minjumps(int[] arr) {
		Integer[] dp = new Integer[arr.length];
		dp[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = 1; j <= arr[i] && i + j < arr.length; j++) {
				if (dp[i + j] != null) {
					dp[i] = dp[i] == null || dp[i + j] < dp[i] ? dp[i + j] : dp[i];
				}
			}
			if (dp[i] != null) {
				dp[i]++;
			}

		}
		for (Integer val : dp) {
			System.out.println(val + " ");
		}

	}

	public static void longesincsub(int[] arr) {
		int[] dp = new int[arr.length];

		dp[0] = 1;

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < dp.length; i++) {

			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {

				if (arr[i] > arr[j]) {

					dp[i] = Math.max(dp[i], dp[j] + 1);
				}

			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

		System.out.println();

		for (int val : dp) {

			System.out.println(val + " ");

		}

	}

	public static void coinchangePermutation(int[] coins, int amt) {
		int[] strg = new int[amt + 1];
		strg[0] = 1;
		for (int i = 1; i < strg.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					strg[i] += strg[i - coins[j]];
				}
			}
		}
		System.out.print(strg[strg.length - 1]);
	}

	public static void coinchangecombinations(int[] coins, int amt) {
		int[] strg = new int[amt + 1];
		strg[0] = 1;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i < strg.length; i++) {
				if (i - coins[j] >= 0) {
					strg[i] += strg[i - coins[j]];
				}
			}
		}
		System.out.print(strg[strg.length - 1]);
	}

	public static int longestbitonicsub(int[] arr) {
		Integer[] dp = new Integer[arr.length];
		Integer[] dp2 = new Integer[arr.length];

		dp[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} else {
					dp[i] = 1;
				}
			}
		}

		// Soumya
		dp2[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				} else {
					dp2[i] = 1;
				}
			}
		}

		// Rajneesh LDS Method from reverse way.
		// dp2[arr.length - 1] = 1;
		// for (int i = arr.length - 2; i >= 0; i--) {
		// for (int j = i + 1; j < arr.length; j++) {
		// if (arr[i] > arr[j]) {
		// dp2[i] = Math.max(dp2[i], dp2[j] + 1);
		// } else {
		// dp2[i] = 1;
		// }
		// }
		// }

		int overallMax = 1;
		for (int i = 0; i < arr.length; i++) {
			overallMax = Math.max(overallMax, dp[i] + dp2[i] - 1);
		}
		return overallMax;
	}

	public static boolean ispalindrome(String str, int sp, int ep) {
		int left = sp;
		int right = ep;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static int mpc(String str, int sp, int ep) {
		if (ispalindrome(str, sp, ep)) {
			return 0;
		}
		int tc = Integer.MAX_VALUE;
		for (int cp = sp; cp < ep; cp++) {
			int rc = mpc(str, sp, cp);
			int lc = mpc(str, cp + 1, ep);
			tc = Math.min(tc, lc + rc + 1);
		}
		return tc;
	}

	public static int matrixchainmult(int[] arr, int sp, int ep, int[][] qb) {
		if ((ep - sp) == 1) {
			return 0;
		}
		if (qb[sp][ep] != 0) {
			return qb[sp][ep];
		}
		int min = Integer.MAX_VALUE;

		for (int i = sp + 1; i < ep; i++) { // why sp+1? [10 20] here sp is 0
											// and "i" is
			int leftSideCost = matrixchainmult(arr, sp, i, qb);
			int rightSideCost = matrixchainmult(arr, i, ep, qb);

			int ActualCost = arr[sp] * arr[ep] * arr[i];

			min = Math.min(min, ActualCost + leftSideCost + rightSideCost);

		}
		qb[sp][ep] = min;
		return min;
	}

	public static int Stringcombo(String str) {
		int ca = 0;
		int cb = 0;
		int cc = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				ca = 1 + (2 * ca);
			} else if (str.charAt(i) == 'b') {
				cb = ca + (2 * cb);
			} else if (str.charAt(i) == 'c') {
				cc = cb + (2 * cc);
			}
		}
		return cc;
	}

	public static void targetsum1(int[] arr, int n) {
		boolean[][] dp = new boolean[arr.length + 1][n + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i >= 1 && dp[i - 1][j]) {
					dp[i][j] = dp[i - 1][j];
				} else if (i >= 1 && j - arr[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		System.out.println(dp[arr.length][dp[0].length - 1]);
	}

	public static int knapsack(int[] wts, int[] cost, int cap) {
		int[][] dp = new int[wts.length + 1][cap + 1];

		for (int wtgItr = 1; wtgItr < dp.length; wtgItr++) {
			for (int capItr = 1; capItr < dp[0].length; capItr++) {

				int NotComingCost = dp[wtgItr - 1][capItr];
				int comingCost = 0;
				if (capItr - wts[wtgItr - 1] >= 0) {
					comingCost = cost[wtgItr - 1] + dp[wtgItr - 1][capItr - wts[wtgItr - 1]];
				}
				dp[wtgItr][capItr] = Math.max(comingCost, NotComingCost);
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int eggdrop(int floor, int eggs) {
		if (eggs == 0 || eggs == 1 || floor == 0 || floor == 1) {
			return floor;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= floor; i++) {
			int EggNotBreak = eggdrop(floor - i, eggs);
			int eggBreak = eggdrop(i - 1, eggs - 1);
			int ans = Math.max(EggNotBreak, eggBreak);

			if (ans < min) {
				min = ans;
			}
		}
		return min + 1;
	}

	public static int matrix(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1) {
					dp[i][j] = arr[i][j];
				} else if (j == dp[0].length - 1) {
					dp[i][j] = arr[i][j];
				} else if (arr[i][j] != 0) {
					min = Math.min(dp[i + 1][j + 1], (Math.min(dp[i + 1][j], dp[i][j + 1])));
					dp[i][j] = min + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

	public static int unboundedknapsack(int[] wts, int[] cost, int cap) {
		int[] dp = new int[cap + 1];
		dp[0] = 0;
		for (int i = 1; i <= cap; i++) {
			dp[i] = 0;
			int ans = 0;
			for (int j = 0; j < wts.length; j++) {
				if ((i - wts[j]) >= 0) {
					ans = Math.max(dp[i - wts[j]] + cost[j], ans);
				}

			}

		}
		return cap;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 3, 13, 11, 7, 15 };
		longesincsub(arr);

	}
}