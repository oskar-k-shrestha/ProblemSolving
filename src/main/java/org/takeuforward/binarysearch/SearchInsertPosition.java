package org.takeuforward.binarysearch;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 7;
        System.out.println("Initial arr : " + Arrays.toString(arr));
        System.out.println("Expected index of target " + target + " is : " + searchInsertPosition(arr, target));

        System.out.println("Initial arr : " + Arrays.toString(arr));
        System.out.println("Expected index of target " + target + " is : " + searchInsertPosition1(arr, target));
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int searchInsertPosition(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int searchInsertPosition1(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] >= target) {
                // probable answer
                ans = mid;
                // look left for more possibility
                high = mid - 1;
            } else {
                // look right
                low = mid + 1;
            }
        }

        return ans;
    }


}
