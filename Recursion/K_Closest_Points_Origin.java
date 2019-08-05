package Recursion;

import java.util.PriorityQueue;

public class K_Closest_Points_Origin {

	public static void main(String[] args) {

		int arr[][] = { { 2, 3 }, { 12, 30 }, { 40, 50 }, { 5, 1 }, { 12, 10 }, { 3, 4 } };
		int k = 2;

		func(arr, k);

	}

	private static class pair implements Comparable<pair> {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;

		}

		@Override
		public int compareTo(pair o) {
			return ((o.x) * (o.x) + (o.y) * (o.y)) - ((this.x * this.x) + (this.y * this.y));
		}
	}

	private static void func(int[][] points, int k) {

		PriorityQueue<pair> pq = new PriorityQueue<>();

		for (int i = 0; i < points.length; i++) {
			pq.add(new pair(points[i][0], points[i][1]));

			if (pq.size() > k) {
				pq.remove();
			}
		}

		int[][] ans = new int[k][2];

		for (int i = 0; i < k; i++) {

			pair temp = pq.remove();

			System.out.print(temp.x + " , " + temp.y);
			System.out.println();
		}
	}

}
