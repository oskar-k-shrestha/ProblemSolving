package org.takeuforward.binarysearch;

import java.util.Arrays;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Peak element : " + peakElement(arr));

        arr = new int[]{1, 2, 3, 1};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Peak element : " + peakElement(arr));
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
}
