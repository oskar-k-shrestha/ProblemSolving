package org.takeuforward.linkedlist.medium;

/**
 * LeetCode 19: Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Notes (Concept Recap):
 * - Goal: Remove the nth node from the end of a singly linked list and return the new head.
 *
 * Approach 1 (2-pass: Length Counting):
 * - Pass 1: Count total size of the list.
 * - Pass 2: Find the (size - n)th node (node before the target) and skip the target node.
 * - Edge case: If (size - n) == 0, delete the head.
 *
 * Complexity:
 * - Time: O(n) (2 traversals, still linear)
 * - Space: O(1)
 *
 * Approach 2 (Optimal 1-pass: Two Pointers + Dummy Node):
 * - Use a dummy node before head to simplify head deletion.
 * - Move 'fast' pointer n steps ahead.
 * - Move 'slow' and 'fast' together until fast.next == null.
 * - Now slow is just before the node to delete.
 * - Delete by: slow.next = slow.next.next
 *
 * Why Dummy Node?
 * - Avoids special-case handling when deleting the head node.
 *
 * Complexity:
 * - Time: O(n) (single pass)
 * - Space: O(1)
 *
 * Common Interview Pitfalls:
 * - Off-by-one mistakes when moving fast pointer.
 * - Not handling "remove head" properly (dummy node solves this cleanly).
 * - Forgetting to return the correct head (return dummy.next).
 */
public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        int n = 5;
        Node head = buildLL(1, 2, 3, 4, 5);

        printLL(head);
        head = remove(head, n);
        printLL(head);

        head = buildLL(1, 2, 3, 4, 5);
        printLL(head);
        head = remove1(head, n);
        printLL(head);

    }

    /**
     * Time complexity : O(n) 2-pass
     * Space complexity : O(1)
     */
    public static Node remove(Node head, int n) {
        if (head == null || (head.next == null && n == 1)) return null;

        Node curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int i = size - n; // pos to skip next node

        if (i == 0) { // handle head removal
            head = head.next;
            return head;
        }

        int count = 0;
        curr = head;
        while (curr != null) {
            count++;
            if (i == count) {
                if (curr.next != null && curr.next.next != null) {
                    curr.next = curr.next.next;
                } else  {
                    curr.next = null;
                }
            }
            curr = curr.next;
        }

        return head;
    }

    /**
     * Time complexity : O(n) 1 pass
     * Space complexity : O(1)
     */
    public static Node remove1(Node head, int n) {
        Node dummy = new Node(0, head);
        Node slow = dummy;
        Node fast = dummy;

        // move fast n nodes ahead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // move slow and fast until fast reach end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // delete node
        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
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
    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
    */
    public static void printLL(Node head) {
        System.out.print("List : ");
        while (head != null) {
            System.out.print(head.data + (head.next != null ? "->" : ""));
            head = head.next;
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
