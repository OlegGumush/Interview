package leetcode.questions.linkedlist;

//        21. Merge Two Sorted Lists
//        Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//        Example 1:
//        Input: l1 = [1,2,4], l2 = [1,3,4]
//        Output: [1,1,2,3,4,4]
//
//        Example 2:
//        Input: l1 = [], l2 = []
//        Output: []

//        Example 3:
//        Input: l1 = [], l2 = [0]
//        Output: [0]

public class LeetCode_0021_Merge_Two_Sorted_Lists {

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
        ListNode dummyHead = new ListNode(1);
        ListNode tail = dummyHead;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                tail.next = list2;
                return dummyHead.next;
            }
            if (list2 == null) {
                tail.next = list1;
                return dummyHead.next;
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

        return dummyHead.next;
    }
}