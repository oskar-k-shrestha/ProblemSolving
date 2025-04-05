package org.takeuforward.binarysearch;

import java.util.Arrays;

public class ImplementLowerBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int target = 2;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchLowerBound(arr, target));
        arr = new int[]{3,5,8,15,19};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchLowerBound(arr, target));
        arr = new int[]{1,1,1,1,1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Lower bound for target " + target + " is at index " + binarySearchLowerBound(arr, target));
    }

    private static int binarySearchLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (arr[mid] >= target) {
                // maybe an answer
                ans = mid;
                // look on the left for smaller
                high = mid - 1;
            } else {
                // look on the right
                low = mid + 1;
            }
        }
        return ans;
    }
}
