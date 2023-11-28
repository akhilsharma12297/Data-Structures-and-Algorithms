package rip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class palin {

    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;

    }

    public static void helper(String s, ArrayList<String> ans, List<List<String>> result) {

        if (s.isEmpty()) {
            return;
        }

        if (isPalindrome(ans)) {
            result.add(new ArrayList<>(ans));
        }

        char ch = s.charAt(0);
        ans.add(String.valueOf(ch));
        helper(s.substring(0), ans, result);
        ans.remove(ans.size() - 1);

    }

    public static boolean isPalindrome(ArrayList<String> s) {

        if (s.isEmpty()) {
            return true;
        }

        if (s.size() == 1) {
            return true;
        }

        int i = 0;
        int j = s.size() - 1;

        while (j >= i) {
            if (!Objects.equals(s.get(i), s.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(partition("aab"));

    }
}
