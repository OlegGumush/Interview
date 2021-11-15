package leet.code.questions;

public class LeetCode_0021 {

    public static void main(String[] args) {

        System.out.println(mergeTwoLists(new ListNode(2, new ListNode(5, new ListNode(9, new ListNode(14)))),
                new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))))));

        System.out.println(mergeTwoLists(null, null));

        System.out.println(mergeTwoLists(null, new ListNode(1)));

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode result = new ListNode(1);
        ListNode tail = result;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                tail.next = list2;
                return result.next;
            }
            if (list2 == null) {
                tail.next = list1;
                return result.next;
            }

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        return result.next;
    }
}