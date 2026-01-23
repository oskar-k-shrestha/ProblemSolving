package org.takeuforward.linkedlist.easy;

/**
 * LeetCode 876: Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list
 *
 * Problem:
 * Given the head of a singly linked list, return the middle node.
 * If there are 2 middle nodes (even length list), return the 2nd middle node.
 *
 * Key Interview Approach (Optimal):
 * Tortoise & Hare (Slow/Fast Pointer Technique)
 *
 * Concept:
 * - slow moves 1 step at a time
 * - fast moves 2 steps at a time
 * When fast reaches the end, slow will be at the middle.
 *
 * Why it works:
 * fast moves twice as quickly as slow.
 * So by the time fast traverses the entire list,
 * slow has traversed half → which is the middle.
 *
 * Even-length behavior:
 * Example: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * slow ends at 4 (2nd middle), which matches LeetCode requirement.
 *
 * Complexity:
 * Time: O(n)   (single traversal)
 * Space: O(1)  (no extra data structures)
 *
 * Notes:
 * - This is the most common interview solution for "find middle of LL".
 * - Avoid 2-pass counting solution unless asked (still O(n), but less elegant).
 * - This pattern is also used in cycle detection (Floyd's algorithm).
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        printList(head);
        Node middleNode = middleNode(head);
        System.out.println("Mid node : " + middleNode.data);

        printList(head);
        middleNode = middleNode1(head);
        System.out.println("Mid node : " + middleNode.data);

        printList(head);
        middleNode = middleNode2(head);
        System.out.println("Mid node : " + middleNode.data);

    }

    /**
     * Time complexity : O(n) 2-pass
     * Space complexity : O(1)
     */
    public static Node middleNode(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node curr = head;
        int total = 0;
        while (curr != null) {
            total++;
            curr = curr.next;
        }

        int middleNodeIndex = (int) Math.ceil((float) (total - 1) / 2);
        int i = 0;
        curr = head;
        while (i != middleNodeIndex && curr != null) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    /**
     * Time complexity : O(n) 1-pass
     * Space complexity : O(1)
     */
    public static Node middleNode1(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node curr = head;
        Node mid = head;
        int midI = 0;
        int total = 0;

        while (curr != null) {
            total++;

            int newMidI = total / 2;
            if (midI != newMidI) {
                mid = mid.next;
                midI = newMidI;
            }
            curr = curr.next;
        }
        return mid;
    }

    public static Node middleNode2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {this.data = data;}

        public Node(int data, Node next) {this.data = data; this.next = next;}

    }
}
