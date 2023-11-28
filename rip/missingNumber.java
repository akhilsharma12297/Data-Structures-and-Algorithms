package rip;

import java.util.PriorityQueue;

public class missingNumber {

    public static int missingNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int lastRemoved = -1;
        while (!pq.isEmpty()) {

            if (lastRemoved == -1) {
                lastRemoved = pq.remove();
            }

            int top = pq.remove();

            if ((lastRemoved + 1) != top) {
                return lastRemoved + 1;
            }else{
                lastRemoved = top;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int ans = missingNumber(new int[]{3, 0, 1});
        System.out.println(ans);
    }


}
