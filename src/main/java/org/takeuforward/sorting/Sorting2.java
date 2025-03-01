package org.takeuforward.sorting;

import java.util.Arrays;

public class Sorting2 {
    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11};
        int[] temp = new int[arr1.length];
        mergeSort(arr1, 0, arr1.length - 1, temp);
        System.out.println("sorted arr: " + Arrays.toString(arr1));


        arr1 = new int[]{64, 25, 12, 22, 11};
        recursiveBubbleSort(arr1, arr1.length);
        System.out.println("sorted arr: " + Arrays.toString(arr1));

        arr1 = new int[]{64, 25, 12, 22, 11};
        recursiveInsertionSort(arr1, 1);
        System.out.println("sorted arr: " + Arrays.toString(arr1));

        arr1 = new int[]{64, 25, 12, 22, 11};
        quickSortHoarePartition(arr1, 0, arr1.length - 1);
        System.out.println("sorted arr: " + Arrays.toString(arr1));

        arr1 = new int[]{64, 25, 12, 22, 11};
        quickSortLomutoPartition(arr1, 0, arr1.length - 1);
        System.out.println("sorted arr: " + Arrays.toString(arr1));
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int curr = low;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[curr++] = arr[left++];
            } else {
                temp[curr++] = arr[right++];
            }
        }

        // dump all from left if available
        while (left <= mid) {
            temp[curr++] = arr[left++];
        }

        // dump all from right if available
        while (right <= high) {
            temp[curr++] = arr[right++];
        }

        // copy temp arr to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }

    }

    /**
     * Recurrence relation: T(n) = {2T(n/2) + n}
     * Master theorem: T(n) = aT(n/b) + ((n^k)((log(n))^p)) -> for dividing recurrence relation
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     */
    public static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        // divide left
        mergeSort(arr, low, mid, temp);
        // divide right
        mergeSort(arr, mid + 1, high, temp);

        merge(arr, low, mid, high, temp);
    }

    /**
     * Recurrence relation: T(n) = T(n-1) - n
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static void recursiveBubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        boolean isSwap = false;
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                // swap
                isSwap = true;
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        if (!isSwap) {
            return;
        }
        recursiveBubbleSort(arr, --n);
    }

    /**
     * Recurrence relation: T(n) = T(n - 1) + n
     * Time complexity: O(n^2)
     */
    public static void recursiveInsertionSort(int[] arr, int i) {
        if (i > arr.length - 1) {
            return;
        }
        int currData = arr[i];
        int curr = i;
        while (curr > 0 && currData < arr[curr - 1]) {
            // shift
            arr[curr] = arr[curr - 1];
            curr--;
        }
        // insert
        arr[curr] = currData;
        recursiveInsertionSort(arr, ++i);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int hoarePartition(int[] arr, int low, int high) {
        // int mid = (low + high) / 2;
        // here, pivot can be, [low...high-1]
        // right pivot gives infinite recursion
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    public static void quickSortHoarePartition(int[] arr, int low, int high) {
        if (low < high) {
            int partition = hoarePartition(arr, low, high);
            quickSortHoarePartition(arr, low, partition);
            quickSortHoarePartition(arr, partition + 1, high);
        }
    }

    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i , j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Time complexity: Average case O(n*log(n)), Worse case O(n^2)
     *
     */
    public static void quickSortLomutoPartition(int[] arr, int low, int high) {
        if (low < high) {
            int partition = lomutoPartition(arr, low, high);
            quickSortLomutoPartition(arr, low, partition - 1);
            quickSortLomutoPartition(arr, partition + 1, high);
        }
    }

}
