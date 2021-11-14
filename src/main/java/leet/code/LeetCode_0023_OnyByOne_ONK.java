package leet.code;

public class LeetCode_0023_OnyByOne_ONK {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(2, new ListNode(5, new ListNode(9, new ListNode(14))));
        ListNode list2 = new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))));
        ListNode list3 = new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))));

        System.out.println(mergeKLists(new ListNode[]{list1, list2, list3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode prevOfResult = new ListNode(-1);
        ListNode tail = prevOfResult;

        while (true) {

            tail.next = findMinimum(lists);
            if (tail.next == null) {
                break;
            }
            tail = tail.next;
        }

        return prevOfResult.next;
    }

    private static ListNode findMinimum(ListNode[] lists) {

        int minimum = Integer.MAX_VALUE;
        int listIndex = -1;

        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list == null) {
                continue;
            }
            if (list.val < minimum) {
                minimum = list.val;
                listIndex = i;
            }
        }
        if (listIndex == - 1) {
            return null;
        }
        ListNode result = lists[listIndex];
        lists[listIndex] = lists[listIndex].next;
        return result;
    }
}