package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quadruplets_target {

	public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {
				int newTarget = target - nums[i] - nums[j];

				int l = j + 1;
				int r = nums.length - 1;

				while (l > r) {

				}
			}

		}

		return null;

		// write your code here
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + ",");
			}
			System.out.println();
		}

	}

}