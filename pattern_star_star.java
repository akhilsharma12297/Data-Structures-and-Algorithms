import java.util.Scanner;

public class pattern_star_star {
	public static void func(int p, int av, int min, int op, int x) {

		int cost = min * p;
		int diff = x - min;
		if (diff > 0) {

			cost += diff * op;

		}

		System.out.print(cost);

	}

	public static void main(String args[]) throws Exception {

		Scanner scn = new Scanner(System.in);

		int oc = scn.nextInt();

		int av = scn.nextInt();

		int min = scn.nextInt();

		int ovp = scn.nextInt();

		int x = scn.nextInt();

		func(oc, av, min, ovp, x);

	}

}
