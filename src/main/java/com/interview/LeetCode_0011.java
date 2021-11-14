package com.interview;

public class LeetCode_0011 {

    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4})); // 16
        System.out.println(maxArea(new int[]{1, 2, 1})); // 2
        System.out.println(maxArea(new int[]{1, 1})); // 1
    }

    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));

            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}