package rip.again;

import java.util.Arrays;
import java.util.HashSet;

public class solution {

    public static int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        int opp = 0;

        while (r > l && l >= 0 && l < nums.length - 1 && r >= 0 && r <= nums.length - 1) {

            if (k == nums[l] + nums[r]) {

                opp++;

                l++;
                r--;

            } else if (k < nums[l] + nums[r]) {
                r--;
            } else {
                l++;
            }

        }

        return opp;

    }

    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = (double) sum / k;

        for (int i = k; i < nums.length; i++) {

            sum -= nums[i - k];

            sum += nums[i];

            maxAvg = Math.max(maxAvg, (double) sum / k);


        }

        return maxAvg;

    }

    public int maxVowels(String s, int k) {

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

        int slow = 0;
        int fast = 0;

        int vctr = 0;

        while (fast > k) {

            if (vowels.contains(s.charAt(fast))) {
                vctr++;
            }

            fast++;

        }

        int result = vctr;

        while (fast < s.length()) {

            slow++;
            fast++;

            if (vowels.contains(s.charAt(slow--))) {
                vctr--;
            }


            if (vowels.contains(s.charAt(fast))) {
                vctr++;
            }

            result = Math.max(result, vctr);

        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4));

    }
}
