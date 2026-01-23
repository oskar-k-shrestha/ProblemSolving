package org.takeuforward.linkedlist.medium;

/**
 * Reverse a Doubly Linked List (DLL) in-place.
 *
 * Goal:
 * Reverse the direction of the list by flipping both pointers of every node.
 *
 * Key Idea (DLL reversal):
 * For each node:
 * - curr.next should point to the previous node
 * - curr.prev should point to the next node (old forward direction)
 *
 * Pointer updates per node:
 * 1) next = curr.next          // store original next
 * 2) curr.next = prev          // reverse forward link
 * 3) curr.prev = next          // reverse backward link
 * 4) prev = curr              // move prev forward
 * 5) curr = next              // move curr forward (using stored next)
 *
 * Result:
 * - 'prev' becomes the new head at the end of traversal.
 *
 * Edge Cases:
 * - head == null  -> return null
 * - single node   -> unchanged (same node returned)
 *
 * Time Complexity: O(n)   (single traversal)
 * Space Complexity: O(1)  (in-place pointer manipulation)
 *
 * Interview Tip:
 * "In a DLL, reverse means swapping next and prev references for each node."
 */
public class ReverseDDL {
    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = buildDDL(1, 2, 3, 4, 5, 6);
        printDDLForward(head);

        Node tail = reverseDDL(head);
        printDDLForward(tail);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node reverseDDL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node buildDDL(int... values) {
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
    public static void printDDLForward(Node head) {
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
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
