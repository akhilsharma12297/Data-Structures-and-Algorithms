package Recursion;

public class Min_element_Sorted_Rotated_Array {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(minSearch(arr));
	}

	private static int minSearch(int[] arr) {
		return minSearch(arr, 0, arr.length - 1);
	}

	private static int minSearch(int[] arr, int low, int high) {

		if (low > high) {
			return arr[0];
		}

		int mid = (low + high) / 2;

		if (low == high) {
			return arr[low];
		}

		if (arr[mid] > arr[mid + 1]) {
			return arr[mid + 1];
		}

		if (arr[mid - 1] > arr[mid]) {
			return arr[mid];
		}

		if (arr[high] > arr[mid])
			return minSearch(arr, low, mid - 1);
		return minSearch(arr, mid + 1, high);
	}

}
