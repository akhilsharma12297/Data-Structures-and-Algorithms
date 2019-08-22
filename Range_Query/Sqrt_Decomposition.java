package Range_Query;

import java.util.Arrays;

public class Sqrt_Decomposition {

	static int[] arr;
	static int sqrt;
	static int[] block;

	public Sqrt_Decomposition(int[] input) {

		sqrt = (int) Math.ceil(Math.sqrt(input.length));
		block = new int[sqrt];
		arr = new int[sqrt * sqrt];

		System.arraycopy(input, 0, arr, 0, input.length);

		for (int i = 0; i < block.length; i++) {
			int startIndex = i * sqrt;

			for (int j = 0; j < sqrt; j++) {
				block[i] += arr[startIndex + j];
			}
		}

	}

	public int query(int startidx, int endidx) {

		int startBlockidx = startidx / sqrt;
		int endBlockidx = endidx / sqrt;

		int sum = 0;

		for (int i = startBlockidx + 1; i < endBlockidx; i++) {
			sum += block[i];
		}

		int startIdx = startidx % sqrt;
		int endIdx = endidx % sqrt;

		for (int i = startIdx; i < sqrt; i++) {
			sum += arr[startBlockidx * sqrt + i];
		}

		for (int i = 0; i <= endIdx; i++) {
			sum += arr[endBlockidx * sqrt + i];
		}

		return sum;

	}

	public void update(int idx, int val) {
		int blockidx = idx / sqrt;

		block[blockidx] = block[blockidx] - arr[idx] + val;

		arr[idx] = val;
	}

	@Override
	public String toString() {
		return "SqrtDecomposition{\n" + "a=" + Arrays.toString(arr) + ",\n blockSums=" + Arrays.toString(block) + '}';
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 4, 6, 1, 3, 5, 7 };

		Sqrt_Decomposition rangeSum = new Sqrt_Decomposition(arr);

		System.out.println(rangeSum.query(3, 8));

		System.out.println();

		System.out.println(rangeSum);

		System.out.println();

		System.out.println(rangeSum.query(2, 6));

		System.out.println();

		rangeSum.update(5, 7);

		System.out.println();

		System.out.println(rangeSum);

		System.out.println();

		System.out.println(rangeSum.query(2, 6));
	}

}
