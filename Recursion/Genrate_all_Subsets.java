package Recursion;

import java.util.*;

public class Genrate_all_Subsets {

	public static void main(String[] args) {

		int[] arr = { 8, 8, 0, 0, 8, 8, 5, 7, 6, 5 };
		List<List<Integer>> ans = subsets(arr);

		System.out.println(ans);
	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> set = new ArrayList<>();

		func(nums, 0, new ArrayList<>(), set);

		return set;
	}

	public static void func(int[] arr, int idx, ArrayList<Integer> ans, List<List<Integer>> set) {
		set.add(new ArrayList<>(ans));

		for (int i = idx; i < arr.length; i++) {
			ans.add(arr[i]);

			func(arr, i + 1, ans, set);

			ans.remove(ans.size() - 1);
		}
	}

}
