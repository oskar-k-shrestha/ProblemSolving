package org.takeuforward.binarysearch.onedimensionalarray;

import java.util.Arrays;

public class CountOccurrenceInASortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 3, 4};
        int target = 4;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Count of occurrence for " + target + " is " + count(arr, target));
    }

    /**
     * Time complexity : O(log(n)) 2 - pass
     * Space complexity : O(1)
     */
    private static int count(int[] arr, int target) {
        if (arr.length == 0) return 0;
        int lowerRange = binarySearch(arr, target, true);
        int upperRange = binarySearch(arr, target, false);
        if (lowerRange == -1 || upperRange == -1) {
            return 0;
        } else {
            return upperRange - lowerRange + 1;
        }
    }

    private static int binarySearch(int[] arr, int target, boolean isSearchingLower) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                index = mid;
                if (isSearchingLower) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return index;
    }
}
