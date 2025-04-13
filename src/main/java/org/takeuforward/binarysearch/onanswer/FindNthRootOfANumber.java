package org.takeuforward.binarysearch.onanswer;

public class FindNthRootOfANumber {
    public static void main(String[] args) {
        int n = 4;
        int m = 69;
        System.out.println(n + "th root of " + m + " is : " + findNthRoot(n, m));
    }

    private static long compute(int n, long mid, int m) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result = result * mid;
            if (result > m) return 1;
        }
        if (result == m) return 0;
        return -1;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static long findNthRoot(int n, int m) {
        long low = 0;
        long high = m;

        while (low <= high) {
            long mid = low + ((high - low) / 2);
            long value = compute(n, mid, m);
            if (value == 0) return mid;
            if (value == 1) {
                // move left
                high = mid - 1;
            } else {
                // move right
                low = mid + 1;
            }
        }
        return -1;
    }
}
