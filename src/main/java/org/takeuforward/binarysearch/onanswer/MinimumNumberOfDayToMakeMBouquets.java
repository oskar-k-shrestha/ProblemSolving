package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class MinimumNumberOfDayToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Number of bouquets : " + m);
        System.out.println("Number of adjacent flower in a bouquet : " + k);
        System.out.println("Min days required : " + minDaysToMakeBouquet1(arr, m, k));
        System.out.println("Min days required : " + minDaysToMakeBouquet(arr, m, k));
        arr = new int[]{7,7,7,7,12,7,7};
        m = 2;
        k = 3;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Number of bouquets : " + m);
        System.out.println("Number of adjacent flower in a bouquet : " + k);
        System.out.println("Min days required : " + minDaysToMakeBouquet1(arr, m, k));
        System.out.println("Min days required : " + minDaysToMakeBouquet(arr, m, k));
        arr = new int[]{1000000000,1000000000};
        m = 89945;
        k = 32127;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Number of bouquets : " + m);
        System.out.println("Number of adjacent flower in a bouquet : " + k);
        System.out.println("Min days required : " + minDaysToMakeBouquet1(arr, m, k));
        System.out.println("Min days required : " + minDaysToMakeBouquet(arr, m, k));
    }

    /**
     * Time complexity : O(n * r) here, r = (maxDays - minDays)
     * Space complexity : O(1)
     */
    private static int minDaysToMakeBouquet(int[] arr, int m , int k) {
        // check if we have enough flowers
        if (arr.length < m * k) {           // O(1)
            return -1;
        }

        // get min and max days
        int minDays = Integer.MAX_VALUE;
        int maxDays = Integer.MIN_VALUE;
        for (int i : arr) {                 // O(n)
            if (i < minDays) {
                minDays = i;
            }
            if (i > maxDays) {
                maxDays = i;
            }
        }

        // try to build bouquet every day
        for (int day = minDays; day <= maxDays; day++) {    // O((maxDays - minDays) * n)
            // attempt to build the bouquet
            int bouquetCount = makeBouquet(arr, day, k); // O(n)
            if (bouquetCount >= m) return day;
        }
        return -1;
    }

    private static int makeBouquet(int[] arr, int day, int k) {
        int curr = 0;
        int currCount = 0;
        int total = 0;
        while (curr < arr.length) {
            // check if flower has bloomed
            if (arr[curr] <= day) {
                currCount++;
                if (currCount == k) {
                    total++;
                    currCount = 0;
                }
            } else {
                currCount = 0;
            }
            curr++;
        }
        return total;
    }

    /**
     * Time complexity : O(n * log(r)) here, r = (maxDays - minDays)
     * Space complexity : O(1)
     */
    private static int minDaysToMakeBouquet1(int[] arr, int m , int k) {
        // check if we have enough flowers
        if (arr.length < (long) m * (long) k) {           // O(1)
            return -1;
        }

        // get min and max days
        int maxDays = Integer.MIN_VALUE;
        for (int i : arr) {                 // O(n)
            if (i > maxDays) {
                maxDays = i;
            }
        }

        int minDays = 1;
        // try to build bouquet every day
        while (minDays <= maxDays) {
            int day = minDays + ((maxDays - minDays) / 2);
            // attempt to make the bouquet
            int bouquetCount = makeBouquet(arr, day, k);
            if (bouquetCount >= m) {
                // move to left
                maxDays = day - 1;
            } else {
                // move to right
                minDays = day + 1;
            }
        }
        return minDays;
    }
}
