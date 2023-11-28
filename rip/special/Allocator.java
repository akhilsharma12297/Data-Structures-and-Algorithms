package rip.special;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Allocator {

    // main memory storage
    int[] memory;

    // map <mid , area of mid (start , end)
    HashMap<Integer, ArrayList<Integer>> map;

    public Allocator(int n) {
        memory = new int[n];
        map = new HashMap<>();
    }

    public int allocate(int size, int mID) {

        for (int i = 0; i < memory.length - size; i++) {
            boolean isFree = true;
            for (int j = 0; j < size; j++) {
                if (memory[i + j] != 0) {
                    isFree = false;
                    break;
                }
            }

            if (isFree) {
                for (int j = 0; j < size; j++) {
                    memory[i + j] = mID;
                }

                map.computeIfAbsent(mID, k -> new ArrayList<>()).addAll(range(i, i + size));

                return i;
            }
        }

        return -1;

    }

    public int free(int mID) {
        if (map.containsKey(mID)) {

            ArrayList<Integer> area = map.get(mID);

            for (Integer i : area) {
                memory[i] = 0;
            }

            map.remove(mID);

            return area.size();
        }
        return -1;
    }

    private List<Integer> range(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(i);
        }
        return result;
    }


    public static void main(String[] args) {

        Allocator loc = new Allocator(10); // Initialize a memory array of size 10. All memory units are initially free.

        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
        System.out.println(loc.allocate(1, 2)); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
        System.out.println(loc.allocate(1, 3)); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
        System.out.println(loc.free(2)); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
        System.out.println(loc.allocate(3, 4)); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
        System.out.println(loc.free(1)); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
        System.out.println(loc.allocate(10, 2)); // We can not find any free block with 10 consecutive free memory units, so we return -1.
        System.out.println(loc.free(4)); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.
    }
}