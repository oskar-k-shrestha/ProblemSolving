package org.takeuforward.linkedlist.medium;

/**
 * LeetCode 328: Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * Notes (Concept Recap):
 * Goal:
 * - Rearrange the linked list so that all nodes at odd indices come first,
 *   followed by nodes at even indices.
 * - Indexing is 1-based:
 *   1st node -> odd, 2nd node -> even, 3rd -> odd, etc.
 *
 * Example:
 * Input :  1 -> 2 -> 3 -> 4 -> 5
 * Output:  1 -> 3 -> 5 -> 2 -> 4
 *
 * Key Idea:
 * - Build two linked chains while traversing:
 *   odd chain:  head, head.next.next, ...
 *   even chain: head.next, head.next.next.next, ...
 *
 * Pointers:
 * - odd      -> current tail of odd chain
 * - even     -> current tail of even chain
 * - evenHead -> starting node of even chain (needed at the end)
 *
 * Steps in loop:
 * 1) odd.next  = even.next   (link odd to next odd)
 * 2) odd       = odd.next    (move odd forward)
 * 3) even.next = odd.next    (link even to next even)
 * 4) even      = even.next   (move even forward)
 *
 * Final step:
 * - odd.next = evenHead (append even list after odd list)
 *
 * Complexity:
 * - Time: O(n)  -> each node visited once
 * - Space: O(1) -> in-place pointer manipulation
 *
 * Common pitfalls:
 * - Losing the even list head (always store evenHead first)
 * - Using incorrect loop condition (best: while (even != null && even.next != null))
 */
public class OddEvenLL {
    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = buildLL(1,2,3,4,5);
        printLL(head);
        head = oddEvenLL(head);
        printLL(head);
    }

    public static Node oddEvenLL(Node head) {
        if (head == null || head.next == null) return head;

        Node evenHead = head.next;

        Node odd = head;
        Node even = evenHead;
        Node prevOdd = null;

        while ((odd != null && odd.next != null) || (even != null && even.next != null)) {
            // build odd
            if ((odd != null && odd.next != null)) {
                odd.next = odd.next.next;
                prevOdd = odd;
                odd = odd.next;
            }
            // build even
            if ((even != null && even.next != null)) {
                even.next = even.next.next;
                even = even.next;
            }
        }

        if (odd == null) {
            prevOdd.next = evenHead;
        } else {
            odd.next = evenHead;
        }
        return head;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void printLL(Node head) {
        System.out.println("List :");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
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

    public static class Node {
        int data;
        Node next;
        public Node(int data) {this.data = data;};
        public Node(int data, Node next) {this.data = data; this.next = next;}
    }
}
