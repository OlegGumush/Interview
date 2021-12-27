package leetcode.questions.array;

//        238. Product of Array Except Self
//        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//        You must write an algorithm that runs in O(n) time and without using the division operation.

import tags.Educative;
import tags.Type;

import java.util.Arrays;

@Educative(value = Type.Arrays)
public class LeetCode_0238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfInternet(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int all = 1;
        int numberOfZeros = 0;

        for (int num : nums) {
            if (num == 0) {
                numberOfZeros++;
                continue;
            }
            all *= num;
        }
        for (int i = 0; i < result.length; i++) {
            if (nums[i] == 0) {
                if (numberOfZeros == 1) {
                    result[i] = all;
                } else {
                    result[i] = 0;
                }
                continue;
            }
            if (numberOfZeros > 0) {
                result[i] = 0;
            } else {
                result[i] = all / nums[i];
            }
        }

        return result;
    }

    public static int[] productExceptSelfInternet(int[] nums) {

        int temp = 1;
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);

        for (int i = 0; i < nums.length; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }

        return prod;
    }
}