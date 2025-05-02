package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class MinimiseMaximumDistanceBetweenGasStation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println("Initial arr : " + Arrays.toString(arr));
        System.out.println("Gas stations to add : " + k);
        System.out.println("Minimum maximum distance between gas station : " + addStations(arr, k));
        System.out.println("Minimum maximum distance between gas station : " + addStations1(arr, k));
        arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        k = 1;
        System.out.println("Initial arr : " + Arrays.toString(arr));
        System.out.println("Gas stations to add : " + k);
        System.out.println("Minimum maximum distance between gas station : " + addStations(arr, k));
        System.out.println("Minimum maximum distance between gas station : " + addStations1(arr, k));
        arr = new int[]{1,7};
        k = 2;
        System.out.println("Initial arr : " + Arrays.toString(arr));
        System.out.println("Gas stations to add : " + k);
        System.out.println("Minimum maximum distance between gas station : " + addStations(arr, k));
        System.out.println("Minimum maximum distance between gas station : " + addStations1(arr, k));
    }


    /**
     * Time complexity : O(n + (k * n^2))
     * Space complexity : O(n - 1)
     */
    private static double addStations(int[] arr, int k) {
        double maxDist = Double.MIN_VALUE;
        int[] addedGas = new int[arr.length - 1];
        maxDist = maxDist(arr, addedGas);
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < arr.length; j++) {
                double segmentLength = arr[j] - arr[j - 1];
                if (segmentLength / (addedGas[j - 1] + 1) >= maxDist) {
                    // add here
                    addedGas[j - 1] += 1;
                    maxDist = maxDist(arr, addedGas);
                    break;
                }
            }
        }
        return maxDist;
    }

    private static double maxDist(int[] arr, int[] addedGas) {
        double max = Double.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            double segmentLength = arr[i] - arr[i - 1];
            if (max < (segmentLength / (addedGas[i - 1] + 1))) {
                max = (segmentLength / (addedGas[i - 1] + 1));
            }
        }
        return max;
    }

    /**
     * Time complexity : O((k * n) + n)
     * Space complexity : O(n - 1)
     */
    private static double addStations1(int[] arr, int k) {
        int[] howMany = new int[arr.length - 1];

        for (int gasStation = 1; gasStation <= k; gasStation++) {
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howMany[maxInd]++;
        }

        double maxAnswer = Double.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            double sectionLength = (diff) / (double) (howMany[i] + 1);
            if (sectionLength > maxAnswer) {
                maxAnswer = sectionLength;
            }
        }

        return maxAnswer;
    }


}
