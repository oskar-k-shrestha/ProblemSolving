package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] arr = {7, 15, 6, 3};
        int target = 8;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Target : " + target + " hour");
        System.out.println("Koko should eat banana " + banana(arr, target) + " per hour");
        System.out.println("Koko should eat banana " + banana1(arr, target) + " per hour");
        arr = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        target = 823855818;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Target : " + target + " hour");
        System.out.println("Koko should eat banana " + banana(arr, target) + " per hour");
        System.out.println("Koko should eat banana " + banana1(arr, target) + " per hour");
        arr = new int[]{1, 1, 1, 999999999};
        target = 10;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Target : " + target + " hour");
        System.out.println("Koko should eat banana " + banana(arr, target) + " per hour");
        System.out.println("Koko should eat banana " + banana1(arr, target) + " per hour");
        arr = new int[]{805306368, 805306368, 805306368};
        target = 1000000000;
        System.out.println("Initial array : " + Arrays.toString(arr));
        System.out.println("Target : " + target + " hour");
        System.out.println("Koko should eat banana " + banana(arr, target) + " per hour");
        System.out.println("Koko should eat banana " + banana1(arr, target) + " per hour");
    }

    /**
     * Time complexity : O(n * m) m is max number in given arr
     * Space complexity : O(1)
     */
    private static int banana(int[] arr, int target) {
        // find max
        int max = Integer.MIN_VALUE;
        for (int e : arr) {
            if (e > max) max = e;
        }
        int ans = 0;
        for (double i = 1; i <= max; i++) {
            long total = 0;
            for (int e : arr) {
                total += (long) (Math.ceil(e / i));
            }
            if (total <= target) {
                ans = (int) i;
                break;
            }
        }
        return ans;
    }

    /**
     * Time complexity : O(n * log(m)) m is max value in array
     * Space complexity : O(1)
     */
    private static int banana1(int[] arr, int target) {
        // find high
        int high = Integer.MIN_VALUE;
        for (int e : arr) {
            if (e > high) high = e;
        }

        int low = 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            long total = 0;
            for (int e : arr) {
                total += (long) Math.ceil((double) e / (double) mid);
            }
            if (total > target) {
                // move right
                low = mid + 1;
            } else {
                // move left, to search for smaller mid
                high = mid - 1;
            }
        }
        return low;
    }
}
