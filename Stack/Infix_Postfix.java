package Stack;

import java.util.Stack;

public class Infix_Postfix {

	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";

		System.out.println(I_P(str));

	}

	private static String I_P(String exp) {
		String result = new String("");

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c))
				result += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					stack.pop();
			} else // an operator is encountered
			{
				while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
					if (stack.peek() == '(')
						return "Invalid Expression";
					result += stack.pop();
				}
				stack.push(c);
			}

		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

	public static int prec(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		} else {
			return -1;
		}

	}

}
