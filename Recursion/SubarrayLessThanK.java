package Recursion;

public class SubarrayLessThanK {

	public static void main(String[] args) {

		int arr[] = { 1, 9, 2, 8, 6, 4, 3 };

		System.out.println(func(arr, 100));

	}

	public static int func(int arr[], int k) {

		if (k <= 1)
			return 0;
		int prod = 1, ans = 0, left = 0;

		for (int right = 0; right < arr.length; right++) {
			prod *= arr[right];

			while (prod >= k) {
				prod /= arr[left++];
			}
			ans += right - left + 1;
		}
		return ans;

	}

}