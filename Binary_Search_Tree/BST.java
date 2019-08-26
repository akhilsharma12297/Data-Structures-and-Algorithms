package Binary_Search_Tree;

import java.util.*;

public class BST {

	private class Node {
		int data;
		Node right;
		Node left;
	}

	private Node root;
	@SuppressWarnings("unused")
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

	public void removenode(int data) {
		removenode(root, data);
	}

	private Node removenode(Node node, int data) {

		if (node == null) {
			return null;
		}

		if (data < node.data) {

			removenode(node.left, data);

		} else if (data > node.data) {

			removenode(node.right, data);

		} else {
			if (node.left != null && node.right == null) {
				return node.left;
			}

			if (node.left == null && node.right != null) {
				return node.right;
			}

			if (node.right == null & node.right == null) {
				return null;
			}

			if (node.left != null && node.right != null) {

				node.data = max(node.left);

				node.left = removenode(node.left, node.data);

				return node;
			}
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

	public void printleftView() {
		leftView(root, 0);
	}

	static int max_level = -1;

	private void leftView(Node node, int level) {
		if (node == null) {
			return;
		}
		if (level > max_level) {
			System.out.print(node.data + " ");
			max_level = level;
		}

		leftView(node.left, level + 1);
		leftView(node.right, level + 1);

	}

	public void printRightView() {
		rightview(root, 0);
	}

	static int max_level_R = -1;

	private void rightview(Node node, int level) {

		if (node == null) {
			return;
		}

		if (level > max_level_R) {
			System.out.print(node.data + " ");
			max_level_R = level;
		}

		rightview(node.right, level + 1);
		rightview(node.left, level + 1);

	}

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void printBottomView() {

		printBottomView(root, 0);

		System.out.println(map.values());
	}

	public void printBottomView(Node node, int hd) {

		if (node == null) {
			return;
		}

		map.put(hd, node.data);

		printBottomView(node.left, hd - 1);
		printBottomView(node.right, hd + 1);

	}

	static HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

	public void printTopView() {

		printTopView(root, 0);

		System.out.println(map2.values());
	}

	public void printTopView(Node node, int hd) {

		if (node == null) {
			return;
		}

		if (!map2.containsKey(hd)) {

			map2.put(hd, node.data);

		}

		printTopView(node.left, hd - 1);
		printTopView(node.right, hd + 1);

	}

	public boolean TargetPair(int k) {

		return TargetPair(root, k, new HashSet<Integer>());

	}

	private boolean TargetPair(Node node, int k, HashSet<Integer> set) {

		if (node == null) {
			return false;
		}

		if (set.contains(k - node.data)) {
			return true;
		}

		set.add(node.data);

		return TargetPair(node.left, k, set) || TargetPair(node.right, k, set);

	}

	static Node first, second, prev;

	public void FixBST() {

		FixBST(root);

		int temp = first.data;

		first.data = second.data;

		second.data = temp;

	}

	private void FixBST(Node node) {
		if (node == null) {
			return;
		}

		FixBST(node.left);

		if (first == null && (prev == null || prev.data >= node.data)) {
			first = prev;
		}

		if (first != null && prev.data >= node.data) {

			second = node;
		}

		prev = node;

		FixBST(node.right);
	}

	static Boolean trigger = false;

	public void inroderPredecessor(int data) {

		inroderPredecessor(root, data);

		if (trigger) {
			System.out.println(" No inorder Successor ");
		}

	}

	private void inroderPredecessor(Node node, int data) {

		if (node == null) {
			return;
		}

		inroderPredecessor(node.right, data);

		if (trigger) {
			System.out.println(node.data);
			trigger = false;
		}

		if (data == node.data) {
			trigger = true;

		}

		inroderPredecessor(node.left, data);

	}

	public void inroderSucessor(int data) {

		inroderSucessor(root, data);

		if (trigger) {
			System.out.println(" No inorder Successor ");
		}

	}

	private void inroderSucessor(Node node, int data) {

		if (node == null) {
			return;
		}

		inroderSucessor(node.left, data);

		if (trigger) {
			System.out.println(node.data);
			trigger = false;
		}

		if (data == node.data) {
			trigger = true;

		}

		inroderSucessor(node.right, data);

	}

	public void MergeTree(BST tree) {

		this.root = mergeTrees(this.root, tree.root);

	}

	private Node mergeTrees(Node t1, Node t2) {
		if (t1 == null && t2 == null) {
			return null;
		}

		if (t1 != null && t2 == null) {
			return t1;
		}

		if (t1 == null && t2 != null) {
			return t2;
		}

		t1.data += t2.data;

		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);

		return t1;
	}

	public void NextGreaterTree() {
		NextGreaterTree(root);
	}

	static int pastsum = 0;

	private void NextGreaterTree(Node node) {

		if (node == null) {
			return;
		}

		NextGreaterTree(node.right);

		NextGreaterTree(node.left);

		int temp = node.data;

		node.data = pastsum;

		pastsum += temp;

	}

	public int RangeSum(int l, int r) {
		return RangeSum(root, l, r);
	}

	private int RangeSum(Node node, int l, int r) {

		if (node == null) {
			return 0;
		}

		if (node.data > r) {
			return RangeSum(node.left, l, r);
		} else if (node.data < l) {
			return RangeSum(node.right, l, r);
		} else {
			int res = node.data;
			res += RangeSum(node.left, l, r);
			res += RangeSum(node.right, l, r);
			return res;
		}

	}

	public int Pca(int x, int y, int p) {

		Node node = new Node();

		Pca(root, x, y, p, node);

		if (node.left != null && node.right != null) {

			return node.right.data;
		}
		return -1;
	}

	private boolean Pca(Node node, int x, int y, int p, Node ans) {

		if (node == null) {
			return false;
		}

		if (node.data < x && node.data < y) {

			boolean left = Pca(node.left, x, y, p, ans);

			if (left && ans.data + 1 == p) {
				ans.right = node;
			}
			ans.data += 1;
			return left;

		} else if (node.data > x && node.data > y) {

			boolean right = Pca(node.right, x, y, p, ans);

			if (right && ans.data + 1 == p) {
				ans.right = node;
			}
			ans.data += 1;
			return right;
		} else {
			ans.left = node;
			ans.data = 1;
			if (ans.data == p) {
				ans.right = node;
			}
			return true;
		}

	}

	static int idx = 0;

	public void printLeafPreOrder(int[] arr) {
		printLeafPreOrder(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean printLeafPreOrder(int[] arr, int min, int max) {

		if (idx >= arr.length) {
			return false;
		}

		int val = arr[idx];
		if (min < val && val > max) {
			boolean left = printLeafPreOrder(arr, min, val);
			boolean right = printLeafPreOrder(arr, val, max);

			if ((!left) && (!right)) {
				System.out.print(val + " ");
				return true;
			}
		}
		return false;

	}

	public void printCommoninBST(Node node1, Node node2) {

		LinkedList<Node> stack1 = new LinkedList<>();
		getAllLeft(node1, stack1);

		LinkedList<Node> stack2 = new LinkedList<>();
		getAllLeft(node2, stack2);

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.getFirst().data == stack2.getFirst().data) {
				System.out.print(stack1.getFirst().data + " ");

				getAllLeft(stack1.removeFirst().right, stack1);
				getAllLeft(stack2.removeFirst().right, stack2);

			} else if (stack1.getFirst().data < stack2.getFirst().data) {
				getAllLeft(stack1.removeFirst().right, stack1);
			} else {
				getAllLeft(stack2.removeFirst().right, stack2);
			}

		}
	}

	public void getAllLeft(Node node, LinkedList<Node> stack) {
		while (node != null) {
			stack.addFirst(node);
			node = node.left;
		}
	}

	private class Res {
		int pre = -1;
		int suc = -1;
	}

	public void inorderPreSuc(int val) {
		Res r = new Res();
		inroderPreSuc(root, r, val);
	}

	private void inroderPreSuc(Node node, Res r, int val) {

		if (node == null) {
			return;
		}

		if (node.data == val) {

			if (node.left != null) {

				Node temp = node.left;
				while (temp.right != null) {
					node = node.right;
				}
				r.pre = node.data;

			}

			if (node.right != null) {

				Node temp = node.right;
				while (temp.left != null) {
					node = node.right;
				}
				r.suc = node.data;

			}

		}

		if (node.data > val) {
			r.suc = node.data;
			inroderPreSuc(node.left, r, val);

		} else {
			r.pre = node.data;
			inroderPreSuc(node.right, r, val);
		}

	}

	public boolean isPerfect(Node node) {

		int d = depth(node);
		return isperfect(node, d, 0);

	}

	public boolean isperfect(Node node, int maxDepth, int level) {
		if (node == null) {
			return true;
		}

		if (level + 1 > maxDepth) {
			return false;
		}

		if (node.left == null && node.right == null) {
			return ((level + 1) == maxDepth);
		}

		else if (node.left == null || node.right == null) {
			return false;
		}

		return (isperfect(node.left, maxDepth, level + 1) && isperfect(node.right, maxDepth, level + 1));
	}

	public int depth(Node node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;

	}

	public void sortedLLtoBST(Node head) {
		this.root = toBST(head, null);

		display(this.root);
	}

	private Node toBST(Node head, Node tail) {

		if (head == tail) {
			return null;
		}
		Node mid = MidNode(head, tail);

		Node node = mid;

		node.left = toBST(head, mid);

		node.right = toBST(mid.right, tail);

		return node;
	}

	private Node MidNode(Node node, Node tail) {

		Node slow = node;
		Node fast = node;

		while (fast != tail && fast.right != tail) {
			fast = fast.right.right;
			slow = slow.right;
		}
		return slow;
	}

}
