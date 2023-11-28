package rip;

import java.util.HashMap;
import java.util.Objects;

public class minCharMatchingT {

    public static String minWindow(String s, String t) {

        // 2 f hashmap - one from t & other from sliding window but only for required stiff

        if (t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> fmap = new HashMap<>();
        HashMap<Character, Integer> cmap = new HashMap<>();

        for (char a : t.toCharArray()) {
            fmap.put(a, fmap.getOrDefault(a, 0) + 1);
        }

        int have = 0;
        int want = fmap.size();

        int l = 0;
        int resultLength = Integer.MAX_VALUE;
        int resultStart = -1;
        int resultEnd = -1;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            cmap.put(c, cmap.getOrDefault(c, 0) + 1);

            if ((fmap.containsKey(c)) && (Objects.equals(cmap.get(c), fmap.get(c)))) {
                have++;
            }

            while (have == want) {
                if ((r - l + 1) < resultLength) {
                    resultLength = r - l + 1;
                    resultStart = l;
                    resultEnd = r;
                }

                //optmize result

                if (cmap.containsKey(s.charAt(l))) {
                    cmap.put(s.charAt(l), cmap.get(s.charAt(l)) - 1);
                    if (fmap.containsKey(s.charAt(l)) && cmap.get(s.charAt(l)) < fmap.get(s.charAt(l))) {
                        have--;
                    }
                    l++;
                }
            }

        }

        System.out.println(resultStart);
        System.out.println(resultEnd);
        System.out.println(resultLength);


        return s.substring(resultStart, resultEnd + 1);
    }

    public static String minWindow2(String s, String t) {

        // 2 f hashmap - one from t & other from sliding window but only for required stiff
        if (t.isEmpty() || (t.length() > s.length())) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int mapCounter = map.size();
        int n = s.length();
        int l = 0, r = 0;  // two pointers
        int start = 0, maxLen = 0;

        for (r = 0; r < n; r++) {
            char curR = s.charAt(r);
            if (map.containsKey(curR)) {
                map.put(curR, map.get(curR) - 1);
                if (map.get(curR) == 0)
                    mapCounter--;

                // got soltion
                if (mapCounter == 0) {
                    // finding better solution by shifting left pointer
                    while (l < n && mapCounter == 0) {
                        char curL = s.charAt(l);
                        if (map.containsKey(curL)) {
                            map.put(curL, map.get(curL) + 1);
                            if (map.get(curL) > 0)
                                mapCounter++;
                        }
                        l++;
                    }
                    // getting best solution
                    if (maxLen > r - l + 2 || maxLen == 0) {
                        maxLen = (r - l) + 2;
                        start = l - 1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);

    }

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));

    }
}
