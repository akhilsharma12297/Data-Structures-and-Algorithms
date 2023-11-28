package rip;

import java.util.*;

class TopK {


//    public static int[] topKFrequent(int[] nums, int k) {
//
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//
//        int[] result = new int[k];
//
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//
//        System.out.println(map);
//
//        int ctr = 0;
//        while (k != ctr) {
//            int topValue = map.firstKey();
//            result[ctr] = (topValue);
//            map.remove(topValue);
//            ctr++;
//        }
//
//        return result;
//
//    }


    public static int[] topKFrequent(int[] nums, int k) {

        if (k == 0) return new int[]{};

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int currNum : nums) {
            freqMap.put(currNum, freqMap.getOrDefault(currNum, 0) + 1);
        }

        PriorityQueue<Integer> freqMaxHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get).reversed());

        freqMaxHeap.addAll(freqMap.keySet());

        int i = 0;
        int[] output = new int[k];

        while (i < k) {
            output[i] = freqMaxHeap.poll();
            i++;
        }

        return output;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}