package leet.code.Algorithm_01;

import leet.code.ListNode;

//        876. Middle of the Linked List
//        Given the head of a singly linked list, return the middle node of the linked list.
//        If there are two middle nodes, return the second middle node.

public class LeetCode_0876 {

    public static void main(String[] args) {

        System.out.println(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        System.out.println(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }

    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode oneRunner = head;
        ListNode twoRunner = head;

        while (twoRunner != null && twoRunner.next != null) {
            oneRunner = oneRunner.next;
            twoRunner = twoRunner.next.next;
        }

        return oneRunner;
    }
}