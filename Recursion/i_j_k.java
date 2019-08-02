package Recursion;

public class i_j_k {

	public static void main(String[] args) {

		int[] arr = {};

		func(arr);
	}

	private static void func(int[] arr) {
		int ans = 0;

		for (int i = 1; i < arr.length - 1; i++) {
			int max1 = 0;
			int max2 = 0;
			for (int j = 0; i < j; i++) {
				if (arr[j] < arr[i])
					max1 = Math.max(max1, arr[j]);
			}

			for (int j = i + 1; j < arr.length; i++) {

				if (arr[j] > arr[i]) {
					max2 = Math.max(max2, arr[j]);
				}

			}

			ans = Math.max(ans, max1 + arr[i] + max2);
		}

		System.out.println(ans);
	}

}
