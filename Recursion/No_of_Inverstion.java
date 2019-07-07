package Recursion;

public class No_of_Inverstion {

	public static void main(String[] args) {

	}

	public static int inversion(int[] arr) {

		return CountInversion(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static int CountInversion(int[] arr, int[] temp, int low, int high) {

		int inversionCtr = 0;

		while (high > low) {
			int mid = (low + high) / 2;
			inversionCtr = CountInversion(arr, temp, low, mid);

			inversionCtr += CountInversion(arr, temp, mid + 1, high);

			inversionCtr += MergeSorted(arr, temp, low, high);
		}

		return inversionCtr;

	}

	private static int MergeSorted(int[] arr, int[] temp, int low, int high) {

		
		
		return 0;
	}

}
