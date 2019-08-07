package Matrix;

import java.util.PriorityQueue;

public class KthSmallest_element {
	public static void main(String[] args) {
		int[][] arr = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		func(arr, 8);

	}

	static class Node implements Comparable<Node> {
		int array;
		int idx;
		int val;

		Node(int x, int y, int val) {
			this.array = x;
			this.idx = y;
			this.val = val;
		}

		public int compareTo(Node o) {
			return this.val - o.val;
		}
	}

	public static void func(int[][] arr, int k) {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(new Node(i, 0, arr[i][0]));
		}

		for (int i = 1; i < k; i++) {
			Node temp = pq.poll();

			int idx = temp.idx + 1;

			if (idx < arr[temp.array].length) {
				pq.add(new Node(temp.array, idx, arr[temp.array][idx]));
			}

		}

		Node ans = pq.poll();
		System.out.println(ans.val);

	}

}
