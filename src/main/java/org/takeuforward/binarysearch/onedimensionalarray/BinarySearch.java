package org.takeuforward.binarysearch.onedimensionalarray;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 1;
        System.out.println("Initial Array : " + Arrays.toString(arr));
        System.out.println("Target " + target + " is at index " + binarySearch(arr, target));

        System.out.println("Initial Array : " + Arrays.toString(arr));
        System.out.println("Target " + target + " is at index " + binarySearchRecursive(arr, 0, arr.length - 1, target));
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(log(n))
     */
    private static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);
        if (arr[mid] == target) return mid;
        if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

        return binarySearchRecursive(arr, low, high, target);
    }
}
