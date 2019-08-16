package Recursion;

public class Compress_String {

	public static void main(String[] args) {

		func("abcabcaaaaaaaaaaaaabc");

	}

	private static void func(String str) {
		int n = str.length();

		for (int i = 0; i < n; i++) {
			int ctr = 1;

			while ((i < (n - 1)) && str.charAt(i) == str.charAt(i + 1)) {
				ctr++;
				i++;
			}

			System.out.print(str.charAt(i) + "" + ctr + " ");
		}
	}
}
