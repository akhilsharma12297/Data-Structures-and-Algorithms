package Recursion;

import java.util.LinkedList;

public class Nth_number_from_2_3_5_7 {

	public static void main(String[] args) {

		func(20);

	}

	private static void func(int n) {
		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(2);
		queue.add(3);
		queue.add(5);
		queue.add(7);

		int ctr = 0;

		while (true) {

			int temp = queue.removeFirst();

			ctr++;

			if (ctr == n) {
				System.out.println(temp);
				break;
			}

			temp = temp * 10;
			queue.add(temp + 2);
			queue.add(temp + 3);
			queue.add(temp + 5);
			queue.add(temp + 7);
		}

	}

}
