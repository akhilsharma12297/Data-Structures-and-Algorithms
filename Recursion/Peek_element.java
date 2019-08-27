package Recursion;

public class Peek_element {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 15, 2, 23, 90, 67 };

		peek(arr);
		System.out.println();
		System.out.println(findPeak(arr));
	}

	private static void peek(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {

				if (arr[i] > arr[i + 1]) {
					System.out.println(arr[i]);
				}

			} else if (i == arr.length - 1) {
				if (arr[i - 1] < arr[i]) {
					System.out.println(arr[i]);
				}
			} else {
				if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
					System.out.print(arr[i] + " ");
				}
			}
		}

	}

	public static int findPeakUtil(int arr[], int low, int high, int n) {
		int mid = low + (high - low) / 2;

		if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
			return mid;

		else if (mid > 0 && arr[mid - 1] > arr[mid])
			return findPeakUtil(arr, low, (mid - 1), n);

		else
			return findPeakUtil(arr, (mid + 1), high, n);
	}

	public static int findPeak(int arr[]) {
		return findPeakUtil(arr, 0, arr.length - 1, arr.length);
	}
}
