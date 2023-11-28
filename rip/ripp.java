package rip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class Node {
    int id;
    ArrayList<Node> r = new ArrayList<Node>();

    Node(int id) {
        this.id = id;
        this.r = new ArrayList<>();
    }

    Node(int id, ArrayList<Node> r) {
        this.id = id;
        this.r = r;
    }

}

class Company {

    HashMap<Integer, Node> map;

    Node root;

    int size;

    Company(Node e) {
        map = new HashMap<>();
        this.root = e;
        size++;
        map.put(e.id, e);
    }

    public ArrayList<Node> findMyReporties(int id) {
        return findMe(root, id);
    }

    private ArrayList<Node> findMe(Node node, int id) {
        if (node == null) {
            return new ArrayList<>();
        }

        ArrayList<Node> ans = new ArrayList<>();

        if (id == node.id) {
            return new ArrayList<>(node.r);
        }

        for (Node emp : node.r) {
            ans.addAll(findMe(emp, id));
        }

        return ans;
    }

    public void display() {

        display(root);

    }

    private void display(Node node) {

        String str = node.id + " -> ";

        for (Node emp : node.r) {
            str += emp.id + " . ";
        }

        System.out.println(str);

        for (Node child : node.r) {
            display(child);
        }
    }


}

public class ripp {

    public static void main(String[] args) {

//        If we have something like a org tree of a company where we have tree like structure
//        which represents the total number of employees directly reporting to him and then
//        if we scroll further each branch further expands to the employees reporting to the
//        current employee and so on. Question was to find the total number of direct repotees
//        of a given manager. (Not the total employees under him but the direct ones)
        Node e4 = new Node(4, new ArrayList<>(
                Arrays.asList(new Node(7), new Node(8), new Node(9),
                        new Node(10), new Node(11), new Node(12),
                        new Node(14))
        ));

        Node e5 = new Node(5);
        Node e6 = new Node(6);

        Node e3 = new Node(3, new ArrayList<>(Arrays.asList(e4, e5, e6)));

        Node e2 = new Node(2);

        Node ceo = new Node(1, new ArrayList<>(Arrays.asList(e2, e3)));

        Company c = new Company(ceo);

        c.display();
        System.out.println("-----------------------");
        System.out.println(c.findMyReporties(7).size());

    }
}
