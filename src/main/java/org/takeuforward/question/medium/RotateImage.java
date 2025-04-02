package org.takeuforward.question.medium;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Initial matrix : ");
        printMatrix(matrix);
        System.out.println("Rotate matrix : ");
        printMatrix(rotateImage(matrix));
    }

    /**
     * Time complexity : O(m * n)
     * Space complexity : O(m * n)
     */
    private static int[][] rotateImage(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int row = 0, columnR = n - 1; row < n && columnR >= 0; row++, columnR--) {
            for (int column = 0, rowR = 0; column < n && rowR < n; column++, rowR++) {
                result[rowR][columnR] = matrix[row][column];
            }
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
