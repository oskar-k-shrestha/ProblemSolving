package org.takeuforward.linkedlist.medium;

/**
 * Problem:
 * - Given a singly linked list containing only values {0, 1, 2},
 *   rearrange the nodes so that all 0s come first, then 1s, then 2s.
 * - Node order within the same value does not matter.
 *
 * Key Idea (Dutch National Flag for Linked List):
 * - Instead of swapping values, we rearrange node pointers.
 * - We create three separate lists:
 *      - one for 0s
 *      - one for 1s
 *      - one for 2s
 *
 * Optimized Approach (Dummy Nodes Technique):
 * - Use three dummy nodes: zeroDummy, oneDummy, twoDummy.
 * - Traverse the original list once:
 *      - Detach each node
 *      - Append it to the corresponding list (0 / 1 / 2)
 * - Finally, connect:
 *      zero-list -> one-list -> two-list
 *
 * Why Dummy Nodes?
 * - Eliminates complex nested if-else conditions.
 * - Avoids edge-case handling for empty sublists.
 * - Makes pointer wiring simple and readable.
 *
 * Steps:
 * 1) Create dummy nodes for 0, 1, and 2 lists.
 * 2) Traverse original list and distribute nodes.
 * 3) Break original links while appending (curr.next = null).
 * 4) Merge lists in order: 0 -> 1 -> 2.
 * 5) Return head of merged list.
 *
 * Complexity:
 * - Time: O(n)   (single traversal)
 * - Space: O(1)  (only pointer manipulation, no extra DS)
 *
 * Interview Notes:
 * - Prefer dummy nodes over nested if-else logic.
 * - Mention that values are not swapped — nodes are rearranged.
 * - This is the linked-list adaptation of Dutch National Flag.
 *
 * Common Pitfalls:
 * - Forgetting to detach nodes (can cause cycles).
 * - Not handling empty sublists properly.
 * - Returning wrong head when 0-list is empty.
 */
public class SortLL012 {

    public static void main(String[] args) {
        // 1 -> 2 -> 0 -> 1 -> 0 -> 2
        Node head = buildLL(1, 2, 0, 1, 0, 2);
        printLL(head);

        head = sort(head);
        printLL(head);

        head = buildLL(1, 2, 0, 1, 0, 2);
        printLL(head);
        head = sort1(head);
        printLL(head);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node sort(Node head) {
        Node curr = head;

        Node head0 = null;
        Node head1 = null;
        Node head2 = null;

        Node curr0 = null;
        Node curr1 = null;
        Node curr2 = null;

        while (curr != null) {
            if (curr.data == 0) {
                if (curr0 == null) {
                    curr0 = curr;
                    head0 = curr;
                } else {
                    curr0.next = curr;
                    curr0 = curr;
                }
            } else if (curr.data == 1) {
                if (curr1 == null) {
                    curr1 = curr;
                    head1 = curr;
                } else {
                    curr1.next = curr;
                    curr1 = curr;
                }
            } else {
                if (curr2 == null) {
                    curr2 = curr;
                    head2 = curr;
                } else {
                    curr2.next = curr;
                    curr2 = curr;
                }
            }
            Node next = curr.next;
            curr.next = null;
            curr = next;
        }

        if (head0 != null) {
            head = head0;
            if (head1 != null) {
                curr0.next = head1;
                if (head2 != null) {
                    curr1.next = head2;
                }
            } else if (head2 != null) {
                curr0.next = head2;
            }
        } else if (head1 != null) {
            head = head1;
            if (head2 != null) {
                curr1.next = head2;
            }
        } else if (head2 != null) {
            head = head2;
        }
        return head;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static Node sort1(Node head) {
        // use dummy nodes to improves nested if-else
        if (head == null || head.next == null) return head;

        Node zeroDummy = new Node(0);
        Node oneDummy = new Node(0);
        Node twoDummy = new Node(0);

        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;

        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            Node next = curr.next;
            curr.next = null; // detach node
            curr = next;
        }

        // Connect lists
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;

        return zeroDummy.next;
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
