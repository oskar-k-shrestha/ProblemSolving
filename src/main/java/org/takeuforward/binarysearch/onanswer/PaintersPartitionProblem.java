package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;
        System.out.println("Boards to paint : " + Arrays.toString(boards));
        System.out.println("Painters to use : " + painters);
        System.out.println(painters + " painters can complete the work with " + assign(boards, painters) + " max length assigned");
        System.out.println(painters + " painters can complete the work with " + assign1(boards, painters) + " max length assigned");
        boards = new int[]{5, 5, 5, 5};
        painters = 2;
        System.out.println("Boards to paint : " + Arrays.toString(boards));
        System.out.println("Painters to use : " + painters);
        System.out.println(painters + " painters can complete the work with " + assign(boards, painters) + " max length assigned");
        System.out.println(painters + " painters can complete the work with " + assign1(boards, painters) + " max length assigned");
    }

    /**
     * Time complexity : O(n + (n * r)) here, r = sum(boards) - boards[max]
     * Space complexity : O(1)
     */
    private static int assign(int[] boards, int painters) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int boardLength : boards) {
            if (low < boardLength) {
                low = boardLength;
            }
            high += boardLength;
        }

        for (int maxLengthLimit = low; maxLengthLimit <= high; maxLengthLimit++) {
            if (countRequiredPainter(boards, painters, maxLengthLimit) == painters) return maxLengthLimit;
        }

        return -1;
    }

    private static int countRequiredPainter(int[] boards, int painters, int maxLengthLimit) {
        int painter = 1;
        int boardLengthAllocated = boards[0];
        for (int i = 1; i < boards.length; i++) {
            if (boardLengthAllocated + boards[i] <= maxLengthLimit) {
                // allocate the board
                boardLengthAllocated += boards[i];
            } else {
                painter++;
                boardLengthAllocated = boards[i];
            }
        }
        return painter;
    }

    /**
     * Time complexity : O(n + (log(r) * n)) here, r = sum(boards) - boards[max]
     * Space complexity : O(1)
     */
    private static int assign1(int[] boards, int painters) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int boardLength : boards) {
            if (low < boardLength) {
                low = boardLength;
            }
            high += boardLength;
        }

        while (low <= high) {
            int maxLengthLimit = low + ((high - low) / 2);
            if (canPaintersBeAssigned(boards, painters, maxLengthLimit)) {
                // move left for lesser limit
                high = maxLengthLimit - 1;
            } else {
                low = maxLengthLimit + 1;
            }
        }

        return low;
    }

    private static boolean canPaintersBeAssigned(int[] boards, int painters, int maxLengthLimit) {
        int painter = 1;
        int allocatedLength = boards[0];
        for (int i = 1; i < boards.length; i++) {
            if (allocatedLength + boards[i] <= maxLengthLimit) {
                allocatedLength += boards[i];
            } else {
                // new painter
                painter++;
                allocatedLength = boards[i];
            }
            if (painter > painters) return false;
        }
        return true;
    }
}
