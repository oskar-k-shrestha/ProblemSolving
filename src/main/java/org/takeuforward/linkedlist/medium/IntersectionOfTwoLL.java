package org.takeuforward.linkedlist.medium;

import java.util.HashSet;

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
