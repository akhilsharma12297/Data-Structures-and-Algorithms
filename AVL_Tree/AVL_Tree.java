package AVL_Tree;

public class AVL_Tree {

	private class Node {
		int data;
		Node left;
		Node right;
		int ht;
		int bal;
	}

	Node root;

	public AVL_Tree(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;
		Node node = new Node();
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		this.sethnb(node);

		return node;
	}

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			Node bn = new Node();
			bn.data = data;
			this.sethnb(bn);
			return bn;
		}

		if (data > node.data) {
			node.right = add(node.right, data);
		} else if (data < node.data) {
			node.left = add(node.left, data);
		} else {

		}

		this.sethnb(node);

		if (node.bal > 1 && data < node.left.data) { // ll
			node = rightrotation(node);
		} else if (node.bal > 1 && data > node.left.data) { // lr
			node.left = leftrotation(node.left);
			node = rightrotation(node);
		} else if (node.bal < -1 && data > node.right.data) { // rr
			node = leftrotation(node);
		} else if (node.bal < -1 && data < node.right.data) { // rl
			node.right = rightrotation(node.right);
			node = leftrotation(node);
		}

		return node;
	}

	private Node rightrotation(Node z) {
		Node y = z.left;
		Node t = y.right;
		y.right = z;
		z.left = t;

		this.sethnb(z);
		this.sethnb(y);

		return y;
	}

	private Node leftrotation(Node z) {
		Node y = z.right;
		Node t = y.left;
		z.right = t;
		y.left = z;

		this.sethnb(z);
		this.sethnb(y);

		return y;
	}

	public void remove(int data) {
		root = remove(root, data);
	}

	private Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (data > node.data) {
			node.right = remove(node.right, data);
		} else if (data < node.data) {
			node.left = remove(node.left, data);
		} else { // data matches
			if (node.left != null && node.right != null) {
				int lmax = max(node.left);
				node.data = lmax;
				node.left = remove(node.left, lmax);
			} else {
				return node.left == null ? node.right : node.left;
			}
		}

		this.sethnb(node);

		if (node.bal > 1 && node.left.bal >= 0) { // ll
			node = rightrotation(node);
		} else if (node.bal > 1 && node.left.bal < 0) { // lr
			node.left = leftrotation(node.left);
			node = rightrotation(node);
		} else if (node.bal < -1 && node.right.bal < 0) { // rr
			node = leftrotation(node);
		} else if (node.bal < -1 && node.right.bal >= 0) { // rl
			node.right = rightrotation(node.right);
			node = leftrotation(node);
		}

		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = " <- " + node.data + "[" + node.ht + "," + node.bal + "] -> ";
		String lstr = node.left == null ? "." : node.left.data + "";
		String rstr = node.right == null ? "." : node.right.data + "";

		System.out.println(lstr + str + rstr);
		display(node.left);
		display(node.right);
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}

	private void sethnb(Node node) {
		int lh = node.left == null ? 0 : node.left.ht;
		int rh = node.right == null ? 0 : node.right.ht;
		node.ht = Math.max(lh, rh) + 1;
		node.bal = lh - rh;
	}

}
