package Priority_Queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class merge_N_SortedArray {

	public static void main(String[] args) {

		int[][] arr = { { 1, 3, 5 }, { 2, 6, 8 }, { 0, 4, 10 } };

		merge(arr);
	}

	static class Node implements Comparable<Node> {

		int arr;
		int idx;
		int val;

		Node(int arr, int idx, int val) {
			this.arr = arr;
			this.idx = idx;
			this.val = val;
		}

		public int compareTo(Node o) {
			return this.val - o.val;
		}

	}

	public static void merge(int[][] arr) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			pq.add(new Node(i, 0, arr[i][0]));
		}

		ArrayList<Integer> result = new ArrayList<Integer>();

		while (!pq.isEmpty()) {

			Node temp = pq.poll();

			result.add(temp.val);

			int newIdx = temp.idx + 1;

			if (newIdx < arr.length) {
				pq.add(new Node(temp.arr, newIdx, arr[temp.arr][newIdx]));
			}
		}

		System.out.println(result);

	}

}
