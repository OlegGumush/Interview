package leetcode.questions.array;

//       189. Rotate Array
//       Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//        Example 1:
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//        Example 2:
//        Input: nums = [-1,-100,3,99], k = 2
//        Output: [3,99,-1,-100]
//        Explanation:
//        rotate 1 steps to the right: [99,-1,-100,3]
//        rotate 2 steps to the right: [3,99,-1,-100]

import java.util.Arrays;

public class LeetCode_0189_Rotate_Array {

    public static void main(String[] args) {

        // [1, 2 ,3, 4, 5, 6, 7]
        // [5, 6, 7, 1, 2, 3, 4]

        // [1, 2 ,3, 4, 5, 6, 7]
        // Step 01: [4, 3, 2, 1, 5, 6, 7]
        // Step 02: [4, 3, 2, 1, 7, 6, 5]
        // Step 03: [5, 6, 7, 1, 2, 3, 4]

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int t = n - (k % n); // in case K > N
        reverse(nums, 0, t - 1);
        reverse(nums, t, n - 1);
        reverse(nums, 0, n - 1);
    }

    public static void rotate1(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int first = nums[0];
            for (int j = 1; j <= nums.length; j++) {
                int second = nums[j % nums.length];
                nums[j % nums.length] = first;
                first = second;
            }
        }
    }
}