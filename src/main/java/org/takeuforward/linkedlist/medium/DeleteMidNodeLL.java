package org.takeuforward.linkedlist.medium;

/**
 * LeetCode 2095: Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * Notes (Concept Recap):
 * - Goal: Delete the middle node of a singly linked list and return the head.
 * - Middle definition:
 *   - For even length, delete the ⌊n/2⌋-th node (0-based index).
 *
 * Key Idea:
 * - Use the "Tortoise and Hare" (slow & fast pointers) technique.
 * - Maintain `slow` one node *before* the middle so deletion is easy.
 *
 * Why Dummy Node?
 * - Allows `slow` to start one step behind head.
 * - Eliminates special handling for deleting the actual head node.
 *
 * Pointer Setup:
 * - dummy -> head
 * - slow  -> dummy
 * - fast  -> head
 *
 * Traversal Logic:
 * - slow moves 1 step
 * - fast moves 2 steps
 * - When fast reaches the end, slow.next points to the middle node
 *
 * Deletion:
 * - Skip the middle node by:
 *   slow.next = slow.next.next
 *
 * Edge Cases:
 * - Empty list → return null
 * - Single node → return null (middle deletion removes the only node)
 *
 * Complexity:
 * - Time: O(n)  (single traversal)
 * - Space: O(1) (in-place modification)
 *
 * Common Pitfalls:
 * - Not handling single-node lists.
 * - Starting slow at head instead of before head (dummy avoids this).
 * - Off-by-one errors when using fast/slow pointers.
 */
public class DeleteMidNodeLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4
        Node head = buildLL(1,2,3,4);
        printLL(head);

        head = delete(head);
        printLL(head);
    }

    public static Node delete(Node head) {
        if (head == null || head.next == null) return null;

        Node dummy = new Node(0, head);
        Node slow = dummy;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip slow.next
        slow.next = slow.next.next;
        return dummy.next;
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
