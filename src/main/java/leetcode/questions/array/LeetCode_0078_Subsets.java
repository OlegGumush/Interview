package leetcode.questions.array;

import tags.Facebook;

import java.util.ArrayList;
import java.util.List;

//        78. Subsets
//        Given an integer array nums of unique elements, return all possible subsets (the power set).
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//        Example 1:
//        Input: nums = [1,2,3]
//        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

//        Example 2:
//        Input: nums = [0]
//        Output: [[],[0]]

@Facebook(value = "009", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0078_Subsets {

    // TODO: Missing backtracking algorithm
    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        int bits[] = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        int size = (int) Math.pow(2, nums.length);

        for (int i = 0; i < size; i++) {
            result.add(generate(nums, bits));
            addBit(bits);
        }

        return result;
    }

    public static List<Integer> generate(int[] nums, int[] bits) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (bits[i] == 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void addBit(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                bits[i] = 1;
                return;
            } else {
                bits[i] = 0;
            }
        }
    }
}