package Recursion;

public class First_Last_positions_in_Sorted_array {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int x = 8;
		System.out.println(first(arr, 0, arr.length - 1, x));
		System.out.println(last(arr, 0, arr.length - 1, x));
	}

	private static int first(int[] arr, int low, int high, int x) {

		if (low <= high) {
			int mid = (low + high) / 2;
			if (mid == 0 || arr[mid - 1] < x && arr[mid] == x) {
				return mid;
			} else if (x > arr[mid]) {
				return first(arr, mid + 1, high, x);
			} else {
				return first(arr, low, mid - 1, x);
			}
		}
		return -1;
	}

	private static int last(int[] arr, int low, int high, int x) {

		if (low <= high) {
			int mid = (low + high) / 2;
			if (mid == arr.length - 1 || arr[mid] == x && arr[mid + 1] > x) {
				return mid;
			} else if (x < arr[mid]) {
				return last(arr, low, mid - 1, x);
			} else {
				return last(arr, mid + 1, high, x);
			}
		}
		return -1;

	}

}
