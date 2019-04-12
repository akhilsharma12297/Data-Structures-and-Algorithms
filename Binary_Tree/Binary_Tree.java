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

		if (node == null) {
			ArrayList<Integer> bres = new ArrayList<>();
			return bres;
		}

		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
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

	/*
	 * public void KDown_self(int data, int k) { KDown_self(root, data, k, 0); }
	 * 
	 * private void KDown_self(Node node, int data, int k, int i) {
	 * 
	 * if (node == null) { return; }
	 * 
	 * if (i == k) { System.out.println(node.data); return; }
	 * 
	 * if (node.data == data) {
	 * 
	 * KDown_self(node.left, data, k, i + 1);
	 * 
	 * KDown_self(node.right, data, k, i + 1);
	 * 
	 * return; }
	 * 
	 * KDown_self(node.left, data, k, i); KDown_self(node.right, data, k, i);
	 * 
	 * }
	 */

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

		// System.out.println((char) path.get(k) + data);

	}

	public class bst {
		int max;
		int min;
		boolean bst;
	}

	public boolean isbst() {

		bst ans = isbst(root);

		return ans.bst;

	}

	private bst isbst(Node node) {

		if (node == null) {
			bst baseres = new bst();
			baseres.bst = true;
			baseres.min = Integer.MAX_VALUE;
			baseres.max = Integer.MIN_VALUE;
			return baseres;
		}

		bst myres = new bst();

		bst ls = isbst(node.left);

		if (ls.max > node.data || ls.bst == false) {
			myres.bst = false;
		}

		bst rs = isbst(node.right);

		if (rs.min < node.data || rs.bst == false) {
			myres.bst = false;
		}

		if (ls.max < node.data && rs.min > node.data) {
			myres.bst = true;
		} else {
			myres.bst = false;
		}

		myres.min = Math.min(Math.min(ls.min, rs.min), node.data);

		myres.max = Math.max(Math.max(ls.max, ls.max), node.data);

		return myres;

	}

	private void isbstLARGEST(Node node) {

	}

	static Node prev = null;

	public void BTtoDLL() {
		Node head = new Node();

		BTtoDLL(root, head);

		printDLL(head);
	}

	private void BTtoDLL(Node node, Node head) {
		if (node == null) {
			return;
		}

		BTtoDLL(node.left, node);

		if (prev == null) {

			head = node;

		} else {

			node.left = prev;
			prev.right = node;

		}

		prev = node;

		BTtoDLL(node.right, head);

	}

	private void printDLL(Node node) {

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	public void removeLeaves() {
		root = removeLeaves(root);
	}

	private Node removeLeaves(Node node) {

		if (node == null) {
			return null;
		}

		if (node.right == null && node.left == null) {
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

		if (node == null) {
			return;
		}

	}

	public void PathinRange(Node node, int low, int high, int str, int sum) {

		if (node == null) {

			if (sum > low && sum < high) {
				System.out.println(str + " ->  " + sum);
			}
			return;
		}

		PathinRange(node.left, low, high, str + node.data, sum + node.data);

		PathinRange(node.right, low, high, str + node.data, sum + node.data);
	}
}