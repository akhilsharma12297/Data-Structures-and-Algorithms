package Recursion;

import java.util.Collections;
import java.util.PriorityQueue;

public class K_closest_number {

	public static void main(String[] args) {

		int arr[] = { 10, 2, 14, 4, 7, 6 };
		int x = 5, k = 3;
		func(arr, k, x);
	}

	static class Node implements Comparable<Node> {
		int val;
		int idx;

		Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		public int compareTo(Node o) {
			if (this.val < o.val)
				return -1;
			else
				return 1;
		}
	}

	private static void func(int[] arr, int k, int x) {

		PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			pq.add(new Node(Math.abs(arr[i] - x), i));
		}

		for (int i = k; i < arr.length; i++) {

			int diff = Math.abs(arr[i] - x);

			if (diff < pq.peek().val) {
				pq.remove();

				pq.add(new Node(diff, i));
			}

		}

		while (!pq.isEmpty()) {
			System.out.print(arr[pq.remove().idx] + " ");
		}
	}
}
