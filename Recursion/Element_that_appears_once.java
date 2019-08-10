package Recursion;

public class Element_that_appears_once {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 3, 4, 4, 5, 5, 7, 7, 8, 8 };

		System.out.println(Search(arr));
	}

	private static int Search(int[] arr) {

		int n = arr.length, lo = 0, hi = n / 2;
		while (lo < hi) {

			int mid = (lo + hi) / 2;

			if (arr[2 * mid] != arr[2 * mid + 1])

				hi = mid;
			else
				lo = mid + 1;
		}
		return arr[2 * lo];
	}

}
