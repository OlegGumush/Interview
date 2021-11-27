package leetcode.questions.binarysearch;

//        35. Search Insert Position
//        Given a sorted array of distinct integers and a target value, return the index if the target is found.
//        If not, return the index where it would be if it were inserted in order.
//        You must write an algorithm with O(log n) runtime complexity.

public class LeetCode_0033_Search_Rotated_Array {

    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{80, 90, 100, 110, 10, 20, 30, 40, 50, 60, 70}, 90));
        System.out.println(searchInsert(new int[]{}, 90));
        System.out.println(searchInsert(new int[]{90}, 90));
        System.out.println(searchInsert(new int[]{80}, 90));
        System.out.println(searchInsert(new int[]{80, 90}, 90));
        System.out.println(searchInsert(new int[]{90, 80}, 90));
        System.out.println(searchInsert(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            // right side is sorted & target > middle
            if (nums[middle] < nums[end]) {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                if (target >= nums[start] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }
}