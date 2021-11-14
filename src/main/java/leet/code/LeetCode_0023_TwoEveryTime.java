package leet.code;

public class LeetCode_0023_TwoEveryTime {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(2, new ListNode(5, new ListNode(9, new ListNode(14))));
        ListNode list2 = new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))));
        ListNode list3 = new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))));

        System.out.println(mergeKLists(new ListNode[]{list1, list2, list3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        return null;
    }
}