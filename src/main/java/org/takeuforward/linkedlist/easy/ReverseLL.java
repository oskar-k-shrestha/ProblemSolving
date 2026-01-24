package org.takeuforward.linkedlist.easy;

/**
 * LeetCode 206: Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Notes (Concept Recap):
 * - Goal: Reverse a singly linked list in-place.
 * - Key idea: While traversing the list, we "flip" each node's next pointer to point backward.
 *
 * Approach (Iterative 3-pointer technique):
 * - prev -> points to the already reversed portion (initially null)
 * - curr -> points to the current node being processed (starts at head)
 * - next -> temporarily stores curr.next so we don’t lose the remaining list
 *
 * Steps per node:
 * 1) next = curr.next      (save forward link)
 * 2) curr.next = prev      (reverse pointer)
 * 3) prev = curr           (move prev forward)
 * 4) curr = next           (move curr forward)
 *
 * At the end:
 * - prev becomes the new head of the reversed list.
 *
 * Why it works:
 * - We reverse one link at a time while preserving access to the rest of the list via `next`.
 *
 * Complexity:
 * - Time: O(n)  -> visit every node once
 * - Space: O(1) -> reversal happens in-place (no extra data structures)
 *
 * Common pitfalls:
 * - Forgetting to store `next` before breaking the original link.
 * - Returning `head` instead of `prev` at the end.
 */
public class ReverseLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4
        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));

        printList(head);
        Node newHead = reverseLL(head);
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
