package com.interview.DataStructure_01;

// 88. Merge Sorted Array
// Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.

import java.util.Arrays;

public class LeetCode_0088 {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 5, 6, 0};
        int arr1[] = {3};

        merge(arr, 5, arr1, 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int tail = n + m - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[tail--] = nums1[i--];
            } else {
                nums1[tail--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[tail--] = nums2[j--];
        }
        while (i >= 0) {
            nums1[tail--] = nums1[i--];
        }
    }
}