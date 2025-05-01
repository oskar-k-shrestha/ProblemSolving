package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Split array into " + k + " non-empty sub arrays");
        System.out.println("Minimum maximum sum of the sub array : " + split(arr, k));
        System.out.println("Minimum maximum sum of the sub array : " + split1(arr, k));
    }

    /**
     * Time complexity : O(n + (r * n)) here, r = sum(arr) - arr[max]
     * Space complexity : O(1)
     */
    private static int split(int[] arr, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int e : arr) {
            if (e > low) {
                low = e;
            }
            high += e;
        }
        for (int limit = low; limit <= high; limit++) {
            if (canSplitK(arr, k, limit)) return limit;
        }
        return -1;
    }

    private static boolean canSplitK(int[] arr, int k, int limit) {
        int split = 1;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= limit) {
                // add element to current sub array
                sum += arr[i];
            } else {
                // split the array at position i
                split++;
                sum = arr[i];
            }
            if (split > k) return false;
        }
        return true;
    }

    /**
     * Time complexity : O(n + (n * log(r)) here, r = sum(arr) - arr[max]
     * Space complexity : O(1)
     */
    private static int split1(int[] arr, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int e : arr) {
            if (e > low) {
                low = e;
            }
            high += e;
        }

        while (low <= high) {
            int limit = low + ((high - low) / 2);
            if (canSplitK(arr, k, limit)) {
                // move left for minimum answer
                high = limit - 1;
            } else {
                low = limit + 1;
            }
        }

        return low;
    }
}
