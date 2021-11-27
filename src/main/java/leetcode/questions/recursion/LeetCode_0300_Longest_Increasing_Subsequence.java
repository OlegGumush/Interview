package leetcode.questions.recursion;

//        300. Longest Increasing Subsequence
//        Given an integer array nums, return the length of the longest strictly increasing subsequence.
//        A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//        Example 1:
//        Input: nums = [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//
//        Example 2:
//        Input: nums = [0,1,0,3,2,3]
//        Output: 4
//
//        Example 3:
//        Input: nums = [7,7,7,7,7,7,7]
//        Output: 1


import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=cjWnW0hdF1Y
public class LeetCode_0300_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7, 7}));

    }

    public static int lengthOfLIS(int[] nums) {

        return lengthOfLIS(nums, 0, Integer.MIN_VALUE);
    }

    static Map<Integer, Integer> cache = new HashMap<>();

    private static int lengthOfLIS(int[] nums, int index, int prev) {

        if (index == nums.length) {
            return 0;
        }

        int exclude = lengthOfLIS(nums, index + 1, prev);

        int include = Integer.MIN_VALUE;
        if (nums[index] > prev) {
            include = 1 + lengthOfLIS(nums, index + 1, nums[index]);
        }

        return Math.max(include, exclude);
    }
}


