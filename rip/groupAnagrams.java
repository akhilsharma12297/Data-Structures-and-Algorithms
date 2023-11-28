package rip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] ch = s.toCharArray();

            Arrays.sort(ch);

            if (map.containsKey(Arrays.toString(ch))) {
                ArrayList<String> result = map.get(Arrays.toString(ch));
                result.add(s);
                map.put(Arrays.toString(ch), result);
            } else {
                map.put(Arrays.toString(ch), new ArrayList<>());
                map.get(Arrays.toString(ch)).add(s);
            }
        }
        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));

    }

}
