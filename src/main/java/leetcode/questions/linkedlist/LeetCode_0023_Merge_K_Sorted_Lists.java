package leetcode.questions.linkedlist;

//        23. Merge k Sorted Lists
//        You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//        Merge all the linked-lists into one sorted linked-list and return it.

//        Example 1:
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//        Output: [1,1,2,3,4,4,5,6]
//        Explanation: The linked-lists are:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        merging them into one sorted list:
//        1->1->2->3->4->4->5->6

//        Example 2:
//        Input: lists = []
//        Output: []

//        Example 3:
//        Input: lists = [[]]
//        Output: []

public class LeetCode_0023_Merge_K_Sorted_Lists {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(2, new ListNode(5, new ListNode(9, new ListNode(14))));
        ListNode list2 = new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))));
        ListNode list3 = new ListNode(1, new ListNode(6, new ListNode(9, new ListNode(14))));

        System.out.println(mergeKLists(new ListNode[]{list1, list2, list3}));
    }

    // TODO: Better impl
    public static ListNode mergeKListsMergeTwoEveryTime(ListNode[] lists) {

        return null;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        while (true) {

            tail.next = findMinimum(lists);
            if (tail.next == null) {
                break;
            }
            tail = tail.next;
        }

        return dummyHead.next;
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
        if (listIndex == -1) {
            return null;
        }
        ListNode result = lists[listIndex];
        lists[listIndex] = lists[listIndex].next;
        return result;
    }
}