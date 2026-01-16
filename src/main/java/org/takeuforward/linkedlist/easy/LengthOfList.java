package org.takeuforward.linkedlist.easy;

public class LengthOfList {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        printList(head);

        System.out.println("Size : " + countNodes(head));
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static int countNodes(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
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
