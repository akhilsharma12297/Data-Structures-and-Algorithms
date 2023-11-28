package rip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

    public static void main(String[] args) {

        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {

            if (i < arr.length - 2 && arr[i] == arr[i + 1]) {
                i++;
            }

            int j = 0;

            int k = arr.length - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    while (k > j && arr[j] == arr[j + 1]) {
                        j++;
                    }

                    while (k > j && arr[k - 1] == arr[k]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }

            }

        }

        System.out.println(result);

    }
}
