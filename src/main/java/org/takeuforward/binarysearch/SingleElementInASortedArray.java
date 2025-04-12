package org.takeuforward.binarysearch;

import java.util.Arrays;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Single element is : " + findSingleElement(arr));
    }

    private static int findSingleElement(int[] arr) {
        if (arr.length == 1) return 0;

        // check if first element is single
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        // check if last element is single
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // check if mid is single
            if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1])
                    || (mid % 2 != 0 && arr[mid - 1] == arr[mid])) {
                // left half is correct, search in right half
                low = mid + 1;
            } else {
                // search in left half
                high = mid - 1;
            }
        }

        return -1;
    }
}
