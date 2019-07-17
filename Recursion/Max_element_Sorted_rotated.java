package Recursion;

public class Max_element_Sorted_rotated {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(maxSearch(arr));
	}

	private static int maxSearch(int[] arr) {
		return maxSearch(arr, 0, arr.length - 1);
	}

	private static int maxSearch(int[] arr, int low, int high) {
		if (low > high) {
			return arr[0];
		}

		if (low == high) {
			return arr[low];
		}

		int mid = (low + high) / 2;

		if (arr[mid] > arr[mid + 1]) {
			return arr[mid];
		}

		if (arr[mid] < arr[mid - 1]) {
			return arr[mid - 1];
		}

		if (arr[low] > arr[mid]) {
			return maxSearch(arr, low, mid - 1);
		}
		return maxSearch(arr, mid + 1, high);

	}

}
