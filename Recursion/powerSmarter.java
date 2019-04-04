package Recursion;

public class powerSmarter {

	public static void main(String[] args) {
		System.out.println(powersmarter(2, 6));

	}

	private static int powersmarter(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnb2 = powersmarter(x, n / 2);
		int xpn = xpnb2 * xpnb2;

		if (n % 2 == 1) {
			xpn = xpn * x;

		}

		return xpn;

	}

}
