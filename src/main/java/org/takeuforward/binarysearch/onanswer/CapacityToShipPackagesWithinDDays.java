package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println("Initial weight of packages : " + Arrays.toString(arr));
        System.out.println("Days to delivery : " + days);
        System.out.println("Minimum capacity of the ship : " + minShipCapacity(arr, days));
        System.out.println("Minimum capacity of the ship : " + minShipCapacity1(arr, days));
        arr = new int[]{3, 2, 2, 4, 1, 4};
        days = 3;
        System.out.println("Initial weight of packages : " + Arrays.toString(arr));
        System.out.println("Days to delivery : " + days);
        System.out.println("Minimum capacity of the ship : " + minShipCapacity(arr, days));
        System.out.println("Minimum capacity of the ship : " + minShipCapacity1(arr, days));
        arr = new int[]{1, 2, 3, 1, 1};
        days = 4;
        System.out.println("Initial weight of packages : " + Arrays.toString(arr));
        System.out.println("Days to delivery : " + days);
        System.out.println("Minimum capacity of the ship : " + minShipCapacity(arr, days));
        System.out.println("Minimum capacity of the ship : " + minShipCapacity1(arr, days));
    }

    /**
     * Time complexity : O(r * n) here, r = SumOfAllWeights - MaxWeight
     * Space complexity : O(1)
     */
    private static int minShipCapacity(int[] arr, int days) {
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        for (int e : arr) {            // O(n)
            if (e > minCapacity) {
                minCapacity = e;
            }
            maxCapacity += e;
        }
        for (int shipCapacity = minCapacity; shipCapacity <= maxCapacity; shipCapacity++) { // O(r * n), r = SumOfAllWeights - MaxWeight
            if (calculateDaysRequired(arr, shipCapacity) <= days) { // O(n)
                return shipCapacity;
            }
        }
        return -1;
    }


    private static int calculateDaysRequired(int[] arr, int shipCapacity) {
        long bucket = 0;
        int totalDays = 0;
        for (int e : arr) {
            if ((bucket + e) <= shipCapacity) {
                bucket += e;
            } else {
                totalDays++;
                bucket = e;
            }
        }
        // increase one day of items in bucket
        return ++totalDays;
    }

    /**
     * Time complexity : O(n * log(r)) here, r = SumOfAllWeights - MaxWeight
     * Space complexity : O(1)
     */
    private static int minShipCapacity1(int[] arr, int days) {
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        for (int e : arr) {            // O(n)
            if (e > minCapacity) {
                minCapacity = e;
            }
            maxCapacity += e;
        }
        while (minCapacity <= maxCapacity) {    // O(n * log(r)) here, r = SumOfAllWeights - MaxWeight
            int shipCapacity = minCapacity + ((maxCapacity - minCapacity) / 2);
            if (calculateDaysRequired(arr, shipCapacity) <= days) { // O(n)
                // move left
                maxCapacity = shipCapacity - 1;
            } else {
                // move right
                minCapacity = shipCapacity + 1;
            }
        }
        return minCapacity;
    }
}
