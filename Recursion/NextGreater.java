package Recursion;

import java.util.Stack;

public class NextGreater {

	public static void main(String[] args) {

		int arr[] = { -4, 5, 25, 13, 6, 12 };

		printNGE(arr);
	}

	private static void arrFunc(int[] arr) {

		int ans[] = new int[arr.length];
		ans[arr.length - 1] = -1;

		int max = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {

			if (max > arr[i]) {
				ans[i] = max;
			} else {
				ans[i] = -1;
				max = arr[i];
			}

		}

		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static void func(int[] arr) {
		Stack<Integer> stack = new Stack<>();

		for (int val : arr) {
			if (!stack.isEmpty() && stack.peek() < val) {
				stack.pop();
			} else {
				stack.push(val);
			}
		}

		System.out.println(stack);

	}

	public static void printNGE(int arr[]) {
		int i = 0;
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int element, next;

		stack.push(arr[0]);

		for (i = 1; i < n; i++) {
			next = arr[i];

			if (stack.isEmpty() == false) {

				element = stack.pop();

				while (element < next) {
					System.out.print(next + " ");
					if (stack.isEmpty() == true)
						break;
					element = stack.pop();
				}
				if (element > next)
					stack.push(element);
			}

			stack.push(next);
		}

		while (stack.isEmpty() == false) {
			element = stack.pop();
			next = -1;
			System.out.print(next + " ");
		}
	}

}
