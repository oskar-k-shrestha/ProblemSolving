package org.takeuforward.linkedlist.medium;

import java.util.HashSet;

/**
 * LeetCode 160: Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Problem:
 * - Given heads of two singly linked lists, return the node at which they intersect.
 * - Intersection is based on reference equality, NOT node value.
 * - If the two lists do not intersect, return null.
 *
 * Key Observation:
 * - After intersection, both linked lists share the same tail nodes.
 * - Comparing node values is incorrect; we must compare node references.
 *
 * ------------------------------------------------------------
 * Approach 1: HashSet (Extra Space)
 * ------------------------------------------------------------
 * Idea:
 * - Store all nodes of the first list in a HashSet.
 * - Traverse the second list and check if any node already exists in the set.
 *
 * Steps:
 * 1) Traverse list1 and add each node to HashSet.
 * 2) Traverse list2:
 *    - If a node is found in the set → intersection point.
 *
 * Time Complexity:
 * - O(m + n)
 *
 * Space Complexity:
 * - O(m) (HashSet stores nodes of first list)
 *
 * Pros:
 * - Simple and intuitive.
 *
 * Cons:
 * - Uses extra memory.
 * - Not optimal for interviews where O(1) space is preferred.
 *
 * ------------------------------------------------------------
 * Approach 2: Length Difference (Optimal, O(1) Space)
 * ------------------------------------------------------------
 * Idea:
 * - If two lists intersect, they must align at the same distance from the tail.
 * - Move the pointer of the longer list ahead by the length difference.
 * - Then traverse both lists together until nodes match.
 *
 * Steps:
 * 1) Compute lengths of both linked lists.
 * 2) Advance pointer of the longer list by |len1 - len2|.
 * 3) Move both pointers one step at a time:
 *    - First common node is the intersection.
 *
 * Time Complexity:
 * - O(m + n)
 *
 * Space Complexity:
 * - O(1)
 *
 * Why this works:
 * - Aligning pointers ensures both traverse equal remaining distance.
 * - Shared tail guarantees meeting at intersection node.
 *
 * Interview Notes:
 * - This is the preferred solution.
 * - Clean, efficient, and demonstrates strong pointer manipulation skills.
 * - Alternative optimal approach: Pointer switching (A→B, B→A).
 *
 * Common Pitfalls:
 * - Comparing node values instead of references.
 * - Forgetting to align lists by length difference.
 * - Mishandling null cases.
 */
public class IntersectionOfTwoLL {

    public static void main(String[] args) {
        // 1 -> 2 -> (3) -> 4 -> 5
        // 6 -> 7 -> (3)
        Node xNode = new Node(3);
        Node head1 = new Node(1, new Node(2, xNode));
        Node head2 = new Node(6, new Node(7, xNode));
        xNode.next = new Node(4, new Node(5));

        printLL(head1);
        printLL(head2);

        Node xNode1 = findXNode(head1, head2);
        System.out.println("xNode : " + (xNode1 == null ? "none" : xNode1.data));

        xNode1 = findXNode1(head1, head2);
        System.out.println("xNode : " + (xNode1 == null ? "none" : xNode1.data));
    }

    /**
     * Time complexity : O(m + n)
     * Space complexity : O(m)
     */
    public static Node findXNode(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();

        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        // compare
        while (head2 != null) {
            if (set.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }

        return null;
    }

    /**
     * Time complexity : O(max(m,n)) + O(|m-n|) + O(min(m,n))) -> O(max(m,n) + min(m,n)) -> O(m + n)
     * Space complexity : O(1)
     */
    public static Node findXNode1(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (curr1 != null || curr2 != null) {
            if (curr1 != null) {
                len1++;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                len2++;
                curr2 = curr2.next;
            }
        }

        curr1 = head1;
        curr2 = head2;
        boolean isLen1Large = len1 >= len2;
        if (isLen1Large) {
            int diff = len1 - len2;
            int count = 1;
            while (count <= diff) {
                curr1 = curr1.next;
                count++;
            }
        } else {
            int diff = len2 - len1;
            int count = 1;
            while (count <= diff) {
                curr2 = curr2.next;
                count++;
            }
        }

        // move both pointer together
        while (curr1 != null) {
            if (curr1 == curr2) return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
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
