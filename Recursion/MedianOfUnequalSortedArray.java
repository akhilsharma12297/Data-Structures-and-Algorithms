package Recursion;

public class MedianOfUnequalSortedArray {

	public static void main(String[] args) {
		int[] arr = { 900 };
		int[] arr2 = { 10, 13, 14 };
		int arrsize = arr.length;
		int arr2size = arr.length;

		if (arrsize < arr2size) {
			System.out.println(func(arr, arrsize, arr2, arr2size));
		} else {
			System.out.println(func(arr, arr2size, arr2, arrsize));
		}
	}

	private static int func(int[] arr1, int n, int[] arr2, int m) {

		int maxidx = n;
		int minidx = m;
		int i = 0;
		int j = 0;

		while (minidx <= maxidx) {

			i = (minidx + maxidx) / 2;
			j = ((n + m + 1) / 2) - i;

			if (i < n && j > 0 && arr2[j - 1] > arr1[i])
				minidx = i + 1;
			else if (i > 0 && j < m && arr2[j] < arr1[i - 1])
				maxidx = i - 1;
			else {
				if (i == 0)
					return arr2[j - 1];

				if (j == 0)
					return arr1[i - 1];
				else
					return Math.max(arr1[i - 1], arr2[j - 1]);

			}
		}
		return -1;

	}
}
