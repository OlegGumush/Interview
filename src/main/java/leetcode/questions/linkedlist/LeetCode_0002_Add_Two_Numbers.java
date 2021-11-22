package leetcode.questions.linkedlist;

//        2. Add Two Numbers
//        You are given two non-empty linked lists representing two non-negative integers.
//        The digits are stored in reverse order, and each of their nodes contains a single digit.
//        Add the two numbers and return the sum as a linked list.
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//        Example 1:
//        Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]
//        Explanation: 342 + 465 = 807.

//        Example 2:
//        Input: l1 = [0], l2 = [0]
//        Output: [0]

//        Example 3:
//        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        Output: [8,9,9,9,0,0,0,1]

public class LeetCode_0002_Add_Two_Numbers {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        System.out.println(addTwoNumbers(list1, list2));

        ListNode list3 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode list4 = new ListNode(7, new ListNode(0, new ListNode(8)));
        System.out.println(addTwoNumbers(list3, list4));

        ListNode list5 = new ListNode(0);
        ListNode list6 = new ListNode(5);
        System.out.println(addTwoNumbers(list5, list6));

        ListNode list7 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode list8 = new ListNode(9, new ListNode(9, new ListNode(9)));
        System.out.println(addTwoNumbers(list7, list8));
    }

    public static ListNode internalSolution(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode prevTail = head;
        int remainder = 0;

        while (l1 != null || l2 != null) {

            if (tail == null) {
                tail = new ListNode();
                prevTail.next = tail;
            }
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + remainder;
            int number = sum % 10;
            remainder = sum / 10;

            tail.val = number;
            prevTail = tail;
            tail = tail.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (remainder == 0) {
            return head;
        }
        prevTail.next = new ListNode(remainder);
        return head;
    }

}