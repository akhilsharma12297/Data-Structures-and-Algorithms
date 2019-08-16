package Recursion;

import java.util.TreeSet;

public class Max_Gap {

	public static void main(String[] args) {
		int[] arr = { 10 };

		func(arr);
	}

	private static void func(int[] arr) {

		TreeSet<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {

			if (set.higher(arr[i]) != null) {

				System.out.println(set.higher(arr[i]) + " " + arr[i]);
				ans = Math.max(ans, set.higher(arr[i]) - arr[i]);
			}

		}
		System.out.println(ans);
	}

}
