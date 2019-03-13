/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class BYJU_Q1_TEAM_DIVIDE {

	public static void main(String args[]) throws Exception {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int[] team = new int[n];

		int[] cost = new int[n];

		int ctr = 0;

		for (int i = 0; i < n; i++) {

			int t = scn.nextInt();
			int c = scn.nextInt();

			team[i] = t;
			cost[i] = c;

		}

		for (int i = 0; i < n; i++) {

			if (team[i] != 0) {
				int dec = cost[i] / team[i];

				int bal = cost[i] % team[i];

				if (0 != bal && dec > 0) {
					ctr = ctr + dec;
					cost[i] = cost[i] + dec;
				} else if (0 != bal && dec == 00) {
					ctr = ctr + 1;
					cost[i] = cost[i] + 1;
				}
			}
		}

		if (ctr > 0) {
			System.out.println(ctr + 1);
		}

		else {
			System.out.println(0);
		}

	}
}
