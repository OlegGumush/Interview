package leetcode.questions.bits;

//        136. Single Number
//        Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//        You must implement a solution with a linear runtime complexity and use only constant extra space.

public class LeetCode_0136_Single_Number {

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2, 2, 1, 5, 6, 5, 6, 7, 7}));
    }

    public static int singleNumber(int[] nums) {

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}