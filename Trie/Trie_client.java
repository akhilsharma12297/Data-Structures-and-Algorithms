package Trie;

public class Trie_client {

	public static void main(String[] args) {
		Trie T = new Trie();

		T.addWord("as");
		T.addWord("ask");
		T.addWord("ant");
		T.addWord("an");
		T.addWord("are");
		T.addWord("sea");
		T.addWord("seen");
		T.addWord("see");

		T.displayTries();

		System.out.println();

		System.out.println(
				T.searchword("an") + " " + T.searchword("ant") + " " + T.searchword("as") + " " + T.searchword("ask"));

		T.removeWord("an");

		System.out.println(
				T.searchword("an") + " " + T.searchword("ant") + " " + T.searchword("as") + " " + T.searchword("ask"));

		T.removeWord("ant");

		System.out.println(
				T.searchword("an") + " " + T.searchword("ant") + " " + T.searchword("as") + " " + T.searchword("ask"));

		T.removeWord("as");

		System.out.println(
				T.searchword("an") + " " + T.searchword("ant") + " " + T.searchword("as") + " " + T.searchword("ask"));

		T.removeWord("ask");
		System.out.println(
				T.searchword("an") + " " + T.searchword("ant") + " " + T.searchword("as") + " " + T.searchword("ask"));

	}

}
