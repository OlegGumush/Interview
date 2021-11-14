package leet.code.DataStructure_01;

//        206. Reverse Linked List
//        Given the head of a singly linked list, reverse the list, and return the reversed list.

import leet.code.ListNode;

public class LeetCode_0206 {

    public static void main(String[] args) {

        System.out.println(reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}