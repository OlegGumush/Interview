package com.interview;

import java.util.*;

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