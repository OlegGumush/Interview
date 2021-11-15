package leet.code.questions.DynamicPrograming_01;

//        213. House Robber 2
//        You are a professional robber planning to rob houses along a street.
//        Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
//        That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected,
//        and it will automatically contact the police if two adjacent houses were broken into on the same night.

//        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//        Example 1:
//        Input: nums = [2,3,2]
//        Output: 3
//        Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

//        Example 2:
//        Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.

//        Example 3:
//        Input: nums = [1,2,3]
//        Output: 3

public class LeetCode_0213 {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{0, 0}));
    }

    public static int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(regularRob(nums, 0, nums.length - 1), regularRob(nums, 1, nums.length));
    }

    public static int regularRob(int[] nums, int start, int end) {

        int size = (end - start);
        int arr[] = new int[nums.length];
        arr[start] = nums[start];
        arr[start + 1] = Math.max(nums[start + 1], nums[start]);

        for (int i = start + 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        }
        return Math.max(arr[size - 2 + start], arr[size - 1 + start]);
    }
}