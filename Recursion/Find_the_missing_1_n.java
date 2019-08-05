package Recursion;

public class Find_the_missing_1_n {

	public static void main(String[] args) {

		int[] arr = { 10, 1, 9, 2, 8, 3, 7, 5, 4 };

		funcSum(arr);

		int arrSorted[] = { 1, 2, 3, 4, 5, 7, 8 };
		System.out.println(funcLogNSorted(arrSorted));

	}

	private static void FuncXor(int[] arr) {

		int xor = 0, i = 0;
		for (i = 0; i < arr.length; i++) {
			xor = xor ^ i ^ arr[i];
		}

		System.out.println(xor ^ i);
	}

	public static void funcSum(int[] arr) {
		int n = arr.length;

		int sum = (n) * (n + 1) / 2;

		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
		}

		System.out.println(sum);
	}

	public static int funcLogNSorted(int[] arr) {

		int low = 0;
		int high = arr.length - 1;

		while (high >= low) {

			int mid = (low + high) / 2;

			if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
				return (mid + 1);
			}
			if (arr[mid] != mid + 1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return -1;

	}

}