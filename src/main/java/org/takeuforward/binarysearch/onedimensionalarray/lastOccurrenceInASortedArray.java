package org.takeuforward.binarysearch.onedimensionalarray;

import java.awt.print.Pageable;
import java.util.Arrays;

public class lastOccurrenceInASortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,13,13,13,20,40};
        int target = 13;
        System.out.println("Initial Array : " + Arrays.toString(arr));
        System.out.println("Last occurrence of " + target + " is at index " + lastOccurrence(arr, target));
        System.out.println("Last occurrence of " + target + " is at index " + lastOccurrence1(arr, target));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int lastOccurrence(int[] arr, int target) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int lastOccurrence1(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) {
                // possible answer
                result = mid;
                // look right for possible last occurrence
                low = mid + 1;
            } else if (arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


}
