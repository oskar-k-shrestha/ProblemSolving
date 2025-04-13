package org.takeuforward.binarysearch;

import java.util.Arrays;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Peak element index: " + peakElement(arr));
        System.out.println("Peak element index: " + peakElement1(arr));

        arr = new int[]{1, 2, 3, 1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Peak element index: " + peakElement(arr));
        System.out.println("Peak element index: " + peakElement1(arr));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int peakElement(int[] arr) {
        if (arr.length == 1) return 0;
        // check if first element is peak
        if (arr[0] > arr[1]) return 0;
        // check if last element is peak
        if (arr[arr.length - 2] < arr[arr.length - 1]) return arr.length - 1;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     * Trick: Imagine that I am driving a car in a hilly region. I know that my starting point and ending point have the same altitude, i.e., 0 meters.
     * Now, at any given time, if I am climbing uphill, I can say that the peak will come in the future. If we’re going up, we will definitely reach a peak and then descend back down to 0 meters.
     * If I am currently descending, then either I have already conquered the peak, or I can expect a peak to come later.
     * Using the information about whether I am currently ascending or descending, we can eliminate the left or right half when searching for the peak.
     **/
    private static int peakElement1(int[] arr) {
        if (arr.length == 1) return 0;
        // check if first element is peak
        if (arr[0] > arr[1]) return 0;
        // check if last element is peak
        if (arr[arr.length - 2] < arr[arr.length - 1]) return arr.length - 1;

        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // check if mid is peak
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) return mid;

            // check if we're in left half
            if (arr[mid - 1] < arr[mid]) {
                // move to right half
                low = mid + 1;
            } else {
                // we're in right half
                high = mid - 1;
            }
        }
        return - 1;
    }
}
