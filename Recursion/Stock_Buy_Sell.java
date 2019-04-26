package Recursion;

public class Stock_Buy_Sell {

	static int max = Integer.MIN_VALUE;

	static void stockBuySell(int[] price) {

		int n = price.length;

		if (n == 1) {
			return;

		}

		int start = 0, end = 0;

		int flag = 0;

		for (int i = 0; i < n - 1; i++) {

			if (price[i + 1] - price[i] > 0)

				flag = 1;

			if (!(price[i + 1] - price[i] > 0) || price[i + 1] - price[i] > 0 && (i + 1 == n - 1)) {

				if (i + 1 == n - 1)
					end = i + 1;

				else

					end = i;

				if ((end - start) > max) {
					max = price[end] - price[start];

					System.out.println(start + " " + end);

				}

				start = i + 1;
			}

			if (flag == 0)

				System.out.println("not found");

		}
	}

	public static void main(String args[]) {

		int price[] = { 5, 9, 0, 1, 2, 4 };

		stockBuySell(price);

		System.out.println(max);

	}
}
