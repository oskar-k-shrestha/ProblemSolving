package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = {4,2,1,3,6};
        int cows = 2;
        System.out.println("Initial stall : " + Arrays.toString(stalls));
        System.out.println("Aggressive cows : " + cows);
        System.out.println("Minimum distance : " + minDistance(stalls, cows));
        System.out.println("Minimum distance : " + minDistance1(stalls, cows));
        System.out.println("Minimum distance : " + minDistance2(stalls, cows));
        stalls = new int[]{0,3,4,7,10,9};
        cows = 4;
        System.out.println("Initial stall : " + Arrays.toString(stalls));
        System.out.println("Aggressive cows : " + cows);
        System.out.println("Minimum distance : " + minDistance(stalls, cows));
        System.out.println("Minimum distance : " + minDistance1(stalls, cows));
        System.out.println("Minimum distance : " + minDistance2(stalls, cows));

    }


    /**
     * Time complexity : O((r * n) + (n * log(n))) here, r = (1...(maxPosition - minPosition + 1))
     * Space complexity : O(1)
     */
    private static int minDistance(int[] stalls, int cows) {
        // sort the stalls
        Arrays.sort(stalls);  // O(n * log(n))

        for (int minDistance = 1; minDistance <= stalls[stalls.length -1] - stalls[0] + 1; minDistance++) {     // O(r * n) here, r = (1..(maxPosition - minPosition + 1))
            int lastPosition = stalls[0];
            int cowsLeft = cows - 1;
            for (int i = 1; i < stalls.length; i++) {       // O(n)
                if (stalls[i] - lastPosition >= minDistance) {
                    // place the cow
                    cowsLeft--;
                    lastPosition = stalls[i];
                }
                if (cowsLeft == 0) {
                    break;
                }
            }
            if (cowsLeft != 0) {
                return minDistance - 1;
            }
        }
        return -1;
    }

    /**
     * Time complexity : O((n * log(n)) + O(r * n)) here, r = 1...(stalls[max] - stalls[min])
     * Space complexity : O(1)
     */
    private static int minDistance1(int[] stalls, int cows) {
        // sort the stalls
        Arrays.sort(stalls);

        int limit = stalls[stalls.length - 1] - stalls[0];
        for (int minDistance = 1; minDistance <= limit; minDistance++) {    // O(n * r) here, r = 1..(stalls[max] - stalls[min])
            if (!canWePlaceTheCow(stalls, cows, minDistance)) {     // O(n)
                return minDistance - 1;
            }
        }
        return limit;
    }

    /**
     * Time complexity : O((n * log(n)) + (n * log(r))) here, r = 1...(stalls[max] - stalls[min])
     * Space complexity : O(1)
     */
    private static int minDistance2(int[] stalls, int cows) {
        // sort the stalls
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        while (low <= high) {
            int minDistance = low + ((high - low) / 2);
            if (canWePlaceTheCow(stalls, cows, minDistance)) {
                // move right
                low = minDistance + 1;
            } else {
                high = minDistance - 1;
            }
        }
        return high;
    }

    private static boolean canWePlaceTheCow(int[] stalls, int cows, int minDistance) {
        int lastPosition = stalls[0];
        int cowsCount = 1;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDistance) {
                // place a cow
                cowsCount++;
                lastPosition = stalls[i];
            }
            if (cowsCount >= cows) return true;
        }
        return false;
    }


}
