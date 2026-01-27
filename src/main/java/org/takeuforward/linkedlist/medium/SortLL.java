package org.takeuforward.linkedlist.medium;

import java.util.ArrayList;

/**
 * Sort a Singly Linked List using Merge Sort via an Auxiliary Array.
 *
 * Problem:
 * - Given a singly linked list, sort it in ascending order.
 *
 * Approach Used (Array + Merge Sort):
 * 1. Traverse the linked list and store all node values in an ArrayList.
 * 2. Apply Merge Sort on the ArrayList.
 * 3. Traverse the linked list again and overwrite node values with sorted values.
 *
 * Why this works:
 * - Merge Sort guarantees O(n log n) time complexity.
 * - Separating sorting logic from linked list manipulation keeps implementation simple.
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
 * - Reuses standard merge sort logic.
 * - Suitable for quick solutions and online assessments.
 *
 * Cons:
 * - Not optimal for linked lists.
 * - Uses extra space instead of leveraging pointer manipulation.
 *
 * Interview Note:
 * - This solution is correct but NOT optimal.
 * - Optimal solution sorts the linked list using merge sort with:
 *   - Slow/Fast pointer to split the list
 *   - In-place merge using node pointers
 *   - Space complexity O(log n) (recursion stack)
 *
 * Next Optimization:
 * - Implement merge sort directly on the linked list without using extra arrays.
 */
public class SortLL {

    public static void main(String[] args) {
        // 1 -> 3 -> 4 -> 2
        Node head = buildLL(1, 3, 4, 2);
        printLL(head);

        sortLL(head);
        printLL(head);
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
