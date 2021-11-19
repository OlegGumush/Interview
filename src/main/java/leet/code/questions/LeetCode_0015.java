package leet.code.questions;

import java.util.*;

//        15. 3Sum
//        Given an integer array nums, return all the triplets
//        [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
//
//        Example 1:
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]

//        Example 2:
//        Input: nums = []
//        Output: []

//        Example 3:
//        Input: nums = [0]
//        Output: []

public class LeetCode_0015 {

    public static void main(String[] args) {

        threeSum(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5});
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                int x = -(nums[i] + nums[j]);
                if (s.contains(x)) {
                    List<Integer> zero = Arrays.asList(nums[i], nums[j], x);
                    Collections.sort(zero);
                    if (!contains(result, zero)) {
                        result.add(zero);
                    }
                } else {
                    s.add(nums[j]);
                }
            }
        }
        return result;
    }

    private static boolean contains(List<List<Integer>> result, List<Integer> zero) {

        for (int i = 0; i < result.size(); i++) {
            List<Integer> existsZero = result.get(i);
            if (existsZero.get(0) == zero.get(0) && existsZero.get(1) == zero.get(1) && existsZero.get(2) == zero.get(2)) {
                return true;
            }
        }
        return false;
    }
}