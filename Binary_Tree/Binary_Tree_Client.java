package Binary_Tree;

public class Binary_Tree_Client {

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		Binary_Tree bt = new Binary_Tree(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.max());

		System.out.println();

		System.out.println(bt.size());

		System.out.println();

		System.out.println(bt.height());

		System.out.println();

		System.out.println(bt.find(75));

		System.out.println();

		System.out.println(bt.nodeToRootPath(87));

		System.out.println();

		bt.KDown(25, 1);

		int[] arr2 = { 'a', 'b', 'd', 'f', 'h', -1, -1, 'g', 'i', 'm', 'o', 'v', -1, -1, 'p', 't', -1, -1, -1, 'n', 'q',
				'u', -1, 'w', -1, -1, -1, -1, 'j', 'k', 'r', 'x', -1, -1, -1, 'l', 's', 'y', -1, -1, -1, -1, -1, -1, -1,
				'c', 'e', 'z', -1, -1, -1, -1 };

		Binary_Tree bt2 = new Binary_Tree(arr2);

		System.out.println();

		System.out.println(bt.lca(12, 62));

		System.out.println();

//		bt.BTtoDLL();

		System.out.println();

//		bt.removeLeaves();
		bt.display();

		System.out.println();

		bt.printInRange(0, 5000);
	}

}
