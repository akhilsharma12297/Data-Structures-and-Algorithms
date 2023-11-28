package rip;

import java.util.Arrays;
import java.util.HashMap;

public class twosum {

    public static int[] TwoSums(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int required = target - nums[i];

            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    //sorted
    public static int[] twoSum2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if ((nums[left] + nums[right]) == target) {
                return new int[]{left, right};
            }

            if ((nums[left] + nums[right]) > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));

    }

}
