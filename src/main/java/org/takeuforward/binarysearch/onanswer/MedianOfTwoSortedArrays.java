package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // hint to GC

        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5};
        System.out.println("Initial arr1 : " + Arrays.toString(arr1));
        System.out.println("Initial arr2 : " + Arrays.toString(arr2));
        System.out.println("Median value : " + median(arr1, arr2));
        System.out.println("Median value : " + median1(arr1, arr2));
        System.out.println("Median value : " + median2(arr1, arr2));

        arr1 = new int[]{1, 2};
        arr2 = new int[]{3, 4};
        System.out.println("Initial arr1 : " + Arrays.toString(arr1));
        System.out.println("Initial arr2 : " + Arrays.toString(arr2));
        System.out.println("Median value : " + median(arr1, arr2));
        System.out.println("Median value : " + median1(arr1, arr2));
        System.out.println("Median value : " + median2(arr1, arr2));

        arr1 = new int[]{2};
        arr2 = new int[]{};
        System.out.println("Initial arr1 : " + Arrays.toString(arr1));
        System.out.println("Initial arr2 : " + Arrays.toString(arr2));
        System.out.println("Median value : " + median(arr1, arr2));
        System.out.println("Median value : " + median1(arr1, arr2));
        System.out.println("Median value : " + median2(arr1, arr2));

        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        long timeElapsed = endTime - startTime;
        long memoryUsed = endMemory - startMemory;

        System.out.println("Execution Time: " + (timeElapsed / 1_000_000.0) + " ms");
        System.out.println("Memory Used: " + (memoryUsed / 1024.0 / 1024.0) + " MB");
    }

    /**
     * Time complexity : O (m + n)
     * Space complexity : O(m + n)
     */
    private static double median(int[] arr1, int[] arr2) {
        // merge
        int[] merged = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;
        int curr = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                // arr1 has smaller element
                merged[curr] = arr1[index1];
                index1++;
            } else {
                // arr2 has smaller element
                merged[curr] = arr2[index2];
                index2++;
            }
            curr++;
        }

        // copy all from arr1 if arr2 exhausted
        while (index1 < arr1.length) {
            merged[curr++] = arr1[index1++];
        }

        // copy all from arr2 if arr1 exhausted
        while (index2 < arr2.length) {
            merged[curr++] = arr2[index2++];
        }

        int n = merged.length;
        if (n % 2 == 0) {
            return (merged[(n / 2) - 1] + merged[n / 2]) / 2.0;
        } else {
            return merged[n / 2];
        }
    }

    /**
     * Time complexity : O(m + n)
     * Space complexity : O(1)
     */
    private static double median1(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;

        int indexArr1 = 0;
        int indexArr2 = 0;

        int index1 = (n / 2) - 1;
        int index2 = n / 2;
        int index1Element = -1;
        int index2Element = -1;

        int curr = 0;
        while (indexArr1 < arr1.length && indexArr2 < arr2.length) {
            if (arr1[indexArr1] <= arr2[indexArr2]) {
                if (curr == index1) {
                    index1Element = arr1[indexArr1];
                } else if (curr == index2) {
                    index2Element = arr1[indexArr1];
                }
                curr++;
                indexArr1++;
            } else {
                if (curr == index1) {
                    index1Element = arr2[indexArr2];
                } else if (curr == index2) {
                    index2Element = arr2[indexArr2];
                }
                curr++;
                indexArr2++;
            }
        }

        // check if arr1 is not exhausted
        while (indexArr1 < arr1.length) {
            if (curr == index1) {
                index1Element = arr1[indexArr1];
            } else if (curr == index2) {
                index2Element = arr1[indexArr1];
            }
            curr++;
            indexArr1++;
        }

        // check if arr2 is not exhausted
        while (indexArr2 < arr2.length) {
            if (curr == index1) {
                index1Element = arr2[indexArr2];
            } else if (curr == index2) {
                index2Element = arr2[indexArr2];
            }
            curr++;
            indexArr2++;
        }

        if (n % 2 == 1) {
            return index2Element;
        }

        return (index1Element + index2Element) / 2.0;
    }

    /**
     * Time complexity : O(log(min(n1,n2))
     * Space complexity : O(1)
     */
    private static double median2(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        // swap array if arr1 is larger
        if (n1 > n2) return median2(arr2, arr1);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // length of left half

        int low = 0;
        int high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            // calculate l1, l2, r1, r2
            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
}
