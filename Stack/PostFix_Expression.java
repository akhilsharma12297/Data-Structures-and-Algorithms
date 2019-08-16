package Stack;

import java.util.*;

public class PostFix_Expression {

	public static void main(String[] args) {
		String exp = "100 200 + 2 / 5 * 7 +";
		String exp2 = "100 * 2 + 12";
		System.out.println(func(exp2));

	}

	private static int func(String str) {

		LinkedList<Integer> stack = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == ' ')
				continue;

			else if (Character.isDigit(c)) {
				int n = 0;

				while (Character.isDigit(c)) {
					n = n * 10 + (int) (c - '0');
					i++;
					c = str.charAt(i);
				}
				i--;

				stack.push(n);
			} else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}
}
