package leetcode.questions.dp;

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


import tags.Facebook;

import java.util.Arrays;

// https://www.youtube.com/watch?v=cjWnW0hdF1Y
@Facebook(value = "016", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0300_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}


