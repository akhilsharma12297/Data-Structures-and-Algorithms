
public class LinkedList_RandomPointer_Clone {

	class Node {

		int data;
		Node next;
		Node random;

	}

	Node head;
	Node tail;

	int size = 0;

	public LinkedList_RandomPointer_Clone func() {

		LinkedList_RandomPointer_Clone newList = new LinkedList_RandomPointer_Clone();

		clone(this.head, newList);
		newList.size = this.size;
		seprator(newList.head);

		this.head.next = this.head.next.next;

		return newList;
	}

	static boolean sw = false;

	public void clone(Node node, LinkedList_RandomPointer_Clone newList) {

		if (node == this.tail) {

			Node temp = new Node();

			temp.random = node.random;
			temp.data = node.data;
			node.next = temp;
			temp.next = null;
			newList.tail = temp;
			newList.size++;

			return;
		}

		Node temp = new Node();

		temp.random = node.random;
		temp.data = node.data;
		temp.next = node.next;

		if (!sw) {
			newList.head = temp;
			sw = true;

		}

		node.next = temp;
		newList.size++;

		clone(temp.next, newList);

	}

	public void seprator(Node node) {

		if (node.next == null) {
			return;
		}

		node.next = node.next.next;

		seprator(node.next);
	}

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

	public void display() {

		if (size == 0) {
			System.out.println("List is empty");
			return;
		}

		for (Node node = head; node != null; node = node.next) {

			System.out.print(node.data + " - > ");

		}

	}

	public static void main(String[] args) {

		LinkedList_RandomPointer_Clone ll = new LinkedList_RandomPointer_Clone();

		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.addLast(60);
		ll.addLast(70);
		ll.addLast(80);

		ll.display();

		System.out.println();

		LinkedList_RandomPointer_Clone list = ll.func();

		System.out.println();
		ll.display();
		System.out.println();
		
		list.display();

	}
}
