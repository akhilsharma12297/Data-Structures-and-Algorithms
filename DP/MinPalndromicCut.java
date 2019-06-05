package DP;

public class MinPalndromicCut {

	public static void main(String[] args) {

		String str = "abccbc";

		System.out.println(mcp(str, 0, str.length() - 1));

	}

	public static int mcp(String str, int sp, int ep) {

		if (ispalndrome(str, sp, ep)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int cp = sp; cp < ep; cp++) {

			int lp = mcp(str, sp, cp);
			int rp = mcp(str, cp + 1, ep);

			int total = lp + rp + 1;
			min = Math.min(min, total);
		}

		return min;

	}

	private static boolean ispalndrome(String str, int sp, int ep) {
		int l = sp;
		int r = ep;

		while (r > l) {

			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			r--;
			l++;
		}

		return true;
	}

}
