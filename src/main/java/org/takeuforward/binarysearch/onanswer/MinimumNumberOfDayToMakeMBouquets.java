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
        System.out.println("Min days required : " + minDaysToMakeBouquet(arr, m, k));
        arr = new int[]{7,7,7,7,12,7,7};
        m = 2;
        k = 3;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Number of bouquets : " + m);
        System.out.println("Number of adjacent flower in a bouquet : " + k);
        System.out.println("Min days required : " + minDaysToMakeBouquet(arr, m, k));
        arr = new int[]{1000000000,1000000000};
        m = 1;
        k = 1;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Number of bouquets : " + m);
        System.out.println("Number of adjacent flower in a bouquet : " + k);
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
            // bloom the flowers
            for (int flower = 0; flower < arr.length; flower++) {   // O(n)
                if (arr[flower] == day) {
                    arr[flower] = 0;
                }
            }
            // attempt to build the bouquet
            int bouquetCount = makeBouquet(arr, k); // O(n)
            if (bouquetCount >= m) return day;
        }
        return -1;
    }

    private static int makeBouquet(int[] arr, int k) {
        int curr = 0;
        int currCount = 0;
        int total = 0;
        while (curr < arr.length) {
            if (arr[curr] == 0) {
                currCount++;
            } else {
                currCount = 0;
            }
            if (currCount == k) {
                total++;
                currCount = 0;
            }
            curr++;
        }
        return total;
    }
}
