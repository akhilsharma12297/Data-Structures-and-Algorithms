package Recursion;

public class All_Palindomes_of_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "abbaeae";

		func(str);

	}

	public static void func(String str) {
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

}
