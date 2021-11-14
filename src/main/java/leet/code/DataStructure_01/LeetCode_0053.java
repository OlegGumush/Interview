package leet.code.DataStructure_01;

//        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//        A subarray is a contiguous part of an array.

//        Example 1:
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.

//        Example 2:
//        Input: nums = [1]
//        Output: 1

//        Example 3:
//        Input: nums = [5,4,-1,7,8]
//        Output: 23

public class LeetCode_0053 {

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

    public static int maxSubArray(int[] nums) {

        // find the maximum element present in a given array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // if the array contains all negative values, return the maximum element
        if (max < 0) {
            return max;
        }

        int sum = 0;
        int highestSum = -1;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sum < 0) {
                sum = 0;
                continue;
            }
            if (highestSum < sum) {
                highestSum = sum;
            }
        }
        return highestSum;
    }
}