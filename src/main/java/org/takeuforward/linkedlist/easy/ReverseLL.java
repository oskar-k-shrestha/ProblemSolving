package org.takeuforward.linkedlist.easy;

/**
 * LeetCode 206: Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Notes (Concept Recap):
 * - Goal: Reverse a singly linked list in-place.
 * - Key idea: Flip each node's `next` pointer to point backward while traversing the list.
 *
 * Iterative Approach (3-pointer technique):
 * - prev = reversed part (starts as null)
 * - curr = current node (starts as head)
 * - next = temporary storage for curr.next (to avoid losing the remaining list)
 *
 * Per step:
 * 1) next = curr.next   (save forward link)
 * 2) curr.next = prev   (reverse pointer)
 * 3) prev = curr        (advance prev)
 * 4) curr = next        (advance curr)
 *
 * End:
 * - `prev` becomes the new head of the reversed list.
 *
 * Complexity:
 * - Time: O(n)  -> each node visited once
 * - Space: O(1) -> in-place reversal
 *
 * Recursive Approach:
 * - Reverse the rest of the list first, then attach current node at the end.
 * - Base case: head == null OR head.next == null
 *
 * Core pointer change:
 * - head.next.next = head   (make next node point back to head)
 * - head.next = null        (break old forward link)
 *
 * Complexity:
 * - Time: O(n)
 * - Space: O(n) due to recursion call stack
 *
 * Interview Tip:
 * - Prefer iterative in interviews because it avoids recursion stack overflow.
 */
public class ReverseLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4
        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));

        printList(head);
        Node newHead = reverseLL(head);
        printList(newHead);
        newHead = reverseLL(newHead);

        printList(newHead);
        newHead = reverseLLRecursive(newHead);
        printList(newHead);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node reverseLL(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public static Node reverseLLRecursive(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLLRecursive(head.next);

        Node front = head.next;

        front.next = head;

        head.next = null;

        return newHead;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void printList(Node head) {
        Node curr = head;
        System.out.print("List : ");
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static class Node {
        int data;
        Node next;
        public Node(int data) {this.data = data;}
        public Node(int data, Node next) {this.data = data; this.next = next;}
    }
}
