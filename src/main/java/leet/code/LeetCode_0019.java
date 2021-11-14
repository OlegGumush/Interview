package leet.code;

public class LeetCode_0019 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(head, 2));

        ListNode head1 = new ListNode(4);
        System.out.println(removeNthFromEnd(head1, 1));

        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(head2, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode firstRunner = head;
        ListNode prevFirstRunner = null;
        ListNode secondRunner = head;

        int i = 0;
        while (i < n) {
            secondRunner = secondRunner.next;
            i++;
        }
        while (secondRunner != null) {
            secondRunner = secondRunner.next;
            prevFirstRunner = firstRunner;
            firstRunner = firstRunner.next;
        }
        if (prevFirstRunner == null) {
            return head.next;
        }
        prevFirstRunner.next = prevFirstRunner.next.next;

        return head;
    }
}