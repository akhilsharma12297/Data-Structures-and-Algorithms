
public class Rippling_ubber {
	
	
	public static void main(String[] args)
	{
		int traveltime = 0;
		int 
	}
	
	
	public static int knapsack(int[] wts, int[] cost, int cap) {
		int[][] dp = new int[wts.length + 1][cap + 1];

		for (int wtgItr = 1; wtgItr < dp.length; wtgItr++) {
			for (int capItr = 1; capItr < dp[0].length; capItr++) {

				int NotComingCost = dp[wtgItr - 1][capItr];
				int comingCost = 0;
				
				if (capItr - wts[wtgItr - 1] >= 0) {
					comingCost = cost[wtgItr - 1] + dp[wtgItr - 1][capItr - wts[wtgItr - 1]];
				}
				dp[wtgItr][capItr] = Math.max(comingCost, NotComingCost);
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
	
}
