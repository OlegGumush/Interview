package leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_0016 {

    public static void main(String[] args) {

        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        long closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return (int) closestSum;
    }
}