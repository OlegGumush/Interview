package leet.code.questions.DynamicPrograming_01;

//        740. Delete and Earn
//        You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
//
//        Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
//        Return the maximum number of points you can earn by applying the above operation some number of times.

//        Example 1:
//        Input: nums = [3,4,2]
//        Output: 6
//        Explanation: You can perform the following operations:
//        - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//        - Delete 2 to earn 2 points. nums = [].
//        You earn a total of 6 points.

//        Example 2:
//        Input: nums = [2,2,3,3,3,4]
//        Output: 9
//        Explanation: You can perform the following operations:
//        - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
//        - Delete a 3 again to earn 3 points. nums = [3].
//        - Delete a 3 once more to earn 3 points. nums = [].
//        You earn a total of 9 points.

import java.util.*;

public class LeetCode_0740_Learn {

    public static void main(String[] args) {

        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(deleteAndEarn(new int[]{3, 1}));
    }

    // TODO - Understand the answer
    public static int deleteAndEarn(int[] nums) {

        int[] count = new int[10001];
        for (int x : nums) {
            count[x] += x;
        }
        int avoid = 0;
        int using = 0;
        int prevIndex = -1;

        for (int i = 0; i <= 10000; ++i) {
            if (count[i] <= 0) {
                continue;
            }
            int maxBetweenAvoidOrTake = Math.max(avoid, using);

            // If we skip previous
            if (i - 1 != prevIndex) {
                using = count[i] + maxBetweenAvoidOrTake;
                avoid = maxBetweenAvoidOrTake;
            } else {
                using = count[i] + avoid;
                avoid = maxBetweenAvoidOrTake;
            }
            prevIndex = i;
        }
        return Math.max(avoid, using);
    }
}