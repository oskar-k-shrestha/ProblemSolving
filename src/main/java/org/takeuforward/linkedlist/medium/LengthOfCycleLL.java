package org.takeuforward.linkedlist.medium;

/**
 * LeetCode (Related): 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Additional Problem: Find the Length of Cycle in Linked List
 *
 * Notes (Concept Recap):
 * - Goal: If a singly linked list contains a cycle, return the length of the cycle.
 * - If no cycle exists, return 0.
 *
 * Key Idea:
 * - Use Floyd’s Cycle Detection Algorithm (Tortoise & Hare) to detect a cycle in O(n) time and O(1) space.
 *
 * Floyd’s Algorithm:
 * - slow moves 1 step at a time
 * - fast moves 2 steps at a time
 *
 * If the list has a cycle:
 * - slow and fast will eventually meet at some node INSIDE the cycle.
 *
 * Finding Cycle Length (after slow == fast):
 * - We are guaranteed to be inside the loop.
 * - Keep one pointer fixed at the meeting node.
 * - Move the other pointer one step at a time until it returns to the meeting node.
 * - Count the steps → this count is the cycle length.
 *
 * Example:
 * 1 -> 2 -> 3 -> 4
 *      ^         |
 *      |_________|
 *
 * Cycle: 2 -> 3 -> 4 -> 2
 * Length = 3
 *
 * Complexity:
 * - Time: O(n)     (cycle detection + loop traversal <= n steps)
 * - Space: O(1)    (no extra memory used)
 *
 * Common pitfalls:
 * - Forgetting to return 0 when there is no cycle.
 * - Counting incorrectly (always start length = 1 after moving one step inside the cycle).
 */
public class LengthOfCycleLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        Node secondNode = new Node(2);
        head.next = secondNode;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = secondNode;

        System.out.println("Length of cycle : " + lengthOfCycle(head));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static int lengthOfCycle(Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // cycle exists
                slow = slow.next;
                int length = 1;
                while (slow != fast) {
                    slow = slow.next;
                    length++;
                }
                return length;
            }
        }
        return 0;
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
