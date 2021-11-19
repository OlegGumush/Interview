package leet.code.questions;

//        35. Search Insert Position
//        Given a sorted array of distinct integers and a target value, return the index if the target is found.
//        If not, return the index where it would be if it were inserted in order.
//        You must write an algorithm with O(log n) runtime complexity.

public class LeetCode_0035 {

    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1}, 0));
        System.out.println(searchInsert(new int[]{1, 3}, 2));

    }

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }
}