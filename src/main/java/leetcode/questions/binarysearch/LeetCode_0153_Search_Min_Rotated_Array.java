package leetcode.questions.binarysearch;

// 153. Find Minimum in Rotated Sorted Array

public class LeetCode_0153_Search_Min_Rotated_Array {

    public static void main(String[] args) {

        System.out.println(findMin(new int[]{80, 90, 100, 110, 10, 20, 30, 40, 50, 60, 70}));
        System.out.println(findMin(new int[]{}));
        System.out.println(findMin(new int[]{90}));
        System.out.println(findMin(new int[]{80}));
        System.out.println(findMin(new int[]{80, 90}));
        System.out.println(findMin(new int[]{90, 80}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMin(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int middle = (start + end) / 2;
            if (nums[middle] < nums[end]) {
                end = middle; // no need to add -1 because middle can be minimum
            } else {
                start = middle + 1;
            }
        }
        return nums[end];
    }
}