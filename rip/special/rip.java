package rip.special;

import java.util.HashMap;

class Trie {

    class Node {
        Character data;

        HashMap<Character, Node> map = new HashMap<>();

        boolean eow;

        public String toString() {
            return eow ? data + "*" : data + "";
        }
    }

    static Node root;

    int words;

    public Trie() {

        root = new Node();

        root.data = '$';


    }


    public void insert(String word) {
        insertHelper(root, word);
    }

    private void insertHelper(Node node, String word) {

        if (word.isEmpty()) {
            node.eow = true;
            return;
        }

        char f = word.charAt(0);
        String rest = word.substring(1);

        if (node.map.containsKey(f)) {

            insertHelper(node.map.get(f), rest);
        } else {
            Node temp = new Node();

            temp.data = f;
            temp.map = new HashMap<>();
            if (rest.isEmpty()) {
                temp.eow = true;
                words++;
            }
            node.map.put(f, temp);

            insertHelper(node.map.get(f), rest);
        }

    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(Node node, String word) {

        if (word.isEmpty()) {
            return node.eow;
        }

        char f = word.charAt(0);
        String rest = word.substring(1);

        if (node.map.containsKey(f)) {

            return searchHelper(node.map.get(f), rest);
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }

    private boolean startsWith(Node node, String word) {

        if (word.isEmpty()) {
            return node.map.size() > 0 || node.eow;
        }

        char f = word.charAt(0);
        String rest = word.substring(1);

        if (node.map.containsKey(f)) {
            return startsWith(node.map.get(f), rest);
        }
        return false;
    }

    public static void displayTries() {

        displayTries(root, new String());
    }

    private static void displayTries(Node node, String word) {

        System.out.println(node.data + "  { " + node.map + " }");

        for (Character ch : node.map.keySet()) {

            displayTries(node.map.get(ch), word + ch);

        }

    }

    public static void main(String[] args) {

        Trie t = new Trie();

        t.insert("a");

        System.out.println(t.search("a"));

        System.out.println(t.startsWith("a"));


    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */