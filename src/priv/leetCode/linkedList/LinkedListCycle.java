package priv.leetCode.linkedList;
/*
    Given head of a linked list, determine if the linked list has a cycle in it
    pos is used to denote the index of node that tail's next pointer is connected to
    pos is not passed as a parameter

    Input1: head = [3, 2, 0, -4], pos = 1
    Output1: true

    Input2: head = [1, 2], pos = 0
    Output2: true

    Input3: head = [1], pos = -1
    Output3: true

    LeetCode#141: https://leetcode.com/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assert isCyclic(node1);
    }

    private static boolean isCyclic(ListNode head) {
        if (head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
