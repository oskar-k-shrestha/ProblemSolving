package org.takeuforward.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("First and last position of element are " + Arrays.toString(position(arr, target)));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static int[] position(int[] arr, int target) {
        int[] result = {-1,-1};

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
}
