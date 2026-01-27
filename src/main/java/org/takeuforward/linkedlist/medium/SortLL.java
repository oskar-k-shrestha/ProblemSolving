package org.takeuforward.linkedlist.medium;

import java.util.ArrayList;

/**
 * LeetCode 148: Sort List
 * https://leetcode.com/problems/sort-list/
 *
 * Sort a Singly Linked List using Merge Sort.
 *
 * Problem:
 * - Given the head of a singly linked list, sort the list in ascending order.
 *
 * --------------------------------------------------------------------
 * Approach 1: Using Auxiliary Array + Merge Sort
 * --------------------------------------------------------------------
 * Steps:
 * 1. Traverse the linked list and store all node values in an ArrayList.
 * 2. Apply Merge Sort on the ArrayList.
 * 3. Traverse the linked list again and overwrite node values with sorted values.
 *
 * Why it works:
 * - Merge Sort guarantees O(n log n) time complexity.
 * - Decouples sorting logic from linked list pointer manipulation.
 *
 * Time Complexity:
 * - Copy LL to array: O(n)
 * - Merge sort array: O(n log n)
 * - Copy back to LL: O(n)
 * - Overall: O(n log n)
 *
 * Space Complexity:
 * - O(n) due to auxiliary ArrayList and temporary merge array.
 *
 * Pros:
 * - Easy to implement and reason about.
 * - Good for quick solutions and initial correctness.
 *
 * Cons:
 * - Uses extra space.
 * - Does not leverage linked list properties.
 * - NOT optimal for linked lists.
 *
 * --------------------------------------------------------------------
 * Approach 2 (Optimal): Merge Sort Directly on Linked List
 * --------------------------------------------------------------------
 * Key Idea:
 * - Linked lists are ideal for merge sort because merging can be done
 *   by rearranging pointers without extra space.
 *
 * Steps:
 * 1. Use slow/fast pointers to find the middle of the list.
 * 2. Split the list into two halves.
 * 3. Recursively sort both halves.
 * 4. Merge the two sorted halves using pointer-based merge.
 *
 * Why it works:
 * - Divide and conquer strategy ensures O(n log n) time.
 * - Merge operation is done in-place using node pointers.
 *
 * Time Complexity:
 * - O(n log n)
 *
 * Space Complexity:
 * - O(log n) due to recursion stack.
 * - No extra data structures used.
 *
 * Interview Notes:
 * - Approach 1 is acceptable but NOT optimal.
 * - Approach 2 is the expected solution in interviews.
 * - Always mention space complexity due to recursion stack.
 *
 * Key Takeaways:
 * - Prefer merge sort for linked lists over quick sort.
 * - Slow/Fast pointer technique is essential for splitting.
 * - Pointer manipulation avoids extra memory usage.
 */
public class SortLL {

    public static void main(String[] args) {
        // 1 -> 3 -> 4 -> 2
        Node head = buildLL(1, 3, 4, 2);
        printLL(head);

        sortLL(head);
        printLL(head);


        head = buildLL(1,3,4,2);
        printLL(head);
        head = sortLL1(head);
        printLL(head);

    }

    /**
     * Time complexity : O(nlog(n))
     * Space complexity : O(log(n)) due to recursion stack
     */
    public static Node sortLL1(Node head) {
        // base case
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // slow-fast pointer to identify mid
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // split list into two halves
        prev.next = null;
        Node left = head;
        Node right = slow;

        // recursive sort
        Node sortedLeft = sortLL1(left);
        Node sortedRight = sortLL1(right);

        // merge and return
        return mergeLL(sortedLeft, sortedRight);
    }

    public static Node mergeLL(Node left, Node right) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next; // move curr
        }

        // remaining left
        if (left != null) {
            curr.next = left;
        } else {
            curr.next = right;
        }

        return dummy.next;
    }

    /**
     * Time complexity : O(n + nlog(n) + n) -> O(nlog(n))
     * Space complexity : O(n)
     */
    public static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;

        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            arr.add(curr.data);
            curr = curr.next;
        }

        // sort the array
        sort(arr, 0, arr.size() - 1);

        // update LL
        curr = head;
        int index = 0;
        while (curr != null) {
            curr.data = arr.get(index++);
            curr = curr.next;
        }

        return head;
    }

    private static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr.get(left) <= arr.get(right)) {
                temp[index++] = arr.get(left++);
            } else {
                temp[index++] = arr.get(right++);
            }
        }

        // remaining left
        while (left <= mid) {
            temp[index++] = arr.get(left++);
        }

        // remaining right
        while (right <= high) {
            temp[index++] = arr.get(right++);
        }

        // copy to original
        for (int i = 0; i < temp.length; i++) {
            arr.set((low + i), temp[i]);
        }
    }

    private static void sort(ArrayList<Integer> arr, int low, int high) {
        if (low >= high) return;

        int mid = low + ((high - low) / 2);

        // divide left
        sort(arr, low, mid);
        // divide right
        sort(arr, mid + 1, high);

        merge(arr, low, mid, high);

    }
    public static Node buildLL(int... values) {
        if (values == null || values.length == 0) return null;
        Node head = new Node(values[0]);
        Node prev = head;

        for (int i = 1; i < values.length; i++) {
            Node node = new Node(values[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public static void printLL(Node head) {
        System.out.print("List : ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
