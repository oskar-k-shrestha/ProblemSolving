package org.takeuforward.question.easy;


public class LongestSubArrayWithGivenSumK {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("Number of all possible subsets : " + numberOfAllPossibleCombination(arr));
        System.out.println("LongestSubArrayWithGivenSumK : " + longestSubArrayWithGivenSumK(arr, 2));
        System.out.println("LongestSubArrayWithGivenSumK1 : " + longestSubArrayWithGivenSumK1(arr, 2));
    }

    /**
     * Time complexity : O(n^3)
     * Space complexity : O(1)
     */
    private static int longestSubArrayWithGivenSumK(int[] arr, int K) {
        int maxLength = 0;
        for (int i = 0  ; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // sum i..j
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == K) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    /**
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     */
    private static int longestSubArrayWithGivenSumK1(int[] arr, int K) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            // sum arr[i...j]
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == K) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private static int numberOfAllPossibleCombination(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i++) {
            sum += numberOfCombination(arr, i);
        }
        return sum;
    }
    private static int numberOfCombination(int[] arr, int k) {
        return calculateFactorial(arr.length) / (calculateFactorial(k) * calculateFactorial(arr.length - k));
    }

    private static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }


}
