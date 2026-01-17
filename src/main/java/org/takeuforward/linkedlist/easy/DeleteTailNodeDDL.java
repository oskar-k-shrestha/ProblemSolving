package org.takeuforward.linkedlist.easy;

/**
 * Delete Tail Node in a Doubly Linked List (DLL)
 *
 * Goal:
 * Remove the last node (tail) from a doubly linked list and return the head.
 *
 * Example:
 * Input  : 1 <-> 2 <-> 3 <-> 4 <-> 5
 * Output : 1 <-> 2 <-> 3 <-> 4
 *
 * Key Observations:
 * - Tail node is the node whose `next == null`
 * - In DLL, tail has a `prev` pointer which makes deletion easier once found.
 *
 * Approach:
 * 1) Handle edge cases:
 *    - If head == null → list is empty → return null
 *    - If head.next == null → only 1 node exists → deleting tail makes list empty → return null
 *
 * 2) Traverse from head to find the tail:
 *    - Start tail = head
 *    - Move while (tail.next != null)
 *
 * 3) Remove the tail:
 *    - tail.prev.next = null
 *    - (tail is now disconnected and becomes eligible for GC)
 *
 * Complexity:
 * - Time  : O(n)  → traversal needed to reach tail
 * - Space : O(1)  → no extra data structures used
 *
 * Note:
 * In a real DLL implementation, if you maintain a direct `tail` pointer,
 * deletion becomes O(1). But in this problem, we only have head reference.
 */
public class DeleteTailNodeDDL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = buildDDl(1, 2, 3, 4, 5);
        printList(head);

        head = deleteTailNode(head);
        printList(head);

        head = deleteTailNode(head);
        printList(head);

        head = deleteTailNode(head);
        printList(head);

        head = deleteTailNode(head);
        printList(head);

        head = deleteTailNode(head);
        printList(head);

    }

    public static Node deleteTailNode(Node head) {
        if (head == null) return null;
        if (head.next == null) return null;

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.prev.next = null;
        tail.prev = null;
        return head;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node buildDDl(int... values) {
        if (values == null || values.length == 0) return null;

        Node head = new Node(values[0]);
        Node prev = head;

        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(prev, values[i], null);
            prev.next = newNode;
            prev = newNode;
        }

        return head;
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
        public Node prev;
        public Node next;
        public Node(int data) {this.data = data; this.prev = null; this.next = null;}
        public Node(Node prev, int data, Node next) {this.prev = prev; this.data = data; this.next = next;}
    }
}
