package Recursion;

public class Petrol_pump {

	public static void main(String[] args) {

		int[] petrol = { 4, 6, 6, 5 };

		int[] dist = { 7, 3, 4, 5 };

		System.out.println(func(dist, petrol));

	}

	private static int func(int[] dist, int[] petrol) {

		for (int i = 0; i < petrol.length; i++) {
			if (func(petrol, dist, i)) {
				return i;
			}
		}
		return -1;

	}

	private static boolean func(int[] petrol, int[] dist, int i) {
		int d = i;

		int petrolrem = 0;

		do {
			petrolrem += petrol[i] - dist[i];
			if (petrolrem >= 0) {
				i++;
			}
			if (petrolrem < 0) {
				break;
			}

			if (i >= petrol.length) {
				i = 0;
			}
		} while (d != i);

		if (petrolrem >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
