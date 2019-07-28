package Recursion;

import java.util.*;

public class FourSum {

	public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 4)
			return list;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return list;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {

			if (i > 0 && nums[i] == nums[i - 1])// avoid duplicate
			{
				continue;
			}

			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])// avoid duplicate
				{
					continue;
				}

				int l = j + 1;

				int r = nums.length - 1;

				int sumReq = target - (nums[i] + nums[j]);

				while (l < r) {
					int sum = nums[l] + nums[r];
					if (sum < sumReq) {
						l++;
					} else if (sum > sumReq) {
						r--;
					} else {
						ArrayList<Integer> list2 = new ArrayList<>();
						list2.add(nums[i]);
						list2.add(nums[j]);
						list2.add(nums[l]);
						list2.add(nums[r]);
						list.add(list2);
						l++;
						r--;
						while (l < r && nums[l] == nums[l - 1]) { // avoid
																	// duplicate
							l++;
						}

						while (l < r && nums[r] == nums[r + 1]) { // avoid
																	// duplicate
							r--;
						}
					}
				}
			}
		}

		return list;
	}

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
				System.out.print(element + " ");
			}
			System.out.println();
		}

	}

}