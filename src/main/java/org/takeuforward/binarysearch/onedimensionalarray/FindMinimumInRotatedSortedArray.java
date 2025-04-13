package org.takeuforward.binarysearch.onedimensionalarray;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Minimum element is : " + findMinimum(arr));
        arr = new int[]{11, 13, 15, 17};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Minimum element is : " + findMinimum(arr));
        arr = new int[]{3, 1, 2};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Minimum element is : " + findMinimum(arr));
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int findMinimum(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // if search space is already sorted take the left most element
            // no need to search further
            if (arr[low] <= arr[high]) {
                ans = Math.min(arr[low], ans);
                break;
            }
            // identify sorted half
            if (arr[mid] <= arr[high]) {
                // right half is sorted
                ans = Math.min(arr[mid], ans);
                // move left
                high = mid - 1;
            } else {
                // left half is sorted
                ans = Math.min(arr[low], ans);
                // move right
                low = mid + 1;
            }
        }
        return ans;
    }
}
