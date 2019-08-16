package Recursion;

public class Next_Permutation {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 1, 5, 4, 3, 0 };
		nextPermutation(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static void nextPermutation(int[] arr) {

		int i = arr.length - 2;

		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}

		if (i >= 0) {

			int j = arr.length - 1;
			while (j >= 0 && arr[j] <= arr[i]) {
				j--;
			}

			swap(arr, i, j);
		}

		rev(arr, i + 1);
	}

	private static void rev(int[] arr, int i) {
		int left = i;
		int right = arr.length - 1;
		while (right > left) {
			swap(arr, left, right);
			left++;
			right--;
		}

	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[j];

		arr[j] = arr[i];

		arr[i] = temp;
	}

}
