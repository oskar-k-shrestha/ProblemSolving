package org.takeuforward.linkedlist.easy;

/**
 * Doubly Linked List (DLL) Practice Notes
 *
 * Goal:
 * Implement and understand the basics of a Doubly Linked List where each node has:
 * 1) next pointer  -> forward navigation
 * 2) prev pointer  -> backward navigation
 *
 * Node Structure:
 * data | prev | next
 *
 * What this program demonstrates:
 *
 * 1) buildDLL(int... values)
 *    - Builds a doubly linked list from an array of values.
 *    - Links nodes in BOTH directions:
 *        prev.next = curr
 *        curr.prev = prev
 *    - Returns the head of the list.
 *
 * 2) addNode(int data, Node head)
 *    - Adds a new node at the end (tail) of the doubly linked list.
 *    - Traverses until curr.next == null (tail node).
 *    - Appends new node and sets correct backward link:
 *        curr.next = new Node(curr, data, null)
 *
 * 3) printForward(Node head)
 *    - Traverses using `next` pointers.
 *    - Prints in forward order.
 *    - Time: O(n)
 *
 * 4) printBackward(Node head)
 *    - First traversal reaches the tail node (curr.next == null).
 *    - Second traversal prints backwards using `prev` pointers.
 *    - Time: O(n) (2 passes but still O(n))
 *
 * Key Takeaways:
 * - DLL supports traversal in both directions unlike Singly Linked List.
 * - Insert/delete operations become easier if you already have a reference node
 *   because you can move backward using `prev`.
 *
 * Common Interview Follow-ups:
 * - Insert at head / tail
 * - Delete a node (head/middle/tail)
 * - Reverse a doubly linked list
 * - Convert array to DLL
 */
public class SimpleDoubleLinkedList {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = buildDLL(1, 2, 3, 4, 5);
        printForward(head);
        printBackward(head);

        addNode(6, head);
        printForward(head);
        printBackward(head);
    }

    public static void addNode(int data, Node head) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(curr, data, null);
    }

    public static Node buildDLL(int... values) {
        if (values == null || values.length == 0) return null;

        Node head = new Node(values[0]);
        Node prev = head;

        for (int i = 1; i < values.length; i++) {
            Node curr = new Node(prev, values[i], null);
            prev.next = curr;

            prev = curr;
        }
        return head;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void printForward(Node head) {
        Node curr = head;
        System.out.print("List : ");
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Time complexity : O(n) - 2 pass
     * Space complexity : O(1)
     */
    public static void printBackward(Node head) {
        if (head == null) return;

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        System.out.print("List : ");
        while (curr != null) {
            System.out.print(curr.data + (curr.prev != null ? "->" : ""));
            curr = curr.prev;
        }
        System.out.println();

    }

    public static class Node {
        public int data;
        public Node prev;
        public Node next;
        public Node(Node prev, int data, Node next) {this.prev = prev; this.data = data; this.next = next;}
        public Node(int data) {this.data = data; this.prev = null; this.next = null;}
    }
}
