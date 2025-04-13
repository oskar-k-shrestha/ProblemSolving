package org.takeuforward.binarysearch.onanswer;

public class FindSquareRootOfANumber {

    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println("Number : " + n);
        System.out.println("Square root : " + getSquare(n));
        System.out.println("Square root : " + getSquare1(n));
        System.out.println("Square root : " + getSquare2(n));
    }

    /**
     * Time complexity : O(1)
     * In Java, Math.sqrt() typically uses very efficient hardware-level instructions or optimized numerical methods
     * like the Newton-Raphson method. These methods converge extremely quickly (in logarithmic time) or are close to
     * constant time because modern CPUs have native support for square root operations.
     */
    private static int getSquare(int n) {
        return (int) Math.sqrt(n);
    }

    /**
     * Time complexity : O(n^(1/2))
     * Space complexity : O(1)
     */
    private static long getSquare1(int n) {
        long ans = 0;
        long curr = 1;
        while (curr * curr <= n) {
            if (curr * curr == n) return curr;
            ans = curr++;
        }
        return ans;
    }

    /**
     * Time complexity : O(log(n))
     * Space complexity : O(1)
     */
    private static long getSquare2(int n) {
        long low = 0;
        long high = n;

        while (low <= high) {
            long mid = low + ((high - low) / 2);
            if (mid * mid == n) return mid;
            if (mid * mid > n) {
                // move left
                high = mid - 1;
            } else {
                // move right
                low = mid + 1;
            }
        }
        return high;
    }


}
