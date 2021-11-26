package leetcode.questions.recursion;

//        46. Permutations
//        Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=KukNnoN-SoY
public class LeetCode_0046_Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2}));
        System.out.println(permute1(new int[]{1, 2}));
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute1(new int[]{1, 2, 3}));
        System.out.println(permute2(new int[]{1, 2, 3}));

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(numsList, new ArrayList<>(), result);
        return result;
    }

    private static void permute(List<Integer> nums, List<Integer> permutation, List<List<Integer>> answers) {

        if (nums.size() == 0) {
            answers.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            permutation.add(nums.get(i)); // add number to permutation
            permute(removeIndex(nums, i), permutation, answers); // send new array without this number, dont change the original one
            permutation.remove(permutation.size() - 1); // remove the last one in permutations
        }
    }

    private static List<Integer> removeIndex(List<Integer> nums, int index) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (i != index) {
                result.add(nums.get(i));
            }
        }
        return result;
    }

    // Second solution
    public static List<List<Integer>> permute1(int[] nums) {

        List<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        permute1(numsList, new ArrayList<>(), result);
        return result;
    }

    private static void permute1(List<Integer> nums, List<Integer> permutation, List<List<Integer>> answers) {

        if (nums.size() == 0) {
            answers.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            permutation.add(nums.remove(i)); // add number to permutation
            permute1(nums, permutation, answers); // send new array without this number, dont change the original one
            nums.add(i, permutation.remove(permutation.size() - 1)); // remove the last one in permutations
        }
    }

    // Third solution
    public static List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        permute2(nums, new ArrayList<>(), result);
        return result;
    }

    private static void permute2(int[] nums, List<Integer> permutation, List<List<Integer>> answers) {

        if (nums.length == permutation.size()) {
            answers.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                permutation.add(nums[i]); // add number to permutation
                nums[i] = Integer.MAX_VALUE;
                permute2(nums, permutation, answers); // send new array without this number, dont change the original one
                nums[i] = permutation.remove(permutation.size() - 1); // remove the last one in permutations
            }
        }
    }
}

//                                                           [1,2,3]
//                   i=0                                                     i=1                         i=2
//           nums[2,3] permutation[1]                            nums[1,3] permutation[2]     nums[1,2] permutation[3]
//           i=0                        i = 1
//  nums[3] permutation[1,2]      nums[2] permutation[1,3]
//        i=0                           i= 0
// nums[] permutation[1,2,3]      nums[2] permutation[1,3,2]


// * When going back remove the last permutation and add it back to the number








