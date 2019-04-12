package Binary_Search_Tree;

import java.util.*;
import Queue.Queue;

public class BST {

	private class Node {
		int data;
		Node right;
		Node left;
	}

	private Node root;
	private int size = 0;

	public BST(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo > hi) {

			return null;
		}

		int mid = (lo + hi) / 2;

		Node node = new Node();

		node.data = arr[mid];

		size++;

		node.left = construct(arr, lo, mid - 1);

		node.right = construct(arr, mid + 1, hi);

		return node;

	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = new String();

		str += node.left != null ? node.left.data : ".";

		str += " <- " + node.data + " -> ";

		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int min() {

		return min(root);
	}

	private int min(Node node) {

		if (node.left == null) {
			return node.data;
		}

		return min(node.left);

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);

	}

	public boolean find(int val) {
		return find(root, val);
	}

	private boolean find(Node node, int val) {

		if (node == null) {
			return false;
		}

		if (node.data == val) {
			return true;
		}
		if (node.data > val) {
			boolean find = find(node.left, val);
			if (find) {
				return true;
			}
		}

		else {
			boolean find = find(node.right, val);
			if (find) {
				return true;
			}

		}
		return false;

	}

	public void add(int val) {

		root = add(root, val);
	}

	private Node add(Node node, int val) {

		if (node == null) {
			Node base = new Node();
			base.data = val;

			return base;
		}

		if (val < node.data) {
			node.left = add(node.left, val);
		} else {
			node.right = add(node.right, val);
		}
		return node;
	}

	public void removeleave(int val) {

		root = remove(root, val);

	}

	private Node remove(Node node, int val) {

		if (node == null) {
			return null;
		}

		if (node.data == val) {

			if (node.left == null && node.right == null) {

				return null;

			} else if (node.left == null) {

				return node.right;

			} else if (node.right == null) {

				return node.left;

			} else {
				int lmax = max(node.left);
				node.data = lmax;
				node.left = remove(node.left, lmax);
				return node;
			}

		}

		if (val > node.data) {
			node.right = remove(node.right, val);
		} else {
			node.left = remove(node.left, val);
		}

		return node;

	}

	public void printInRange(int lo, int hi) {

		printInRange(root, lo, hi);

	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (lo <= node.data || node.data <= hi) {
			System.out.println(node.data);
		}

		if (lo <= node.data) {
			printInRange(node.left, lo, hi);
		}

		if (hi >= node.data) {
			printInRange(node.right, lo, hi);

		}

	}

	public void replacewithsumoflarger() {
		replacewithsumoflarger(root);
	}

	static int sum = 0;

	private void replacewithsumoflarger(Node node) {

		if (node == null) {
			return;
		}

		replacewithsumoflarger(node.right);

		sum += node.data;

		int temp = node.data;
		node.data = sum;
		node.data = node.data - temp;

		replacewithsumoflarger(node.left);

	}

	public void levelorder() {
		levelorder(root);
	}

	private void levelorder(Node node) {
		LinkedList<Node> queue = new LinkedList<>();

		queue.add(node);

		while (queue.size() > 0) {

			Node temp = queue.removeFirst();

			System.out.print(temp.data + "  ");

			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}

		}

	}

	public void levelorder_lineWise_NULL() {

		levelorder_lineWise_NULL(root);

	}

	private void levelorder_lineWise_NULL(Node node) {

		LinkedList<Node> queue = new LinkedList<>();

		queue.add(node);
		queue.add(null);

		while (queue.size() > 0) {
			Node temp = queue.removeFirst();

			if (temp != null) {

				System.out.print(temp.data + "  ");
				if (temp.left != null) {
					queue.addLast(temp.left);
				}

				if (temp.right != null) {
					queue.addLast(temp.right);
				}

			} else {
				if (queue.size() == 0) {
					return;
				}
				System.out.println();
				queue.addLast(null);
			}

		}

	}

	public void levelorder_linewise_TWO_QUEUE() {

		levelorder_linewise_TWO_QUEUE(root);

	}

	public void levelorder_linewise_TWO_QUEUE(Node node) {
		LinkedList<Node> que1 = new LinkedList<Node>();
		LinkedList<Node> que2 = new LinkedList<Node>();

		que1.addLast(root);
		while (!que1.isEmpty()) {
			Node node1 = que1.removeFirst();
			System.out.print(node1.data + " ");

			if (node1.left != null) {
				que2.addLast(node1.left);
			}
			if (node1.right != null) {
				que2.addLast(node1.right);
			}

			if (que1.isEmpty()) {
				LinkedList<Node> temp = que1;
				que1 = que2;
				que2 = temp;
				System.out.println();
			}
		}
	}

	public void printRightView() {

		printRightView(root);

	}

	private void printRightView(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int n = queue.size();

			for (int i = 1; i <= n; i++) {
				Node temp = queue.removeFirst();

				if (i == n)
					System.out.print(temp.data + " ");

				if (temp.left != null)
					queue.add(temp.left);

				if (temp.right != null)
					queue.add(temp.right);
			}
		}
	}

	private static class Pair {
		private int depth = -1;
	}

	Pair pair = new Pair();

	public void printleftView() {
		leftView(root, 0, pair);
	}

	private void leftView(Node node, int level, Pair pair) {
		if (node == null) {
			return;
		}
		if (level > pair.depth) {
			System.out.print(node.data + " ");
			pair.depth++;
		}

		leftView(node.left, level + 1, pair);
		leftView(node.right, level + 1, pair);

	}

	public void FindPair(int tar) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		boolean found = false;

		FindPair(root, list);

		Collections.sort(list);

		int start = 0;
		int end = list.size() - 1;
		while (start < end) {

			if (list.get(start) + list.get(end) == tar) {

				System.out.println(list.get(start) + " + " + list.get(end) + " = " + tar);

				start++;
				end--;

				found = true;

			}

			if (list.get(start) + list.get(end) > tar) {

				end--;

			}

			if (list.get(start) + list.get(end) < tar) {

				start++;

			}

		}

		if (!found) {
			System.out.println("NOT FOUND !");
		}
	}

	private void FindPair(Node node, ArrayList<Integer> list) {

		if (node == null) {
			return;
		}

		list.add(node.data);

		FindPair(node.left, list);

		FindPair(node.right, list);

	}
}
