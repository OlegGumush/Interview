package leet.code.questions;

//        203. Remove Linked List Elements
//        Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

import nodes.ListNode;

public class LeetCode_0203 {

    public static void main(String[] args) {

        System.out.println(removeElements(new ListNode(6, new ListNode(2, new ListNode(6, new ListNode(4, new ListNode(5, new ListNode(6)))))), 6));
    }

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}