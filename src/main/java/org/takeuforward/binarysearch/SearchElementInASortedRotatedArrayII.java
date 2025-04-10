package org.takeuforward.binarysearch;

import java.util.Arrays;

public class SearchElementInASortedRotatedArrayII {

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 2;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Element " + target + " was found? " + search(arr, target));
        arr = new int[]{3, 1};
        target = 1;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Element " + target + " was found? " + search(arr, target));
    }

    /**
     * Time complexity : O(log(n)) average case, O(n/2) in worse case
     * Space complexity : O(1)
     */
    private static boolean search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) return true;
            // check if low, mid, and high is same
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }
            // determine which half is sorted
            if (arr[low] <= arr[mid]) {
                // Left side is sorted.
                if (arr[low] <= target && target < arr[mid]) {
                    // Target lies in the sorted left half.
                    high = mid - 1;
                } else {
                    // Target lies in the right half.
                    low = mid + 1;
                }
            } else {
                // Right side is sorted.
                if (arr[mid] < target && target <= arr[high]) {
                    // Target lies in the sorted right half.
                    low = mid + 1;
                } else {
                    // Target lies in the left half.
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
