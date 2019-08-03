package Recursion;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class First_non_repeating_char_in_Stream {

	public static void main(String[] args) {
		func("geeksforgeeks");
	}

	private static void func(String str) {

		HashSet<Character> set = new HashSet<Character>();

		Deque<Character> dll = new LinkedList<Character>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (!set.contains(ch)) {
				set.add(ch);
				dll.addLast(ch);
			} else if (dll.contains(ch)) {
				dll.remove(ch);
			}

			System.out.println(dll.peek());
		}

	}
}
