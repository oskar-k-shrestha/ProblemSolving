package org.takeuforward.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("First and last position of element are " + Arrays.toString(position(arr, target)));
        System.out.println("First and last position of element are " + Arrays.toString(position1(arr, target)));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int[] position(int[] arr, int target) {
        int[] result = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }

        return result;
    }

    /**
     * Time complexity : O(log(n)) 2 - pass
     * Space complexity : O(1)
     */
    private static int[] position1(int[] arr, int target) {
        int[] result = {-1, -1};

        // look for lower bound
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) {
                // possible lower bound
                if (result[0] == -1) {
                    result[0] = mid;
                } else {
                    result[0] = Math.min(mid, result[0]);
                }
                // search in lower half for possible lower bound
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // look for upper bound
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) {
                // possible upper bound
                result[1] = Math.max(mid, result[1]);

                // search in upper half for possible upper bound
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;

    }
}
