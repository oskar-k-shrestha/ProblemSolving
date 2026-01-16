package org.takeuforward.linkedlist.easy;

public class SimpleSinglyLinkedList {

    public static void main(String[] args) {
        // 3 -> 4 -> 8 -> 9
        Node head = new Node(3);
        addNode(head, 4);
        addNode(head, 8);
        addNode(head, 9);

        printList(head);

        head = addNodeAtFront(head, 13);
        // 13 -> 3 -> 4 -> 8 -> 9
        printList(head);

    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node addNode(Node head, int data) {
        if (head == null) return new Node(data);
        Node curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        Node newNode = new Node(data);
        curr.setNext(newNode);
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
            System.out.print(curr.getData() + (curr.getNext() != null ? "->" : ""));
            curr = curr.getNext();
        }
        System.out.println();
    }

    /**
     * Time complexity : O(1)
     * Space complexity : O(1)
     */
    public static Node addNodeAtFront(Node head, int data) {
        return new Node(data, head);
    }

    static class Node {

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}

