package org.takeuforward.linkedlist.medium;

import java.util.Stack;

/**
 * LeetCode 234: Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Notes (Concept Recap):
 * A linked list is a palindrome if reading values from left->right is the same as right->left.
 *
 * This file demonstrates 2 common interview approaches:
 *
 * 1) Stack Based (Extra Space)
 *    Method: isLLPalindrome()
 *    Idea:
 *    - Push all node values into a stack.
 *    - Traverse the list again and compare each node with stack.pop().
 *    Why it works:
 *    - Stack gives values in reverse order (LIFO), matching reverse traversal.
 *    Complexity:
 *    - Time: O(n) (2 passes)
 *    - Space: O(n) (stack holds n values)
 *
 * 2) Optimal In-Place (Tortoise & Hare + Reverse Second Half)
 *    Method: isLLPalindrome1()
 *    Idea:
 *    - Use slow/fast pointers to find the middle node.
 *      slow moves 1 step, fast moves 2 steps.
 *      When fast reaches end, slow is at midpoint.
 *    - Reverse the second half of the list starting from slow.
 *    - Compare nodes from:
 *        (head -> ...)  with  (reversedSecondHalf -> ...)
 *      Compare only until reversedSecondHalf becomes null.
 *    Complexity:
 *    - Time: O(n)
 *    - Space: O(1)
 *
 * Important Interview Note:
 * - This optimized approach mutates the linked list because it reverses the 2nd half.
 * - In real systems, we usually restore the list by reversing the second half again.
 *
 * Edge cases handled:
 * - Empty list -> palindrome
 * - Single node -> palindrome
 * - Even length and odd length lists
 */
public class PalindromeLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 1
        Node head = buildLL(1,2,2,1);

        printLL(head);

        System.out.println("isLLPalindrome ? " + isLLPalindrome(head));
        System.out.println("isLLPalindrome ? " + isLLPalindrome1(head));

    }

    /**
     * Time complexity : O(n) 2-pass
     * Space complexity : O(n)
     */
    public static boolean isLLPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();

        // populate stack
        Node curr = head;
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }

        // compare
        curr = head;
        while (curr != null) {
            if (curr.data != stack.pop()) return false;
            curr = curr.next;
        }
        return true;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     * Note :   Using 'Tortoise and Hare' concept we move our slow and fast pointer.
     *          When fast pointer reaches the end, slow points to mid-point node.
     *          Next, we can reverse the 2nd half of the LL, and compare each node
     *          of first half and reversed half of the LL.
     */
    public static boolean isLLPalindrome1(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow has reached mid-point
        // reverse the 2nd half of LL
        Node reverseLL = reverseLL(slow);
        slow = head;

        // compare 1st half with 2nd half
        while(reverseLL != null) {
            if (reverseLL.data != slow.data) return false;
            reverseLL = reverseLL.next;
            slow = slow.next;
        }
        return true;
    }

    public static Node reverseLL(Node head) {
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
