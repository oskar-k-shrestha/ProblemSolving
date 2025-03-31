package org.takeuforward.question.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence1(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence2(arr));

        arr = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence1(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence2(arr));

        arr = new int[]{1, 0, 1, 2};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence1(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence2(arr));

        arr = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence1(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence2(arr));

        arr = new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence1(arr));
        System.out.println("Longest consecutive sequence : " + longestConsecutiveSequence2(arr));
    }

    /**
     * Time complexity : O(n * log(n))
     * Space complexity : O(log(n))
     */
    private static int longestConsecutiveSequence(int[] arr) {
        if (arr.length == 0) return 0;
        int count = 1;
        int maxCount = 1;

        Arrays.sort(arr); // O(n * log(n))

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1 || arr[i] == arr[i + 1]) {
                if (arr[i] != arr[i + 1]) {
                    count++;
                    maxCount = Math.max(count, maxCount);
                }
            } else {
                count = 1;
            }
        }
        return maxCount;
    }

    /**
     * Time complexity : O(n) average -> O(n^2) worst case due to hash collisions
     * Space complexity : O(n)
     */
    private static int longestConsecutiveSequence1(int[] arr) {
        if (arr.length == 0) return 0;
        int longest = 1;

        HashSet<Integer> integers = new HashSet<>();
        for (int i : arr) {
            integers.add(i);
        }

        for (int i : integers) {
            if (!integers.contains(i - 1)) {
                int count = 1;
                while (integers.contains(i + 1)) {
                    count++;
                    i += 1;
                }
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }


    /**
     * Time complexity : O(3n) 3 pass
     * Space complexity : O(range)
     */
    private static int longestConsecutiveSequence2(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i : arr) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }

        int range = max - min + 1;
        boolean[] isObserved = new boolean[range];

        for (int i : arr) {
            int index = i - min;
            isObserved[index] = true;
        }

        int count = 0;
        int longest = 0;

        for (boolean _isObserved : isObserved) {
            if (_isObserved) {
                count++;
            } else {
                longest = Math.max(count, longest);
                count = 0;
            }
        }

        return Math.max(count, longest);
    }

}
