package org.takeuforward.linkedlist.easy;

public class DeleteTailNode {

    public static void main(String[] args) {
        // 3 -> 4 -> 12 -> 24
        Node head = new Node(3, new Node(4, new Node(12, new Node(24))));
        printList(head);
        head = deleteTailNode(head);
        printList(head);

    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node deleteTailNode(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
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


    static class Node {

        public int data;

        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
