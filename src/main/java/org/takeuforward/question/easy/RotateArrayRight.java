package org.takeuforward.question.easy;

import java.util.Arrays;

public class RotateArrayRight {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int k = 8;
        System.out.println("Input arr : " + Arrays.toString(arr));
        rotate(arr, k);
        System.out.println("After " + k + " rotation : " + Arrays.toString(arr));

        arr = new int[]{64, 25, 12, 22, 11};
        k = 8;
        System.out.println("Input arr : " + Arrays.toString(arr));
        arr = rotate1(arr, k);
        System.out.println("After " + k + " rotation : " + Arrays.toString(arr));

        arr = new int[]{64, 25, 12, 22, 11};
        k = 8;
        System.out.println("Input arr : " + Arrays.toString(arr));
        rotate2(arr, k);
        System.out.println("After " + k + " rotation : " + Arrays.toString(arr));

        arr = new int[]{64, 25, 12, 22, 11};
        System.out.println("Input arr : " + Arrays.toString(arr));
        k = 8;
        rotate3(arr, k);
        System.out.println("After " + k + " rotation : " + Arrays.toString(arr));
    }

    /**
     * Time complexity : O (k * n)
     * Space complexity : O (1)
     */
    public static void rotate(int[] arr, int k) {
        for (int rotate = 0; rotate < k; rotate++) {
            int l = arr[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i];
                arr[i] = l;
                l = temp;
            }
        }
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public static int[] rotate1(int[] arr, int k) {
        int[] results = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int rotate = (i + k) % arr.length;
            results[rotate] = arr[i];
        }
        return results;
    }

    /**
     * Step 1 : Reverse the array
     * Step 2 : Compute mid-pointer for partition
     * Step 3 : Reverse two half of the array around partition point
     * Note: It requires double pass
     * Time complexity : O(n)
     * Space complexity : O(1)`
     */
    public static void rotate2(int[] nums, int k) {
        // reverse the array
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            // swap
            swap(nums, start++, end--);
        }

        // partition at k and reverse each side
        start = 0;
        int mid = (k % nums.length) - 1;
        end = nums.length - 1;

        // reverse first half
        while (start < mid) {
            // swap
            swap(nums, start++, mid--);
        }

        mid = (k % nums.length);
        // reverse send half
        while (mid < end) {
            // swap
            swap(nums, mid++, end--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void rotate3(int[] arr, int k) {
        // handle case when k > arr.length, minimized redundant cycles
        k = k % arr.length;
        // determine number of independent cycles
        int n = gcd(arr.length, k);

        // for each cycle, juggle
        for (int i = 0; i < n; i++) {
            int curr = i;
            int prev = arr[curr];
            do {
                int next = (curr + k) % arr.length;
                int temp = arr[next];
                arr[next] = prev;
                curr = next;
                prev = temp;
            } while (curr != i);
        }
    }

    /**
     * Time complexity : O(log(min(a,b))
     * Space complexity : O(1)
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // when b becomes 0, a is the GCD
    }

}
