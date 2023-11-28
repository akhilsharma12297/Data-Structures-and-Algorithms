package rip;

import java.util.Arrays;

public class koko {

    public static int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {

            int mid = (l + r) / 2;
            int k = 0;

            for (int p : piles) {
                k += (int) Math.ceil((double) p / mid);
            }

            if (k <= h) {
                res = Math.min(mid, res);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public static int checkForInt(int[] piles, int m) {

        int result = 0;

        for (int p : piles) {
            result += (int) Math.ceil((double) p / m);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));


    }
}
