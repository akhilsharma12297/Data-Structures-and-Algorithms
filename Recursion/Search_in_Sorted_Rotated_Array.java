package Recursion;

public class Search_in_Sorted_Rotated_Array {

	public static void main(String[] args) {

		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int key = 6;

		System.out.println(search(arr, key));

	}

	public static int search(int[] arr, int key) {

		return searchHelper(arr, 0, arr.length - 1, key);

	}

	private static int searchHelper(int[] arr, int low, int high, int key) {

		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (arr[mid] == key) {
			return mid;
		}

		if (arr[low] <= arr[mid]) {
			if (key >= arr[low] && key <= arr[mid]) {
				return searchHelper(arr, low, mid - 1, key);
			}
			return searchHelper(arr, mid + 1, high, key);
		}

		if (key >= arr[mid] && key >= arr[high]) {
			return searchHelper(arr, mid + 1, high, key);
		}

		return searchHelper(arr, low, mid - 1, key);

	}

}