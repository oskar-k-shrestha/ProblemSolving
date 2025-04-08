package org.takeuforward.binarysearch;

import java.util.Arrays;

public class FloorAndCeilInSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int target = 5;
        System.out.println("Initial array : " + Arrays.toString(arr));
        Result result = floorAndCeilInSortedArray(arr, target);
        System.out.println("Floor : " + result.floor + " and Ceil : " + result.ceil);
        result = floorAndCeilInSortedArray1(arr, target);
        System.out.println("Floor : " + result.floor + " and Ceil : " + result.ceil);
        System.out.println("Initial array : " + Arrays.toString(arr));
        target = 7;
        result = floorAndCeilInSortedArray(arr, target);
        System.out.println("Floor : " + result.floor + " and Ceil : " + result.ceil);
        result = floorAndCeilInSortedArray1(arr, target);
        System.out.println("Floor : " + result.floor + " and Ceil : " + result.ceil);
        target = 8;
        System.out.println("Initial array : " + Arrays.toString(arr));
        result = floorAndCeilInSortedArray(arr, target);
        System.out.println("Floor : " + result.floor + " and Ceil : " + result.ceil);
        result = floorAndCeilInSortedArray1(arr, target);
        System.out.println("Floor : " + result.floor + " and Ceil : " + result.ceil);
    }

    private static class Result {

        int ceil;

        int floor;

    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    private static Result floorAndCeilInSortedArray(int[] arr, int target) {
        Result result = new Result();
        result.floor = Integer.MIN_VALUE;
        result.ceil = Integer.MAX_VALUE;

        for (int element : arr) {
            if (element == target) {
                result.floor = element;
                result.ceil = element;
                break;
            } else if (element < target) {
                result.floor = Math.max(element, result.floor);
            } else {
                result.ceil = Math.min(element, result.ceil);
            }
        }

        return result;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static Result floorAndCeilInSortedArray1(int[] arr, int target) {
        Result result = new Result();
        result.floor = Integer.MIN_VALUE;
        result.ceil = Integer.MAX_VALUE;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) {
                result.floor = target;
                result.ceil = target;
                return result;
            } else if (arr[mid] < target) {
                // possible floor
                result.floor = arr[mid];
                // search in right half
                low = mid + 1;
            } else {
                // possible ceil
                result.ceil = arr[mid];
                high = mid - 1;
            }
        }
        return result;
    }
}
