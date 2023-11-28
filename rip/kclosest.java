package rip;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kclosest {

    static class Node implements Comparable<Node> {
        int val;
        int diff;

        Node(int val, int diff) {
            this.val = val;
            this.diff = diff;
        }

        @Override
        public int compareTo(Node o) {
            if (this.val < o.val)
                return -1;
            else
                return 1;
        }

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Node(arr[i], Math.abs(x - arr[i])));
        }

        List<Integer> result = new ArrayList<>();

        for (int i = k; k < arr.length; i++) {

            int diff = Math.abs(arr[i] - x);
            if (diff < pq.peek().diff) {
                pq.remove();
                pq.add(new Node(diff, arr[i]));
            }
        }

        int ctr = k;

        while (ctr-- > 0) {
            result.add(pq.poll().val);
        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }


}
