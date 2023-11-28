package rip;

public class findMin {

    public static void main(String[] args) {

        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));

    }

    public static int findMin(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        int res = arr[l];

        while (l <= r) {

            int mid = (l + r) / 2;

            if (arr[l] < arr[r]) {
                res = Math.min(res, arr[r]);
            }

            res = Math.min(res, arr[mid]);

            if (arr[mid] >= arr[r]) {
                //go right
                l = mid + 1;

            } else {
                //go left
                r = mid - 1;
            }

        }

        return res;

    }
}
