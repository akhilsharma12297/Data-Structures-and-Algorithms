package Graph;

import java.util.LinkedList;

// Fire house and rotten Orange is same question BFS of Graph approch

public class RottenOrange_FireHouse {
	static class Node {
		int i;
		int j;
		int timestamp;
	}

	static int rotten = 0;

	static int fresh = 0;

	public static void fun(int[][] arr) {

		LinkedList<Node> queue = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == 1) {

					fresh++;

				} else if (arr[i][j] == 2) {

					Node node = new Node();

					node.i = i;
					node.j = j;
					node.timestamp = 0;

					queue.addLast(node);

				}

			}
		}

		rotorange(arr, queue);

	}

	private static void rotorange(int[][] arr, LinkedList<Node> queue) {

		int ts = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();

			ts = temp.timestamp;

			int i = temp.i;
			int j = temp.j;

			if (isValid(i - 1, j, arr)) {

				if (arr[i - 1][j] == 1) {
					arr[i - 1][j] = 2;
					Node node = new Node();

					node.i = i - 1;
					node.j = j;
					node.timestamp = temp.timestamp + 1;

					rotten++;

					queue.addLast(node);

				}

			}

			if (isValid(i, j + 1, arr)) {
				if (arr[i][j + 1] == 1) {
					arr[i][j + 1] = 2;
					Node node = new Node();

					node.i = i;
					node.j = j + 1;
					node.timestamp = temp.timestamp + 1;

					rotten++;

					queue.addLast(node);

				}
			}

			if (isValid(i + 1, j, arr)) {
				if (arr[i + 1][j] == 1) {
					arr[i + 1][j] = 2;
					Node node = new Node();

					node.i = i + 1;
					node.j = j;
					node.timestamp = temp.timestamp + 1;

					rotten++;
					queue.addLast(node);

				}
			}

			if (isValid(i, j + 1, arr)) {
				if (arr[i][j + 1] == 1) {
					arr[i][j + 1] = 2;
					Node node = new Node();

					node.i = i;
					node.j = j + 1;
					node.timestamp = temp.timestamp + 1;

					rotten++;

					queue.addLast(node);

				}
			}
		}

		System.out.println(fresh + " " + rotten);
		System.out.println(ts);

	}

	private static boolean isValid(int i, int j, int[][] arr) {

		if (i > 0 && i < arr.length && j > 0 && j < arr[0].length)
			return true;

		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 0, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0, 1, 1 }, { 0, 2, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 1, 1, 0 }, { 0, 1, 0, 2, 1, 0, 0 }, { 2, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0 }, };

		int mat[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

		fun(arr);
	}
}
