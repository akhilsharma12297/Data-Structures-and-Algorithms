package rip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, (a, b) -> a.compareTo(b));

        List<List<String>> result = new ArrayList<>();

        int l = 0;
        int r = products.length - 1;

        for (int i = 1; i <= searchWord.length(); i++) {
            result.add(suggestedProductsHelper(products, searchWord.substring(0, i), l, r));
        }

        return result;
    }

    public List<String> suggestedProductsHelper(String[] products, String searchWord, int l, int r) {
        List<String> result = new ArrayList<>();

        while (r >= l) {
            if (products[l].startsWith(searchWord) && products[r].startsWith(searchWord)) {
                int temp = l;
                int ctr = 3;

                while (temp < products.length && ctr-- > 0 && products[temp].startsWith(searchWord)) {
                    result.add(products[temp]);
                    temp++;
                }

                break;
            }

            while (l <= r && !products[l].startsWith(searchWord)) {
                l++;
            }

            while (l <= r && !products[r].startsWith(searchWord)) {
                r--;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        SuggestedProducts p = new SuggestedProducts();

        System.out.println(p.suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));


//        Output
//                [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags","banner"],["bags","banner","box"]]
//        Expected
//                [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
//


    }

}
