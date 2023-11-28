package rip;

import java.util.Arrays;

public class productOfArray {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (j != i) {
                    int mult = result[i] * nums[j];
                    result[i] = mult;
                }
            }

        }

        return result;
    }

    public static int[] productExceptSelf2(int[] nums) {

        int[] result = new int[nums.length];

        int[] left = new int[nums.length];
        left[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                result[i] = right[i + 1];
            } else if (i + 1 >= nums.length) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] num1 = new int[]{1, 2, 3, 4};
//        Output: [24, 12, 8, 6]

        int[] num2 = new int[]{-1, 1, 0, -3, 3};
//        Output: [0,0,9,0,0]

        System.out.println(Arrays.toString(productExceptSelf2(num1)));

    }


}
