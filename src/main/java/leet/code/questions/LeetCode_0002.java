package leet.code.questions;

public class LeetCode_0002 {

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
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
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