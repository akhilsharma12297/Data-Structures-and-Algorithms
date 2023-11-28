package rip;

import java.util.HashMap;

class FrequencyTracker {

    HashMap<Integer, Integer> counter;
    int[] freq;

    public FrequencyTracker() {
        counter = new HashMap<>();
        freq = new int[100001];
    }

    public void add(int number) {
        if (counter.containsKey(number)) {
            counter.put(number, counter.get(number) + 1);
        } else {
            counter.put(number, 1);
        }
        freq[counter.get(number)]++;
    }

    public void deleteOne(int number) {

        if (counter.get(number) == null) {
            return;
        }

        freq[number]--;

        counter.put(number, counter.getOrDefault(number, 0) - 1);

    }

    public boolean hasFrequency(int frequency) {
        return freq[frequency] > 0;
    }

    public static void main(String[] args) {

//        ["FrequencyTracker","add","add","hasFrequency","hasFrequency","add","add","add"]
//        [[],                [5],  [5],   [1],            [2],         [6], [5],  [1]]
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(5);
        frequencyTracker.add(5);
        System.out.println(frequencyTracker.hasFrequency(1));// Returns true, because 3 occurs once
        System.out.println(frequencyTracker.hasFrequency(2));// Returns true, because 3 occurs once
        frequencyTracker.add(6);
        frequencyTracker.add(5);
        frequencyTracker.add(1);
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
