package Recursion;

public class Two_sum_in_Sorted_Rotated_Array {

	public static void main(String[] args) {
		int arr[] = { 11, 15, 6, 8, 9, 10 };

		System.out.println(twoSum(arr, 16));
	}

	private static boolean twoSum(int[] arr, int x) {

		int n = arr.length;
		int i;
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}

		int left = (i + 1) % n;
		int right = i;

		while (left != right) {

			if (arr[left] + arr[right] == x) {
				return true;
			}

			else if (arr[left] + arr[right] < x) {
				left = (left + 1) % n;
			} else if (arr[left] + arr[right] > x) {
				right = (n + right - 1) % n;
			}

		}
		return false;

	}

}
