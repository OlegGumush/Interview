package leet.code.questions;

import java.util.Arrays;

//        16. 3Sum Closest
//        Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//        Return the sum of the three integers.
//        You may assume that each input would have exactly one solution.
//
//        Example 1:
//        Input: nums = [-1,2,1,-4], target = 1
//        Output: 2
//        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//        Example 2:
//        Input: nums = [0,0,0], target = 1
//        Output: 0

public class LeetCode_0016 {

    public static void main(String[] args) {

        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        long closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return (int) closestSum;
    }
}