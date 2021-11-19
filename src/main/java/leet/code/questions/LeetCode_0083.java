package leet.code.questions;

//        83. Remove Duplicates from Sorted List
//        Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

import nodes.ListNode;

public class LeetCode_0083 {

    public static void main(String[] args) {

        System.out.println(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(6, new ListNode(6, new ListNode(6))))))));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {

            if (prev.val == curr.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}