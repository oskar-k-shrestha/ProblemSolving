package org.takeuforward.binarysearch;

import java.util.Arrays;

public class FindOutHowManyTimesTheArrayHasBeenRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Array was rota  ted " + findRotateCount(arr) + " times");
        arr = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Array was rotated " + findRotateCount(arr) + " times");
        arr = new int[]{3, 1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Array was rotated " + findRotateCount(arr) + " times");
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int findRotateCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int ansIndex = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // check if whole array is sorted
            if (arr[low] <= arr[high]) {
                if (ans > arr[low]) {
                    ans = arr[low];
                    ansIndex = low;
                }
            }

            // check which half is sorted
            if (arr[mid] <= arr[high]) {
                // right half is sorted
                if (ans > arr[mid]) {
                    ans = arr[mid];
                    ansIndex = mid;
                }
                // search in left half
                high = mid - 1;
            } else {
                // left half is sorted
                if (ans > arr[low]) {
                    ans = arr[low];
                    ansIndex = low;
                }
                // search in right half
                low = mid + 1;
            }
        }
        return ansIndex;
    }
}
