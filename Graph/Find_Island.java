package Graph;

public class Find_Island {

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		func(arr);
	}

	public static void func(int[][] arr) {

		int Nodecount = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == 1) {
					Nodecount++;
				}

			}
		}

	}

}
