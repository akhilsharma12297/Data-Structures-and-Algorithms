import java.util.ArrayList;
import java.util.LinkedList;

public class PracticeIMP {

	public static void main(String[] args) {

		String str = "abbaeae";

		counter(str);

		func("ABC", "");

	}

	public static int findDouble(int[] arr) {

		int x = 1;

		for (int i = 0; i < arr.length - 1; i++) {

			x = x ^ arr[i];
		}

		return x;
	}

	public static int missing(int[] arr) {

		int x1 = arr[0];

		int x2 = 1;

		for (int i = 1; i < arr.length; i++) {
			x1 = x1 ^ arr[i];
		}

		for (int i = 2; i <= arr.length + 1; i++) {
			x2 = x2 ^ i;

		}

		return (x2 ^ x1);
	}

	public static void counter(String str) {
		String temp = "";

		String buf = "";

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				temp = str.substring(i, j);

				if (temp.length() >= 2) {

					for (int k = temp.length() - 1; k >= 0; k--) {

						buf = buf + temp.charAt(k);

					}

				}

				if (buf.equals(temp)) {

					System.out.println(temp);

				}
				buf = new String();

			}
		}
	}

	public static void func(String q, String a) {

		if (q.length() == 0) {
			System.out.println(a);
			return;
		}

		char ch = q.charAt(0);
		String ros = q.substring(1);

		for (int i = 0; i <= a.length(); i++) {

			String l = a.substring(0, i);

			String r = a.substring(i);

			func(ros, l + ch + r);

		}

	}

}
