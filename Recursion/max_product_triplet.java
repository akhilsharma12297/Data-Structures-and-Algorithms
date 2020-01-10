package Recursion;

public class max_product_triplet {

	public static void main(String[] args) {

		int arr[] = { 1, -4, 3, -6, 7, 0 };

		System.out.println(func(arr, 0, 0, Integer.MIN_VALUE, 1));

	}

	public static int func(int arr[], int idx, int ctr, int max, int currProduct) {

		if (idx >= arr.length) {

			if (currProduct > max) {
				max = currProduct;
			}
			return max;
		}

		int ans_1 = -1;

		if (ctr + 1 != 4) {

			ans_1 = func(arr, idx + 1, ctr + 1, max, currProduct * arr[idx]);
		}
		int ans_2 = func(arr, idx + 1, ctr, max, currProduct);

		return Math.max(ans_1, ans_2);
	}

}
