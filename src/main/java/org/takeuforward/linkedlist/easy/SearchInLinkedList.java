package org.takeuforward.linkedlist.easy;

public class SearchInLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        printList(head);

        System.out.println("Find 4 ? : " + search(4, head));
        System.out.println("Find 42 ? : " + search(42, head));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static boolean search(int value, Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == value) return true;
            curr = curr.next;
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

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {this.data = data;}

        public Node(int data, Node next) {this.data = data; this.next = next;}

    }
}
