package rip;

import java.util.HashMap;

public class lcs {


    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                map.put(num, false);
            }
        }

        System.out.println(map);

        int range = 0;

        for (int num : nums) {

            if (map.get(num)) {
                int temp = 1;
                while (map.containsKey(num + temp)) {
                    temp++;
                }
                if (temp > range) {
                    range = temp;
                }
            }

        }

        return range;

    }

    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));

    }
}
