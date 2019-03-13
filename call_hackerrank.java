
import java.util.*;

public class call_hackerrank {

	static Scanner scn = new Scanner(System.in);

	static ArrayList<Integer> master = new ArrayList<Integer>();

	static ArrayList<Integer> answers = new ArrayList<Integer>();

	public static void main(String[] args) {

		int n = scn.nextInt();

		int m = scn.nextInt();

		int k = scn.nextInt();

		for (int i = 0; i < m; i++) {

			int arr[] = inputer(m, n);

			func(arr, k - 1);

		}
		printer();

	}

	public static int[] inputer(int m, int n) {

		int arr[] = new int[m];

		for (int i = 0; i < (n / m); i++) {

			arr[i] = scn.nextInt();

		}

		return arr;

	}

	public static void func(int arr[], int k) {

		int a = arr[k];

		boolean cond = true;

		for (int i = 0; i < master.size(); i++) {
			if (a == master.get(i)) {
				cond = false;
			}

		}

		if (cond == true) {

			answers.add(a);

		}

	}

	public static void printer() {

		int a = answers.size();

		System.out.println(a - 1);

		for (int i = 1; i < a; i++) {
			System.out.print(answers.get(i));

			System.out.print(" ");

		}

	}
}
