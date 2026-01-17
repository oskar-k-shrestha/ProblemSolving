package org.takeuforward.linkedlist.medium;

/**
 * Delete Node in a Linked List (LeetCode 237)
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list
 *
 * Problem Summary:
 * We are given ONLY the node that needs to be deleted.
 * We do NOT have access to the head pointer or the previous node.
 *
 * Key Observation:
 * Normally deletion requires:
 *   prev.next = node.next
 * But since we don't have `prev`, we cannot delete the node directly.
 *
 * Optimal Trick (O(1)):
 * Instead of deleting the current node, we copy the next node’s data
 * into the current node, and bypass the next node.
 *
 * Steps:
 * 1) node.data = node.next.data
 * 2) node.next = node.next.next
 *
 * Example:
 * Before: 1 -> 2 -> (3) -> 4 -> 5
 * After : 1 -> 2 -> 4 -> 5
 *
 * Important Constraint:
 * This works only if the node to be deleted is NOT the tail node.
 * (LeetCode guarantees node.next != null)
 *
 * Complexity:
 * Time  : O(1)
 * Space : O(1)
 *
 * Note:
 * Another approach is shifting values until the end and deleting the last node,
 * but that would take O(n) time.
 */
public class DeleteNode {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        Node nodeToDelete = new Node(3, new Node(4, new Node(5)));
        Node head = new Node(1, new Node(2, nodeToDelete));

        printList(head);
        deleteNode(nodeToDelete);
        printList(head);

        // 1 -> 2 -> 3 -> 4 -> 5
        nodeToDelete = new Node(3, new Node(4, new Node(5)));
        head = new Node(1, new Node(2, nodeToDelete));

        printList(head);
        deleteNode1(nodeToDelete);
        printList(head);

    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void deleteNode(Node node) {
        while (node.next != null) {
            node.data = node.next.data;
            // check if next is tail node
            if (node.next.next == null) {
                // set 2nd last node as tail node
                node.next = null;
            } else {
                // move to next node
                node = node.next;
            }
        }
    }

    /**
     * Time complexity : O(1)
     * Space complexity : O(1)
     */
    public static void deleteNode1(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
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
        public int data;
        public Node next;
        public Node(int data) {this.data = data; this.next = null;}
        public Node(int data, Node next) {this.data = data; this.next = next;}
    }
}
