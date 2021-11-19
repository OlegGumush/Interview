package leet.code.questions;

//       977. Squares of a Sorted Array
//       Given an integer array nums sorted in non-decreasing order,
//       return an array of the squares of each number sorted in non-decreasing order.

//        Example 1:
//        Input: nums = [-4,-1,0,3,10]
//        Output: [0,1,9,16,100]
//        Explanation: After squaring, the array becomes [16,1,0,9,100].
//        After sorting, it becomes [0,1,9,16,100].

//        Example 2:
//        Input: nums = [-7,-3,2,3,11]
//        Output: [4,9,9,49,121]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_0977 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public static int[] sortedSquares(int[] nums) {

        List<Integer> negative = new ArrayList<Integer>();
        List<Integer> positive = new ArrayList<Integer>();
        int result[] = new int[nums.length];

        int positiveIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                negative.add(0, ((int) Math.pow(nums[i], 2)));
            } else {
                positive.add(((int) Math.pow(nums[i], 2)));
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < negative.size() && j < positive.size()) {
            if (negative.get(i) < positive.get(j)) {
                result[k++] = negative.get(i++);
            } else {
                result[k++] = positive.get(j++);
            }
        }
        while (i < negative.size()) {
            result[k++] = negative.get(i++);
        }
        while (j < positive.size()) {
            result[k++] = positive.get(j++);
        }

        return result;
    }
}