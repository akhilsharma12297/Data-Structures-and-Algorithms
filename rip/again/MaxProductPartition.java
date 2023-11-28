package rip.again;


//Divide the array into 2 parts such that the sum of elements of both the parts, gives the maximum possible product?
//
//        eg:
//        [1,2,3,4,5]
//        we can divide it into 2 parts as
//        [3,4] sum=7 and [1,2,5] sum=8
//        and it gives maximum product as 56
//        There are other ways also for dividing the array but, it will not give the maximum product.

import java.util.Arrays;

public class MaxProductPartition {

    public static int maxProductDivision(int[] ar) {
        Arrays.sort(ar);
        int max = Integer.MIN_VALUE, sum = 0;

        for (Integer i : ar)
            sum += i;

        int sumEx = ar[ar.length - 1];
        sum -= sumEx;

        for (int j : ar) {
            sum -= j;
            sumEx += j;
            int prod = sum * sumEx;
            max = Math.max(max, prod);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Maximum product: " + maxProductDivision(nums));
    }
}
