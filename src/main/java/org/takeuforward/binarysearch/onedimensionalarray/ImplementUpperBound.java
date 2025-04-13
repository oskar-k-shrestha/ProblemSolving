package org.takeuforward.binarysearch.onedimensionalarray;

import java.util.Arrays;

public class ImplementUpperBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int target = 2;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchUpperBound(arr, target));
        arr = new int[]{3,5,8,15,19};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchUpperBound(arr, target));
        arr = new int[]{1,1,1,1,1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchUpperBound(arr, target));
        arr = new int[]{3,5,8,9,15,19};
        target = 9;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchUpperBound(arr, target));
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static int binarySearchUpperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] > target) {
                ans = mid;
                // look on the left for smaller answer
                high = mid - 1;
            } else {
                // look on the right for bigger answer
                low = mid + 1;
            }
        }
        return ans;
    }
}
