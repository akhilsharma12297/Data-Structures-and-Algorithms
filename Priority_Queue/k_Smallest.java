package Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class k_Smallest {

	public static void main(String[] args) {

		int[] arr = { 10, 1, 23, 55, 45, 98, 62, 12, 35, 9 };

		printKSmallest(arr, 3);

	}

	public static void printKSmallest(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {

			pq.add(arr[i]);

		}

		for (int j = k; k < arr.length; j++) {

			if (arr[k] < pq.peek()) {
				pq.remove();

				pq.add(arr[k]);
			}

		}

		for (int i = 0; i < k; i++) {

			System.out.println(pq.remove());

		}

	}

}
