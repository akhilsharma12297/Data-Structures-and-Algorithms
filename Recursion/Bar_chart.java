package Recursion;

public class Bar_chart {

	public static void main(String[] args) {

		int arr[] = { 4, 2, 3, 5, 6, 8, 6, 1, 2, 10, 3, 1, 6, 4 };

		barChart(arr);

	}

	public static void barChart(int arr[]) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			max = Math.max(arr[i], max);

		}

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == max) {
				arr[i] = -max;
			} else {
				arr[i] = (max - arr[i]);
			}

		}

		System.out.println();

		while (max > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					System.out.print("*" + " ");
					arr[i] = arr[i] + 1;
				} else if (arr[i] == 0) {
					System.out.print("*" + " ");
					arr[i] = arr[i] - 1;
				} else {
					System.out.print(" " + " ");
					arr[i] = arr[i] - 1;
				}

			}

			System.out.println();

			max--;
		}

	}
}