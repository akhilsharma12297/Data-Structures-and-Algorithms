package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree {

	private class Node {
		int data;
		Node right;
		Node left;
	}

	private Node root;
	private int size = 0;

	public Binary_Tree(int[] arr) {

		Stack<Node> stack = new Stack<>();

		for (int val : arr)
			if (val == -1) {

				stack.pop();

			} else {
				Node node = new Node();

				node.data = val;

				size++;

				if (stack.size() == 0) {

					root = node;

				}
				if (stack.size() > 0) {
					if (stack.peek().left == null) {

						stack.peek().left = node;

					} else {

						stack.peek().right = node;

					}
				}

				stack.push(node);
			}

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

		str += "<- " + node.data + " -> ";

		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int lsize = size(node.left);

		int rsize = size(node.right);
		return lsize + rsize + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int l = max(node.left);
		int r = max(node.right);

		return Math.max(node.data, Math.max(l, r));

	}

	public int height() {
		return height(root);

	}

	private int height(Node node) {

		if (node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);

		int h = 1 + Math.max(lh, rh);

		return h;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {

		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean foundL = find(node.left, data);

		if (foundL) {
			return true;
		}
		boolean foundR = find(node.right, data);
		boolean found = foundL || foundR;

		return found;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {

		return nodeToRootPath(root, data);

	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {

		ArrayList<Integer> list = new ArrayList<>();

		if (node == null) {
			ArrayList<Integer> bres = new ArrayList<>();
			return bres;
		}

		if (node.data == data) {
			list.add(node.data);
			return list;
		}

		ArrayList<Integer> res = nodeToRootPath(node.left, data);

		if (res.size() > 0) {
			res.add(node.data);
			return res;
		}

		res = nodeToRootPath(node.right, data);

		if (res.size() > 0) {
			res.add(node.data);
			return res;
		}

		return res;

	}

	public int lca(int i, int j) {

		return lca(root, i, j);

	}

	public int lca(Node node, int i, int j) {

		ArrayList<Integer> p1 = nodeToRootPath(i);

		ArrayList<Integer> p2 = nodeToRootPath(j);

		int a = p1.size() - 1;

		int b = p2.size() - 1;

		while (a > 0 && b > 0) {

			if (p1.get(a) != p2.get(b)) {

				return p1.get(a + 1);

			}

			a--;
			b--;

		}

		return 0;

	}

	public Node findNode(int data) {
		return findNode(root, data);
	}

	private Node findNode(Node node, int data) {

		if (node == null) {
			return null;
		}

		if (node.data == data) {
			return node;
		}

		Node foundL = findNode(node.left, data);

		if (foundL != null) {
			return foundL;
		}
		Node foundR = findNode(node.right, data);

		if (foundR != null) {
			return foundR;
		}
		return null;

	}

	public void KDown(int data, int k) {

		Node node = findNode(root, data);

		KDown(node, k, 0);
	}

	private void KDown(Node node, int k, int i) {

		if (node == null) {
			return;
		}

		if (i == k) {
			System.out.println(node.data);
			return;
		}

		KDown(node.left, k, i + 1);
		KDown(node.right, k, i + 1);

	}

	private ArrayList<Node> nodeToRootPath_Node(Node node, int data) {

		ArrayList<Node> list = new ArrayList<>();

		if (node == null) {
			ArrayList<Node> bres = new ArrayList<>();
			return bres;
		}

		if (node.data == data) {
			list.add(node);
			return list;
		}

		ArrayList<Node> res = nodeToRootPath_Node(node.left, data);

		if (res.size() > 0) {
			res.add(node);
			return res;
		}

		res = nodeToRootPath_Node(node.right, data);

		if (res.size() > 0) {
			res.add(node);
			return res;
		}

		return res;

	}

	public void printKFar(int data, int k) {

		ArrayList<Node> path = nodeToRootPath_Node(root, data);

		KDown(path.get(0), k, 0);

		for (int i = 1; i <= k - 1; i++) {

			Node imnode = path.get(i - 1);

			Node inode = path.get(i);

			if (inode.left == imnode) {
				KDown(inode.right, k - i - 1, 0);

			} else {
				KDown(inode.left, k - i - 1, 0);
			}

		}

	}

	Node head = new Node();

	static Node prev = null;

	public void BTtoDLL() {

		BTtoDLL(root);

		System.out.println(head.data);

		printDLL(head);
	}

	private void BTtoDLL(Node node) {

		if (node == null) {
			return;
		}

		BTtoDLL(node.left);

		if (prev == null) {
			head = node;
		} else {
			prev.right = node;
			root.left = prev;
		}
		prev = node;

		BTtoDLL(node.right);

	}

	private void printDLL(Node node) {

		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.right;
		}

		System.out.println();

	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private Node removeLeaves(Node node) {

		if (node.left == null && node.right == null) {

			return null;
		}

		node.left = removeLeaves(node.left);
		node.right = removeLeaves(node.right);

		return node;

	}

	public void printSinglechild() {
		printSinglechild(root);
	}

	private void printSinglechild(Node node) {

		if (node.left == null && node.right != null) {

			System.out.println(node.data);
			return;

		}

		if (node.right == null && node.left != null) {

			System.out.println(node.data);
			return;
		}

		printSinglechild(node.left);

		printSinglechild(node.right);

	}

	static int sum = 0;

	public void printInRange(int lo, int hi) {

		printInRange(root, lo, 1000, 0, "");

	}

	private void printInRange(Node node, int lo, int hi, int sum, String str) {

		if (node == null) {

			if (sum >= lo && sum <= hi) {

				System.out.println("bye");
				System.out.println(str);

			}
			return;
		}

		if (sum >= lo && sum <= hi) {

			System.out.println("HELLO");
			System.out.println(str);

		}

		sum += node.data;

		printInRange(node.left, lo, hi, sum, str + " " + node.data);

		printInRange(node.right, lo, hi, sum, str + " " + node.data);

		sum -= node.data;
	}
}