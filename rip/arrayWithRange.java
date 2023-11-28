package rip;

import java.util.Arrays;

public class arrayWithRange {


    public static int[][] calculateRegionSums(int[][] input, int r) {
        int N = input.length;
        int M = input[0].length;

        int[][] prefixSum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = input[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for (int[] row : prefixSum) {
            System.out.println(Arrays.toString(row));
        }


        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int x1 = Math.max(0, i - r);
                int y1 = Math.max(0, j - r);
                int x2 = Math.min(N - 1, i + r);
                int y2 = Math.min(M - 1, j + r);
                dp[i][j] = prefixSum[x2 + 1][y2 + 1] - prefixSum[x1][y2 + 1] - prefixSum[x2 + 1][y1] + prefixSum[x1][y1];
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        int[][] inputMatrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        for (int[] row : inputMatrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();

        int r1 = 1;

        int[][] output1 = calculateRegionSums(inputMatrix, r1);

        System.out.println("When r = 1:");
        for (int[] row : output1) {
            System.out.println(Arrays.toString(row));
        }
    }
}


