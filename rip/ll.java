package rip;

public class ll {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {


        Node temp = head;

        while (temp != null) {

            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;

        }

        Node temp2 = head;

        while (temp2 != null) {

            if (temp2.random != null) {
                temp2.next.random = temp2.random.next;
            }
            temp2 = temp2.next != null ? temp2.next.next : null;
        }

        Node returnCloneHead = head.next;
        Node cloneHead = returnCloneHead;
        Node ogHead = head;

        while (ogHead.next != null && cloneHead.next != null) {

            ogHead.next = ogHead.next.next;
            cloneHead.next = cloneHead.next.next;

        }

        return returnCloneHead;
    }

    public static void main(String[] args) {

        Node n1 = new Node(7);

        Node n2 = new Node(13);

        n1.next = n2;

        Node n3 = new Node(11);

        n2.next = n3;

        Node n4 = new Node(10);

        n3.next = n4;

        Node n5 = new Node(1);

        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        copyRandomList(n1);
    }
}


