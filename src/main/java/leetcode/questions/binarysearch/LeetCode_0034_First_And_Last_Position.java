package leetcode.questions.binarysearch;

//        34. Find First and Last Position of Element in Sorted Array
//        Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//        If target is not found in the array, return [-1, -1].
//        You must write an algorithm with O(log n) runtime complexity.
//
//        Example 1:
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//
//        Example 2:
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//
//        Example 3:
//        Input: nums = [], target = 0
//        Output: [-1,-1]

import tags.Facebook;

import java.util.Arrays;

@Facebook(value = "012", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0034_First_And_Last_Position {

    public static void main(String[] args) {

        //System.out.println(Arrays.toString(searchRange(new int[]{5, 5, 7, 7, 7, 7, 8, 8, 8, 8, 10, 15}, 5)));
        //System.out.println(Arrays.toString(searchRange(new int[]{5, 5, 7, 7, 7, 7, 8, 8, 8, 8, 10, 15}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {


        int first = first(nums, target);
        int second = second(nums, target);
        return new int[]{first, second};
    }

    private static int first(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] < nums[middle])) {
                return middle;
            }
            if (nums[middle] < target) { // important to use < instead of <=
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    private static int second(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;
            if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] > nums[middle])) {
                return middle;
            }
            if (nums[middle] <= target) { // important to use <= instead of <
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}