package Stack;

import java.util.Stack;;

public class MinStack {

	static int minEle;

	static Stack<Integer> s = new Stack<>();

	static int getMin() {

		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}

		return minEle;
	}

	static int pop() {

		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}

		int val = s.pop();

		if (val < minEle) {

			int temp = minEle;
			minEle = 2 * minEle - val;
			return temp;
		} else {
			return val;
		}

	}

	static void push(int x) {

		if (s.size() == 0) {
			minEle = x;
			s.push(x);
		} else {
			if (x < minEle) {
				s.push(2 * x - minEle);
				minEle = x;
			}
		}
	}

	public static int min_str_reversal(String s) {

		int len = s.length();

		if (len % 2 != 0)
			return -1;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '}' && !stack.empty()) {
				if (stack.peek() == '{')
					stack.pop();
				else
					stack.push(c);
			} else
				stack.push(c);
		}

		int red_len = stack.size();

		int n = 0;
		while (!stack.empty() && stack.peek() == '{') {
			stack.pop();
			n++;
		}

		return (red_len / 2 + n % 2);

	}

}