package leet.code.Algorithm_01;

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

import java.util.Arrays;

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
}