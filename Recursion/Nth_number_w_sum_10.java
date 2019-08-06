package Recursion;

public class Nth_number_w_sum_10 {
	public static void main(String[] args) {
		func(100);
	}

	private static void func(int n) {

		int ans = 19 + (n - 1) * 9;

		int tens = (int) Math.log10(ans) - 1;

		ans += 9 * tens;

		System.out.println(ans);
	}
}
