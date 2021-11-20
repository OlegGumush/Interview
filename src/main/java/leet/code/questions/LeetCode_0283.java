package leet.code.questions;

//        283. Move Zeroes
//        Given an integer array nums, move all 0's to the end of it while maintaining the relative order of
//        the non-zero elements.
//
//        Note that you must do this in-place without making a copy of the array.
//
//        Example 1:
//        Input: nums = [0,1,0,3,12]
//        Output: [1,3,12,0,0]

//        Example 2:
//        Input: nums = [0]
//        Output: [0]

import tags.Facebook;

import java.util.Arrays;

@Facebook(value = "001", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0283 {

    public static void main(String[] args) {

        int arr[] = new int[]{0, 0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {

        int zero = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[zero++] = nums[j];
            }

        }
        while (zero < nums.length) {
            nums[zero++] = 0;
        }
    }

    public static void moveZeroesToStart(int[] nums) {

        int notZeroIndex = nums.length - 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != 0) {
                nums[notZeroIndex--] = nums[j];
            }
        }
        int k = 0;
        while (k <= notZeroIndex) {
            nums[k++] = 0;
        }
    }
}