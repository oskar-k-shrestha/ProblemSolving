package org.takeuforward.question.easy;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Distinct integer array size: " + removeDuplicate1(arr));
        System.out.println("Array after removing duplicate : " + Arrays.toString(arr));

        arr = new int[]{1,1,2,3,4,5};
        System.out.println("Input arr : " + Arrays.toString(arr));
        System.out.println("Distinct integer array size: " + removeDuplicate2(arr));
        System.out.println("Array after removing duplicate : " + Arrays.toString(arr));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public static int removeDuplicate(int[] arr) {
        if (arr.length == 1) return 1;
        HashSet<Integer> distinctIntegers = new HashSet<>();
        int curr = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!distinctIntegers.contains(arr[i])) {
                distinctIntegers.add(arr[i]);
                curr++;
                arr[curr] = arr[i];
            }
        }
        return curr + 1;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static int removeDuplicate1(int[] nums) {
        int curr = -1;
        int prevElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prevElement != nums[i]) {
                nums[++curr] = prevElement;
                prevElement = nums[i];
            }
        }
        // insert remaining prevElement
        nums[++curr] = prevElement;
        return curr + 1;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static int removeDuplicate2(int[] nums) {
        if (nums.length == 0) return 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[curr++] = nums[i];
            }
        }
        return curr;
    }

}
