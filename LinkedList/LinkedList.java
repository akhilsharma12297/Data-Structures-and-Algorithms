package LinkedList;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void addLast(int data) {

		if (size == 0) {
			handlewhensize0(data);
			return;
		}

		Node node = new Node();

		node.data = data;

		tail.next = node;

		tail = node;

		size++;

	}

	public void addFirst(int data) {

		if (size == 0) {
			handlewhensize0(data);
			return;
		}

		Node node = new Node();

		node.data = data;

		node.next = head;

		head = node;

		size++;

	}

	public void addat(int val, int idx) {

		if (size == 0) {
			System.out.println("List Empty");
		}

		if (idx < 0 || idx > size) {

			System.out.println("Index Out of bound");

		} else if (idx == 0) {
			addFirst(val);
			return;
		} else if (idx == size) {
			addLast(val);
			return;
		}

		Node node = new Node();

		node = head;

		for (int i = 0; i < idx - 1; i++) {

			node = node.next;

		}

		Node mynode = new Node();

		mynode.data = val;

		Node nodenext = node.next;

		node.next = mynode;

		mynode.next = nodenext;

		size++;
	}

	private void handlewhensize0(int data) {

		Node node = new Node();

		node.data = data;

		head = tail = node;

		size++;
	}

	public int getFirst() {

		if (size == 0) {
			System.out.println("EMPTY LIST");
		}

		return head.data;
	}

	public int getLast() {
		if (size == 0) {
			System.out.println("EMPTY LIST");
		}

		return tail.data;
	}

	public Node getNodeAt(int idx) {

		if (size == 0) {

			System.out.println("LIST EMPTY");
		}

		if (idx < 0 || idx > size) {

			System.out.println("OUT Of Bound");

		}

		Node node = new Node();

		node = head;

		for (int i = 0; i < idx; i++) {

			node = node.next;

		}

		return node;

	}

	public int removeFirst() {

		if (size == 0) {

			System.out.println("LIST IS EMPTY");

		}

		if (size == 1) {

			handleremovewhensizeis1();

		}

		int data = head.data;

		head = head.next;

		size--;

		return data;

	}

	private int handleremovewhensizeis1() {

		int data = head.data;

		head = tail = null;

		return data;

	}

	public int removelast() {

		if (size == 0) {
			System.out.println("LIST OS EMPTY");
		}

		if (size == 1) {
			handleremovewhensizeis1();
		}

		Node node = head;

		for (int i = 0; i < size - 2; i++) {
			node = node.next;

		}

		int data = node.next.data;

		node.next = null;

		tail = node;

		size--;

		return data;
	}

	public int remove(int idx) {

		if (size == 0) {
			System.out.println("LIST IS EMPTY");
		}

		if (size == 1) {
			handleremovewhensizeis1();
		}

		if (idx == size) {
			removelast();
		}

		Node jpre = head;

		for (int i = 1; i < idx - 1; i++) {

			jpre = jpre.next;
		}

		Node curr = jpre.next;

		Node jnext = curr.next;

		jpre.next = curr.next;

		size--;

		return curr.data;
	}

	public void display() {

		Node node = head;

		for (int i = 0; i < size; i++) {

			System.out.print(node.data + " - > ");
			node = node.next;
		}
	}

	public void reversePrint() {
		if (size == 0) {
			System.out.println("List is empty");
		}

		for (int i = size; i >= 0; i--) {
			Node node = getNodeAt(i);

			System.out.print(node.data + " - > ");

		}

	}

	public void reversePrint_RC() {

		reversePrint_RC(head);
	}

	private void reversePrint_RC(Node node) {

		if (node == null) {

			return;

		}
		reversePrint_RC(node.next);

		System.out.print(node.data + " - > ");

	}

	public void reverseData() {

		int left = 0;
		int right = size - 1;

		while (left < right) {
			Node leftnode = getNodeAt(left);

			Node rightnode = getNodeAt(right);

			int temp = leftnode.data;

			leftnode.data = rightnode.data;

			rightnode.data = temp;

			left++;
			right--;

		}

	}

	public void reverseData_RC() {

		HeapMover left = new HeapMover();
		left.node = head;
		reverseData_RC(head, left, 0);
	}

	class HeapMover {
		Node node;
	}

	public void reverseData_RC(Node right, HeapMover left, int floor) {

		if (right == null) {
			return;
		}

		reverseData_RC(right.next, left, floor + 1);

		if (floor > size / 2) {

			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}

	}

	Node temp;

	public void reverseData_RC_Global_Node() {

		temp = head;
		reverseData_RC_Global_Node(head, temp, 0);
	}

	public void reverseData_RC_Global_Node(Node right, Node temp, int floor) {

		if (right == null) {
			return;
		}

		reverseData_RC_Global_Node(right.next, temp, floor + 1);

		if (floor > size / 2) {

			int left = temp.data;
			temp.data = right.data;
			right.data = left;

			temp = temp.next;
		}

	}

	public void reversePointer() {

		Node prev = head;

		Node curr = head.next;

		while (curr != null) {

			Node next = curr.next;
			curr.next = prev;
			prev = curr;

			curr = next;

		}

		Node temp = head;

		head = tail;
		tail = temp;

		tail.next = null;

	}

	public void reversePointer_RC() {
		Node prev = head;
		Node curr = head.next;

		reversePointer_RC(prev, curr);

		Node temp = head;

		head = tail;
		tail = temp;

		tail.next = null;
	}

	public void reversePointer_RC(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		Node next = curr.next;

		curr.next = prev;

		prev = curr;

		curr = next;

		reversePointer_RC(prev, curr);

	}

	public void reversePointer_RC_BETTER() {

		reversePointer_RC_BETTER(head);

		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;
	}

	public void reversePointer_RC_BETTER(Node node) {

		if (node == tail) {
			return;
		}

		reversePointer_RC_BETTER(node.next);

		node.next.next = node;

	}

	public boolean isPalindrome() {

		HeapMover left = new HeapMover();

		left.node = head;

		return isPalindrome(left, head, 0);

	}

	private boolean isPalindrome(HeapMover left, Node right, int ctr) {

		if (right == null) {
			return true;
		}

		boolean ans = isPalindrome(left, right.next, ctr + 1);

		if (ctr >= size / 2) {

			if (left.node.data != right.data) {
				return false;
			}
			left.node = left.node.next;

		}

		return ans;

	}

	static Node left = null;

	public boolean isPalindrome_Global() {

		left = head;

		return isPalindrome_Global(head, left, 0);
	}

	private boolean isPalindrome_Global(Node right, Node left, int ctr) {

		if (right == null) {
			return true;
		}

		boolean ans = isPalindrome_Global(right.next, left, ctr + 1);

		if (ctr >= size / 2) {

			if (left.data != right.data) {
				return false;
			}

			left = left.next;

		}
		return ans;
	}

	public void foldList() {

		HeapMover left = new HeapMover();

		left.node = head;

		foldList(head, left, 0);

		tail = left.node.next;
		tail.next = null;

	}

	private void foldList(Node right, HeapMover left, int ctr) {
		if (right == null) {

			return;

		}
		foldList(right.next, left, ctr + 1);

		if (ctr >= size / 2) {

			Node temp = left.node.next;

			left.node.next = right;

			right.next = temp;

			left.node = temp;

		}

	}

	public void unfoldList() {

		unfoldList(head, head.next);

	}

	private void unfoldList(Node curr, Node Next) {

		if (curr.next == null) {

			head = curr;
			tail = curr;

			return;

		}

		unfoldList(curr.next.next, Next.next.next);

		curr.next = head;

		tail.next = Next;

		head = curr;

		tail = Next;

	}

	public void removeduplicate() {

		Node curr = head;

		Node next = head.next;

		while (true) {

			if (next == null) {
				curr.next = null;
				tail = curr;
				break;
			}

			if (curr.data == next.data) {
				next = next.next;
			} else {
				size++;

				curr.next = next;
				curr = next;

				next = next.next;
			}

		}

	}

	public int mid() {
		Node slow = head;

		Node fast = head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;

			fast = fast.next.next;

		}

		return slow.data;

	}

	public int kthfromlast(int k) {

		Node slow = head;

		Node fast = head;

		for (int i = 0; i < k; i++) {

			fast = fast.next;

		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public static LinkedList MergeList(LinkedList l1, LinkedList l2) {
		LinkedList list = new LinkedList();

		Node temp1 = l1.head;
		Node temp2 = l2.head;

		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				list.addLast(temp1.data);
				temp1 = temp1.next;
			} else {
				list.addLast(temp2.data);
				temp2 = temp2.next;
			}
		}

		while (temp1 != null) {
			list.addLast(temp1.data);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			list.addLast(temp2.data);
			temp2 = temp2.next;
		}

		return list;
	}

	public Node midNode() {
		Node slow = head;

		Node fast = head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;

			fast = fast.next.next;

		}

		return slow;

	}

	public static LinkedList Merge(LinkedList list) {

		if (list.size == 1) {
			return list;
		}

		Node middle = list.midNode();

		LinkedList l1 = new LinkedList();

		l1.head = list.head;

		l1.tail = list.midNode();

		l1.size = (list.size + 1) / 2;

		LinkedList l2 = new LinkedList();

		l2.head = list.midNode().next;

		l2.tail = list.tail;

		l2.size = list.size - l1.size;

		l1.tail.next = null;

		l1 = Merge(l1);

		l2 = Merge(l2);

		LinkedList l3 = MergeList(l1, l2);

		l1.tail.next = middle;

		return l3;

	}

	public void kreverse(int k) {

		LinkedList curr = new LinkedList();

		LinkedList prev = new LinkedList();

		while (this.size != 0) {
			for (int i = 0; i < k; i++) {
				curr.addfirstnode(this.removeFirstNode());
			}

			if (prev.size == 0) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size = curr.size;

			}

			curr = new LinkedList();
		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	private Node removeFirstNode() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		}

		if (size == 1) {
			return handleremovalofnodewhensize1();
		}

		Node rv = head;

		head = head.next;

		rv.next = null;
		size--;

		return rv;

	}

	private Node handleremovalofnodewhensize1() {

		Node rv = head;
		head = tail = null;

		size = 0;
		return rv;

	}

	public void addfirstnode(Node node) {

		if (size == 0) {
			handleaddnodewhensize0(node);
			return;
		}

		node.next = head;
		head = node;

		size++;
	}

	private void handleaddnodewhensize0(Node node) {
		head = tail = node;

		size++;

	}

	public void addnodeLast(Node node) {

		if (size == 0) {
			handleaddnodewhensize0(node);
			return;
		}

		tail.next = node;

		tail = node;

		size++;

	}

	public void oddeven() {

		LinkedList odd = new LinkedList();

		LinkedList even = new LinkedList();

		while (size != 0) {
			if (this.head.data % 2 == 0) {
				even.addfirstnode(this.removeFirstNode());

			} else {
				odd.addfirstnode(this.removeFirstNode());
			}

		}

		if (even.size == 0) {

			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
			this.tail.next = null;

		} else if (odd.size == 0) {

			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
			this.tail.next = null;

		} else {
			this.head = odd.head;
			odd.tail.next = even.head;
			this.tail = even.tail;
			this.tail.next = null;
			this.size = odd.size + even.size;

		}

	}

}
