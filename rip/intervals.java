package rip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by ascending starting point
//        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        result.add(temp);
        for (int[] interval : intervals) {
            if (interval[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], interval[1]);
            } else { // Overlapping intervals, move the end if needed // Disjoint intervals, add the new interval to the list
                temp = interval;
                result.add(temp);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        intervals = Arrays.copyOf(intervals, intervals.length + 1);
        intervals[intervals.length - 1] = newInterval;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        result.add(temp);

        for (int[] c : intervals) {

            if (c[0] <= temp[1]) {
                temp[1] = Math.max(c[1], temp[1]);
            } else {
                temp = c;
                result.add(temp);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private static void printMatrix(int[][] cps) {
        for (int i = 0; i < cps.length; i++) {
            for (int j = 0; j < cps[0].length; j++) {

                System.out.print(cps[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

//        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});


    }
}
