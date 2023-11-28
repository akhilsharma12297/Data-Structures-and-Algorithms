package rip;

public class kadane {

    public static int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;

    }


    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(maxSubArray(new int[]{1, 2}));

    }

}
