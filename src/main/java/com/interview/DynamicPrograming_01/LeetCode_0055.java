package com.interview.DynamicPrograming_01;

//        55. Jump Game
//        You are given an integer array nums. You are initially positioned at the array's first index,
//        and each element in the array represents your maximum jump length at that position.
//        Return true if you can reach the last index, or false otherwise.
//
//        Example 1:
//        Input: nums = [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//        Example 2:
//        Input: nums = [3,2,1,0,4]
//        Output: false
//        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

public class LeetCode_0055 {

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2, 0}));
        System.out.println(canJump(new int[]{2, 0, 0}));
    }

    public static boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        for (int i = nums.length - 1; i < 0; i--) {

        }

        return true;
    }

    public static boolean canJumpRecurtion(int[] nums) {

        if (nums.length == 1) {
            return true;
        }
        return canJumpRecurtion(nums, 0);
    }

    private static boolean canJumpRecurtion(int[] nums, int i) {

        if (i >= nums.length - 1) {
            return true;
        }
        if (nums[i] == 0) {
            return false;
        }
        boolean result = false;
        for (int j = 1; j <= nums[i]; j++) {
            result = result || canJumpRecurtion(nums, i + j);
        }
        return result;
    }
}