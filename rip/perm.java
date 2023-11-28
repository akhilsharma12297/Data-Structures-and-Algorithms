package rip;

public class perm {

    public static boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        for (; j < s1.length(); j++) {
            arr[s2.charAt(j) - 'a']--;
        }

        j--;

        if (isEmpty(arr)) {
            return true;
        }

        while (j < s2.length()) {
            arr[s2.charAt(i) - 'a']++;

            i++;
            j++;

            if (j < s2.length()) {
                arr[s2.charAt(j) - 'a']--;
            }

            if (isEmpty(arr)) {
                return true;
            }
        }

        return isEmpty(arr);
    }

    public static boolean checkPerm(String s1, String s2) {

        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        for (; j < s2.length(); j++) {
            arr[s2.charAt(j) - 'a']--;
        }

        if (isEmpty(arr)) {
            return true;
        }

        while (j < s2.length()) {

            arr[s2.charAt(i) - 'a']++;

            i++;
            j++;

            if (j < s2.length()) {
                arr[s2.charAt(i) - 'a']--;
            }

            if (isEmpty(arr)) {
                return true;
            }

        }
        return isEmpty(arr);

    }

    public static boolean isEmpty(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "ab";

        String s2 = "eidbaooo";

        System.out.println(checkPerm(s1, s2));

    }

}
