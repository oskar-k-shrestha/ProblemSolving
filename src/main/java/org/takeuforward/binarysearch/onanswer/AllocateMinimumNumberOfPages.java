package org.takeuforward.binarysearch.onanswer;

import java.util.Arrays;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int m = 2;
        System.out.println("Initial arr : " + Arrays.toString(books));
        System.out.println("Number of students : " + m);
        System.out.println("Minimum maximum page a student gets : " + minNumberOfPage(books, m));
        books = new int[]{25, 46, 28, 49, 24};
        m = 4;
        System.out.println("Initial arr : " + Arrays.toString(books));
        System.out.println("Number of students : " + m);
        System.out.println("Minimum maximum page a student gets : " + minNumberOfPage(books, m));
    }

    /**
     * Time complexity : O(n * r) here, r = sum(books) - books[max]
     * Space complexity : O(1)
     * Trick : Identify your probable answer range.
     * 1) For a given set of books, what is the minimum page distribution?
     * -> minimum answer when we give n books of the array to n students
     * 2) For a given set of books, what is the maximum page distribution?
     * -> maximum answer when we give n books of the array to a single student
     * Range : books[max] -> sum(books)
     */
    private static int minNumberOfPage(int[] books, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int pages : books) {
            if (low < pages) {
                low = pages;
            }
            high += pages;
        }
        System.out.println("min possible pages : " + low);
        System.out.println("max possible pages : " + high);

        for (int limit = low; limit <= high; limit++) {
            if (canAllocate(books, m, limit)) return limit;
        }
        return -1;
    }

    private static boolean canAllocate(int[] books, int m, int limit) {
        int studentsAllocated = 1;
        int pagesAllocated = books[0];
        for (int i = 1; i < books.length; i++) {
            if (pagesAllocated + books[i] <= limit) {
                // allocate to student
                pagesAllocated += books[i];
            } else {
                // give to next student
                studentsAllocated++;
                pagesAllocated = books[i];
            }
            if (studentsAllocated > m) return false;
        }
        return studentsAllocated == m;
    }

}
