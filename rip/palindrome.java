package rip;

public class palindrome {

    public static boolean isPalindromeOld(String s) {

        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


        if (str.isEmpty() || str.length() == 1) {
            return true;
        }


        int start = 0;
        int end = str.length() - 1;

        while (end > start) {

            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;

        }

        return true;

    }

    public static String p(String s) {

        if (s.length() == 1) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length() - 1; i++) {

            String tempResult = isPalindrome(s, i, i);

            if (tempResult.length() > result.length()) {
                result = tempResult;
            }

            tempResult = isPalindrome(s, i, i + 1);

            if (tempResult.length() > result.length()) {
                result = tempResult;
            }
        }
        return result;
    }


    private static String isPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }

    public static void main(String[] args) {
        System.out.println(p("asdfrgrfefrgfffffvwer"));
    }
}
