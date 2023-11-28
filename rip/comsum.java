package rip;

import java.util.ArrayList;
import java.util.List;

class comsum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, result, new ArrayList<>());
        return result;

    }

    public static void helper(int[] arr, int idx, int sum, List<List<Integer>> result, ArrayList<Integer> ans) {

        if (idx == arr.length) {
            if (sum == 0) {
                result.add(ans);
            }
            return;
        }

        if (arr[idx] <= sum) {
            ans.add(arr[idx]);

            helper(arr, idx + 1, sum - arr[idx], result, ans);

            ans.remove(ans.size() - 1);

        }

        helper(arr, idx + 1, sum, result, ans);
    }

//    //    //    //    //    //    //    //    //    //    //    //    //    //    //    //    //    //    //    //

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;

    }

    public static List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper2(nums, 0, new ArrayList<>(), result);
        return result;

    }


    public static void helper(int[] arr, int idx, List<Integer> ans, List<List<Integer>> result) {

        if (ans.size() == arr.length) {
            result.add(new ArrayList<>(ans));
            return;
        }


        for (int i = idx; i < arr.length; i++) {

            ans.add(arr[i]);
            helper(arr, i, ans, result);
            ans.remove(ans.size() - 1);

        }


        helper(arr, idx + 1, ans, result);

    }

    public static void helper2(int[] arr, int idx, List<Integer> ans, List<List<Integer>> result) {

        if (ans.size() == arr.length) {
            result.add(new ArrayList<>(ans));
            return;
        }

        if (idx < arr.length) {
            ans.add(arr[idx]);
            helper2(arr, idx + 1, ans, result);
            ans.remove(ans.size() - 1);

            helper2(arr, idx + 1, ans, result);
        }

    }


    public static void main(String[] args) {
//        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute2(new int[]{1, 2, 3}));
    }
}