package leetcode.questions.array;

//        1. Two Sum
//        Given an array of integers nums and an integer target, return indices of the two numbers such that
//        they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//        You can return the answer in any order.
//
//        Example 1:
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//
//        Example 3:
//        Input: nums = [3,3], target = 6
//        Output: [0,1]

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_0001_Two_Sum {

    public static void main(String[] args) {

        int arr[] = {2, 7, 11, 15};
        int[] result = twoSum(arr, 9);
        System.out.println(Arrays.toString(result));

        int arr1[] = {3, 2, 4};
        int result1[] = twoSum(arr1, 6);
        System.out.println(Arrays.toString(result1));

        int arr2[] = {3, 3};
        int result2[] = twoSum(arr2, 6);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashSet = new HashMap<>();
        int result[] = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            Integer value = hashSet.get(target - num);

            if (value != null) {
                result[0] = value;
                result[1] = i;
                break;
            }
            hashSet.put(num, i);
        }
        return result;
    }
}