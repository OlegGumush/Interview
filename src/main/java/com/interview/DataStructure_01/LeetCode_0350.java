package com.interview.DataStructure_01;

//        350. Intersection of Two Arrays II
//        Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times
//        as it shows in both arrays and you may return the result in any order.

//        Example 1:
//        Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        Output: [2,2]

//        Example 2:
//        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [4,9]
//        Explanation: [9,4] is also accepted.
//
//        Constraints:
//        1 <= nums1.length, nums2.length <= 1000
//        0 <= nums1[i], nums2[i] <= 1000
//
//
//        Follow up:
//        What if the given array is already sorted? How would you optimize your algorithm?
//        What if nums1's size is small compared to nums2's size? Which algorithm is better?
//        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

import java.util.*;

public class LeetCode_0350 {

    public static void main(String[] args) {

        int arr[] = {1};
        int arr1[] = {1};

        System.out.println(Arrays.toString(intersect(arr, arr1)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 0);
            }
            map.put(nums1[i], map.get(nums1[i]) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {

            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                result.add(nums2[i]);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}