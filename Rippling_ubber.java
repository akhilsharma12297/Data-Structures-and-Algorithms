import java.util.ArrayList;

public class Rippling_ubber {

	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		int time = 10;

		int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 2, 5, 3, 6, 8, 1, 2, 3, 6, 4, 1, 3 };

		func(arr, 0, time, 0, new ArrayList<Integer>());

		System.out.println(result + " + " + max);
	}

	public static void func(int[] arr, int idx, int time, int sumSF, ArrayList<Integer> list) {

		if (idx == arr.length) {

			if (sumSF == time) {

				if (list.size() > max) {

					max = list.size();
					result = list;

					System.out.println(max);

					System.out.println(result);

				}

			}
			return;

		}

		func(arr, idx + 1, time, sumSF, list);

		sumSF += arr[idx];

		list.add(arr[idx]);

		func(arr, idx + 1, time, sumSF, list);

		sumSF -= arr[idx];

		list.remove(list.size() - 1);

	}
}
