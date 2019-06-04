package DP;

import java.util.HashSet;

public class WordBreak {

	static HashSet<String> dict = new HashSet<String>();

	public static void main(String[] args) {

		String temp_dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"like", "ice", "cream" };

		for (String str : temp_dictionary) {
			dict.add(str);
		}

		System.out.println(wordBreak("ilikesamsung"));
		System.out.println(wordBreak("iiiiiiii"));
		System.out.println(wordBreak(""));
		System.out.println(wordBreak("ilikelikeimangoiii"));
		System.out.println(wordBreak("samsungandmango"));
		System.out.println(wordBreak("samsungandmangok"));

	}

	public static boolean wordBreak(String str) {

		if (str.length() == 0) {
			return true;
		}

		for (int i = 1; i <= str.length(); i++) {

			if (dict.contains(str.substring(0, i)) && wordBreak(str.substring(i, str.length()))) {
				return true;
			}

		}
		return false;

	}
}
