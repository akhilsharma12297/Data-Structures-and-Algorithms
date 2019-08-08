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

//      bt.BTtoDLL();

//	    bt.leafs_To_DLL();

		System.out.println();

//		bt.removeLeaves();

		bt.display();

		System.out.println();

		bt.printInRange(0, 100);

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

		bt.inroderSucessor(87);

		System.out.println();

		bt.levelAvg();

		System.out.println();

		bt.zigzag();

		System.out.println();

		bt.KthLargest(5);

		System.out.println();

		bt.Serialize();

		System.out.println();

		System.out.println(bt.Serialize_LEETCODE());
		System.out.println();

		bt.CountKFarLeaf(1);

		System.out.println();
		System.out.println();

		bt.postorderTraversalSQ();

		System.out.println();

		System.out.println();

		bt.postorderTraversalOneStack();

		System.out.println();

		System.out.println();

		System.out.println(bt.NodeToNodePath(12, 87));

		System.out.println();

		bt.Reverselevelorder();

		System.out.println();

		System.out.println();

		bt.Reverselevelorder();

		System.out.println();

		bt.morrisInorderTraversal();

		System.out.println();

		System.out.println();

		bt.morrisPreorderTraversal();

		System.out.println();

		System.out.println();

	}

}
