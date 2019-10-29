package Recursion;

public class Stairs_with_only_number {

	public static void main(String[] args) {

		System.out.println(func(9));
		System.out.println(better(9));
	}

	public static int func(int n) {
		int[] ans = new int[n + 1];

		ans[0] = 1;
		ans[1] = 1;

		for (int i = 2; i <= n; i++) {

			ans[i] += ans[i - 2] + ans[i - 1];
		}
		return ans[n];
	}

	public static int better(int n) {
		if (n <= 0)
			return 0;

		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int n1 = 1;
		int n2 = 2;
		int ans = 0;

		for (int i = 2; i < n; i++) {
			ans = n2 + n1;
			n1 = n2;
			n2 = ans;
		}
		return ans;
	}

}
