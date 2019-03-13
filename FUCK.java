
public class FUCK {

	private static int func(int[] arr, int lo, int hi) {

		int x = (lo + hi) / 2;

		if (lo == hi && arr[lo] == 0) {
			return lo;
		}

		if (arr[x] == 0) {

			return func(arr, x + 1, hi);

		} else if (arr[x] == 1) {

			return func(arr, lo, x - 1);

		}

		return -1;

	}

	public static int func(int[] arr) {

		if (arr[0] == 1)
			return 0;
		else
			return func(arr, 0, arr.length);
	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1 };

		System.out.println(func(arr) + 1);

	}
}
