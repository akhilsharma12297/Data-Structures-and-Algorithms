package rip;

public class del {

    public static long getMaximumProfit(int[] price, int[] profit) {
        int n = price.length;
        long maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (price[i] < price[j] && price[j] < price[k]) {
                        long totalProfit = profit[i] + profit[j] + profit[k];
                        maxProfit = Math.max(maxProfit, totalProfit);
                    }
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 3, 4, 6};
        int[] profit = {2, 3, 4, 5, 6};
        long result = getMaximumProfit(price, profit);
        System.out.println(result);  // Output: 15
    }
}