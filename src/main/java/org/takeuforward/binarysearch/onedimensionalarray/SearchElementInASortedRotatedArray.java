package org.takeuforward.binarysearch.onedimensionalarray;

import java.util.Arrays;

public class SearchElementInASortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 1;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Index of target " + target + " is " + binarySearchRotatedArray(arr, target));
        arr = new int[]{1,3};
        target = 3;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Index of target " + target + " is " + binarySearchRotatedArray(arr, target));
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int binarySearchRotatedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) return mid;
            if (arr[mid] < arr[high]) {
                // right half is sorted
                if (arr[mid] < target && target <= arr[high]) {
                    // move in right half
                    low = mid + 1;
                } else {
                    // move in left half
                    high = mid - 1;
                }
            } else {
                // left half is sorted
                if (arr[low] <= target && target < arr[mid]) {
                    // move in left half
                    high = mid - 1;
                } else {
                    // move in right half
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


}
