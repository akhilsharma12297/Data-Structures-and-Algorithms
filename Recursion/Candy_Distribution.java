package Recursion;

public class Candy_Distribution {

	public static void code(int[] ratings) {

		if (ratings == null || ratings.length == 0)
			return;

		int[] candies = new int[ratings.length];

		candies[0] = 1;

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i] > ratings[i - 1])
				candies[i] = candies[i - 1] + 1;
			else {
				candies[i] = 1;
			}
		}

		int result = candies[candies.length - 1];

		for (int i = ratings.length - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1])
				cur = candies[i + 1] + 1;
			result += Math.max(cur, candies[i]);

			candies[i] = cur;

			System.out.print(candies[i] + " ");
		}
		System.out.println();
		System.out.print(result);
	}

	public static void ans(int[] arr) {

		int n = arr.length;

		int candies[] = new int[n];
		candies[0] = 1;

		for (int i = 1; i < n; i++) {
			if (candies[i] == 0) {
				candies[i] = 1;
			}
			if (arr[i] > arr[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i] && candies[i - 1] <= candies[i]) {
				candies[i - 1] = candies[i] + 1;
			}
		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += candies[i];

			System.out.print(candies[i] + " ");
		}
		System.out.println();
		System.out.print(sum);

	}

	public static void main(String[] args) {

		int[] arr = { 6, 3, 4, 4, 3, 2, 1 };
		int[] arr2 = { 8, 1, 2, 2, 3, 4, 3, 2, 1 };

		ans(arr2);

	}
}