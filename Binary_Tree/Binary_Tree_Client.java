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

		System.out.println();

		System.out.println(bt.lca(12, 62));

		System.out.println();

//		bt.BTtoDLL();

		System.out.println();

//		bt.removeLeaves();

		bt.display();

		System.out.println();

		bt.printInRange(0, 5000);

		System.out.println();

		bt.printleftView();

		System.out.println();
		System.out.println();

		bt.printRightView();

		System.out.println();
		System.out.println();

		bt.printBottomView();

		System.out.println();

		bt.printTopView();

		System.out.println();

		bt.diameter();

		System.out.println();

	}

}
