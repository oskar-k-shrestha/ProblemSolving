package org.takeuforward.linkedlist.easy;

import java.util.HashSet;

/**
 * LeetCode 141: Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Notes (Concept Recap):
 * - Goal: Detect if a singly linked list contains a cycle.
 * - A cycle exists if we can reach a previously visited node again while traversing.
 *
 * Approach 1: HashSet (Visited Nodes)
 * - Store each visited node reference in a HashSet.
 * - If the same node reference appears again -> cycle detected.
 * - Time: O(n)
 * - Space: O(n)
 * - Note: Works only when HashSet tracks node references (identity), not node values.
 *
 * Approach 2: Floyd’s Cycle Detection (Tortoise & Hare)
 * - Use two pointers:
 *   slow -> moves 1 step at a time
 *   fast -> moves 2 steps at a time
 * - If there is a cycle, fast and slow will eventually meet inside the loop.
 * - If fast reaches null, there is no cycle.
 * - Time: O(n)
 * - Space: O(1)
 *
 * Why Floyd works:
 * - In a cyclic track, a faster runner will always catch the slower runner.
 *
 * Common pitfalls:
 * - Using print traversal on a cyclic list (infinite loop).
 * - Using equals() instead of reference check (use slow == fast).
 * - Forgetting the loop guard: while (fast != null && fast.next != null)
 */
public class DetectCycleLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> (2)
        Node head = new Node(1);
        Node node2 = new Node(2);
        head.next = node2;
        head.next.next = new Node(3);
        head.next.next.next = node2;

        System.out.println("Has cycle : " + hasCycle(head));

        System.out.println("Has cycle : " + hasCycle1(head));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;

        HashSet<Node> set = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     * Algorithm : Floyd's Cycle Detection (Tortoise and Hare)
     */
    public static boolean hasCycle1(Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
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

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
