import java.util.HashMap;
import java.util.Scanner;
public class ESKO_FLIGHT_QUES {
	public static void main(String args[]) throws Exception {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		Double[] team = new Double[n];

		Double[] cost = new Double[n];

		HashMap<Double, Double> teamMap = new HashMap<>();

		int ctr = 1;

		for (int i = 0; i < n; i++) {

			Double t = scn.nextDouble();
			Double c = scn.nextDouble();

			teamMap.put(t, c);

		}

		for (int i = 0; i < teamMap.size(); i++) {
			if (teamMap.get(i) != null)
				;
		}

		for (int j = 0; j < n; j++) {

			Double dec = (cost[j] / team[j]);

			int bal = (int) (cost[j] / team[j]);

			if (!(dec == bal)) {

				ctr++;

				adder(cost, j);
				j = -1;

			}

		}

		if (ctr > 0) {
			System.out.println(ctr);
		}

		else {
			System.out.println(0);
		}

	}

	public static void adder(Double[] price, int i) {

		price[i] = price[i] + 1;

	}

}
