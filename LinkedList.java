public class LinkedList {

	class Node {

		Node next;
		int data;

	}

	Node head;
	Node tail;
	int size;

	public void addLast(int val) {

		if (size == 0) {
			handleaddsize0(val);

			return;
		}

		Node node = new Node();

		node.data = val;
		tail.next = node;
		tail = node;
		size++;

	}

	private void handleaddsize0(int val) {

		Node node = new Node();

		node.data = val;
		head = tail = node;
		size++;
	}

	public void addFirst(int val) {
		if (size == 0) {
			handleaddsize0(val);
			return;

		}

		Node node = new Node();

		node.data = val;

		node.next = head;

		head = node;
		size++;

	}

	public void addAt(int idx, int data) {

		if (size == 0) {
			handleaddsize0(data);
			return;
		}
		if (idx == 0) {
			handleaddsize0(data);
			return;
		}

		if (idx == size - 1) {
			addLast(data);
			return;
		}

		if (idx > size || idx < 0) {
			System.out.println("Out of Bound");
			return;
		}

		Node temp = head;
		for (int i = 0; i < idx - 1; i++) {

			temp = temp.next;

		}

		Node tempnext = temp.next;

		Node mynode = new Node();

		mynode.data = data;

		temp.next = mynode;

		mynode.next = temp.next;

		size++;

	}

	public int removeLast() {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}

		if (size == 1) {

			int data = handelremovesize1();

			return data;
		}

		Node temp = head;

		for (int i = 0; i < size - 2; i++) {

			temp = temp.next;

		}

		int data = temp.next.data;
		temp.next = null;
		tail = temp;
		size--;

		return data;

	}

	private int handelremovesize1() {
		int data = head.data;

		head = tail = null;

		size--;

		return data;

	}

	public int removeFirst() {

		if (size == 0) {
			System.out.println("List is Empty");

			return -1;
		}

		if (size == 1) {
			return handelremovesize1();
		}

		Node temp = head;

		Node mynode = temp.next;

		head = mynode;
		size--;

		return temp.data;

	}

	public int removeAt(int idx) {

		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}

		if (idx == 1) {
			return handelremovesize1();
		}

		if (idx == size - 1) {

			return removeLast();
		}

		if (idx > size || idx < 0) {
			System.out.println("Out of Bound");
			return -1;
		}

		Node temp = head;
		for (int i = 0; i < idx - 1; i++) {

			temp = temp.next;

		}

		Node tempnext = temp.next;

		int data = tempnext.data;

		temp.next = tempnext;

		size--;

		return data;

	}

	public int getFirst() {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}

		return head.data;
	}

	public int getLast() {

		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}

		Node temp = head;

		for (int i = 0; i < size - 1; i++) {

			temp = temp.next;

		}

		return temp.data;

	}

	public int getAt(int idx) {

		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		}

		if (idx > size) {
			System.out.println("Out of Bound");
			return -1;
		}

		Node temp = head;

		for (int i = 0; i < idx; i++) {

			temp = temp.next;

		}

		return temp.data;

	}

	public void display() {

		if (size == 0) {
			System.out.println("List is empty");
			return;
		}

		for (Node node = head; node != null; node = node.next) {

			System.out.print(node.data + " - > ");

		}

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

	public void reverseData_itr() {

		if (size == 0) {
			System.out.println("List is empty");
			return;
		}

		int left = 0;

		int right = size - 1;

		while (left < right) {

			Node leftnode = getNodeAt(left);

			Node rightnode = getNodeAt(right);

			int temp = 0;

			temp = leftnode.data;

			leftnode.data = rightnode.data;

			rightnode.data = temp;

			left++;
			right--;

		}

	}

	/*
	 * public void reverseData_rc() { reverseData_rc(head); }
	 * 
	 * private void reverseData_rc(Node node) {
	 * 
	 * }
	 */
	public void reversePointer_itr() {

		Node prev = head;

		Node curr = head.next;

		while (curr != null) {
			Node temp = curr.next;

			curr.next = prev;

			prev = curr;

			curr = temp;

		}

		Node temp = head;

		head = tail;
		tail = temp;

		tail.next = null;

	}

	public void reversePointer_Rc() {
		reversePointer_Rc(head);

		Node temp = head;

		head = tail;
		tail = temp;

		tail.next = null;

	}

	private void reversePointer_Rc(Node node) {

		if (node == tail) {
			return;
		}

		reversePointer_Rc(node.next);

		node.next.next = node;

	}

	public LinkedList MergeList(LinkedList l1, LinkedList l2) {
		LinkedList mylist = new LinkedList();

		Node temp1 = l1.head;
		Node temp2 = l2.head;

		if (temp1 != null && temp2 != null) {
			if (temp1.data > temp2.data) {
				mylist.addLast(temp1.data);
				temp1 = temp1.next;
			} else {
				mylist.addLast(temp2.data);
				temp2 = temp2.next;
			}
		}

		while (temp1 != null) {
			mylist.addLast(temp1.data);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			mylist.addLast(temp2.data);
			temp2 = temp2.next;
		}

		return mylist;
	}

}
