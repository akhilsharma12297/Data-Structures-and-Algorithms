package Recursion;

import java.util.Stack;

public class Max_in_Stack_O1 {

	public static void main(String[] args) {

		MaxStack stack = new MaxStack();

		stack.push(10);
		System.out.println(stack.getMax());

	}

	static class MaxStack {

		static Stack<Integer> myStack = new Stack<Integer>();

		static int max = -1;

		public int getMax() {

			if (myStack.size() == 0) {
				return Integer.MIN_VALUE;
			}

			return max;

		}

		public void push(int val) {

			if (myStack.isEmpty()) {
				myStack.push(val);
				max = val;
			}

			else if (!myStack.isEmpty() && val > max) {
				myStack.push(2 * val - max);
				max = val;
			} else {
				myStack.push(val);
			}
		}

		public static int pop() {

			int popVal = myStack.pop();

			if (popVal > max) {
				int oldMax = max;
				max = 2 * max - popVal;
				return oldMax;
			} else {

				return popVal;

			}

		}

	}

}