package Recursion;
import java.util.*;

public class Akridata {

	public static void main(String[] args) {

		String str1 = "1 A 7 9";
		String str2 = "2 B 8 1";
		String str3 = "3 C 6 1";
		String str4 = "4 D 4 5";
		String str5 = "5 E 9 9";
		String str6 = "6 F 3 4";
		String str7 = "7 G 8 2";
		String str8 = "8 H 5 2";
		String str9 = "9 I 6 -1";
		String str10 = "10 J 9 4";

		ArrayList<String> qstr = new ArrayList<>();

		qstr.add(str1);
		qstr.add(str2);
		qstr.add(str3);
		qstr.add(str4);
		qstr.add(str5);
		qstr.add(str6);
		qstr.add(str7);
		qstr.add(str8);
		qstr.add(str9);
		qstr.add(str10);

		func(10000000, qstr);

		for (int i = 0; i < ans.size(); i++) {
			BonusNode temp = ans.get(i);

			System.out.println(temp.emp_id + "< - >" + temp.amount);
		}

	}

	static class Node {
		int e_Id;
		String e_name;
		int pro_rating;
		int mgr_id;

		Node(int e_id, String e_name, int pro_rating, int mgr_id) {
			this.e_Id = e_id;
			this.e_name = e_name;
			this.pro_rating = pro_rating;
			this.mgr_id = mgr_id;
		}
	}

	static class BonusNode implements Comparable<BonusNode> {
		int emp_id;
		int amount;

		BonusNode(int emp_id, int amount) {
			this.emp_id = emp_id;
			this.amount = amount;
		}

		public int compareTo(BonusNode o) {
			return o.amount - this.amount;
		}

	}

	static class mapNode {
		ArrayList<Node> list;
		int val;
	}

	public static void func(int amount, ArrayList<String> list) {

		Node[] arr = helper(list);

		HashMap<Integer, mapNode> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			Node temp = arr[i];

			int temp_mgr_id = temp.mgr_id;

			if (map.containsKey(temp_mgr_id)) {
				mapNode tempnode = map.get(temp_mgr_id);

				tempnode.list.add(temp);
				tempnode.val += temp.pro_rating;

				map.put(temp_mgr_id, tempnode);

			} else {

				mapNode tempNode = new mapNode();

				tempNode.list = new ArrayList<>();

				tempNode.list.add(temp);

				tempNode.val = temp.pro_rating;

				map.put(temp_mgr_id, tempNode);

			}

		}

		giveBonus(map, amount, -1);

	}

	static ArrayList<BonusNode> ans = new ArrayList<>();

	public static void giveBonus(HashMap<Integer, mapNode> map, int amount, int emp_id) {

		mapNode tempNode = map.get(emp_id);

		if (tempNode == null) {
			return;
		}

		ArrayList<Node> list = tempNode.list;

		int val = tempNode.val;

		int newamount = amount / val;

		for (int i = 0; i < list.size(); i++) {
			int bamount;

			if (emp_id == -1) {
				bamount = (amount / 100) * 10;
			} else {
				bamount = ((newamount * list.get(i).pro_rating) / 100) * 10;
			}

			BonusNode temp = new BonusNode(list.get(i).e_Id, bamount);

			ans.add(temp);

			giveBonus(map, amount - bamount, list.get(i).e_Id);
		}

	}

	public static Node[] helper(ArrayList<String> input) {
		Node[] ans = new Node[input.size()];

		for (int i = 0; i < input.size(); i++) {
			String str = input.get(i);

			String[] arr = str.split(" ");

			ans[i] = new Node(Integer.valueOf(arr[0]), arr[1], Integer.valueOf(arr[2]), Integer.valueOf(arr[3]));

		}

		return ans;
	}

}
