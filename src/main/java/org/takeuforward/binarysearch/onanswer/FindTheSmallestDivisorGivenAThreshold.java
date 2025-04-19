package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Threshold value : " + threshold);
        System.out.println("Smallest divisor : " + smallestDivisor(arr, threshold));
        System.out.println("Smallest divisor : " + smallestDivisor1(arr, threshold));
        arr = new int[]{44, 22, 33, 11, 1};
        threshold = 5;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Threshold value : " + threshold);
        System.out.println("Smallest divisor : " + smallestDivisor(arr, threshold));
        System.out.println("Smallest divisor : " + smallestDivisor1(arr, threshold));
    }

    /**
     * Time complexity : O(r * n) here, r = maxDivisor
     * Space complexity : O(1)
     */
    private static int smallestDivisor(int[] arr, int threshold) {
        int maxDivisor = Integer.MIN_VALUE;
        for (int e : arr) {                 // O(n)
            if (e > maxDivisor) {
                maxDivisor = e;
            }
        }
        for (int i = 1; i <= maxDivisor; i++) {     // O(r * n), r = 1 -> maxDivisor
            long total = 0;
            for (int e : arr) {     // O(n)
                total += (long) Math.ceil((double) e / (double) i);
            }
            if (total <= threshold) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Time complexity : O(n * log(r)) here, r = maxDivisor
     * Space complexity : O(1)
     * Math trick : ceil (a / b) = floor (a + b - 1) / b
     */
    private static int smallestDivisor1(int[] arr, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int e : arr) {             // O(n)
            if (e > high) {
                high = e;
            }
        }

        while (low <= high) {                       // O(n * log(r)), r = maxDivisor
            int mid = low + ((high - low) / 2);
            int total = 0;
            for (int e : arr) {                                         // O(n)
                total += (e + mid - 1) / mid;
            }
            if (total <= threshold) {
                // move left
                high = mid - 1;
            } else {
                // move right
                low = mid + 1;
            }
        }
        return low;
    }
}
