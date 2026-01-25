package org.takeuforward.linkedlist.medium;

import java.util.HashSet;

/**
 * LeetCode 142: Linked List Cycle II (Find the start node of a cycle)
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Notes (Concept Recap):
 * - Goal: If a cycle exists in a singly linked list, return the node where the cycle begins.
 * - If there is no cycle, return null.
 *
 * Approach 1: HashSet (Easy + Intuitive)
 * - Keep visiting nodes and store them in a HashSet.
 * - The first node we encounter again is the cycle start.
 *
 * Complexity:
 * - Time:  O(n)
 * - Space: O(n)
 *
 * Approach 2: Floyd’s Cycle Detection (Optimal)
 * Step 1: Detect cycle
 * - Use slow (1 step) and fast (2 steps).
 * - If slow == fast, cycle exists.
 *
 * Step 2: Find cycle start
 * - Reset slow to head (keep fast at meeting point).
 * - Move both slow and fast one step at a time.
 * - The node where they meet again is the cycle start.
 *
 * Why reset works (Key Insight):
 * Let:
 * - x = distance from head to cycle start
 * - y = distance from cycle start to meeting point
 * - z = distance from meeting point back to cycle start
 *
 * When slow meets fast:
 * slow distance = x + y
 * fast distance = x + y + z + y = x + 2y + z
 *
 * Since fast is 2x speed:
 * 2(x + y) = x + 2y + z
 * => x = z
 *
 * Meaning:
 * - distance(head -> cycleStart) == distance(meetingPoint -> cycleStart)
 * - so moving both pointers step-by-step makes them meet at cycleStart.
 *
 * Complexity:
 * - Time:  O(n)
 * - Space: O(1)
 *
 * Common Pitfalls:
 * - Trying to print a cyclic list without detection → infinite loop
 * - Forgetting the second phase (reset slow to head)
 * - Returning meeting point instead of the true cycle start
 */
public class IdentifyStartNodeOfCycleInLL {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        Node secondNode = new Node(2);
        head.next = secondNode;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = secondNode;

        Node result = detectCycleStart(head);
        System.out.println("Cycle start : " + (result != null ? result.data : "null"));

        result = detectCycleStart1(head);
        System.out.println("Cycle start : " + (result != null ? result.data : "null"));


    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public static Node detectCycleStart(Node head) {
        if (head == null || head.next == null) return null;

        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     * Note :   x = distance between start and cycle start node
     *          y = distance between cycle start node and meet-up node
     *          z = distance between meet-up node and start cycle node
     * When, slow == fast,
     *          distance covered by slow = x + y
     *          distance covered by fast = x + y + z + y = x + 2y + z
     * We know, speed = distance / time -> time = distance / speed
     *          both slow and fast pointer take same time when they meet
     *
     *          time taken by slow = time taken by fast
     *          distance of slow / speed of slow = distance of fast / speed of fast
     *          (x + y) / 1 = (x + 2y + z) / 2
     *          2x + 2y = x + 2y + z
     *          x = z i.e. distance between start to start cycle node is equal to distance
     *          between meet up node to start cycle node
     *
     *          After meetup, we can reset slow to start node. Then increment both slow and fast by 1
     *          until they meet again. They will meet in start cycle node.
     */
    public static Node detectCycleStart1(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // reset slow to head
                slow = head;
                // identify mid point
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
    */
    public static void printLL(Node head) {
        System.out.print("List : ");
        while (head != null) {
            System.out.print(head.data + (head.next != null ? "->" : ""));
            head = head.next;
        }
        System.out.println();
    }
    public static class Node {
        int data;
        Node next;
        public Node(int data) {this.data = data;}
        public Node(int data, Node next) {this.data = data; this.next = next;}
    }
}
