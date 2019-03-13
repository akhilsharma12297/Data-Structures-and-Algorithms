package Priority_Queue;

import java.util.PriorityQueue;

public class K_Sorted {

	public static void main(String[] args) {
		int[] arr = { 30, 20, 10, 60, 50, 40, 87 };

		k_sorted(arr, 2);

	}

	public static void k_sorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i <= k) {
				pq.add(arr[i]);
			} else {
				System.out.print(pq.remove() + " ");
				pq.add(arr[i]);
			}

		}

		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
	}

}
