package rip;

public class maxWater {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 8, 6, 5, 4, 8, 3, 7};

        int start = 0;
        int end = arr.length - 1;

        int maxValue = -1;

        while (end > start) {

            maxValue = Math.max(maxValue, Math.min(arr[start], arr[end]) * ((end - start) + 1));

            if (arr[start] < arr[end]) {
                start++;
            } else {
                end--;
            }

        }

        System.out.println("maxValue - " + maxValue);

    }
}
