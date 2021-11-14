package com.interview;

public class LeetCode_0004 {

    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 5, 6}, new int[]{4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    // TODO - https://www.youtube.com/watch?v=q6IEA26hvXc

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        if (nums2Length < nums1Length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int half = (nums1Length + nums2Length + 1) / 2;
        int startNums1 = 0;
        int endNums1 = nums1Length;

        while (startNums1 <= endNums1) {

            // nums1 left partition
            int nums1Partition = (startNums1 + endNums1) / 2;
            // num2 left partition
            int nums2Partition = half - nums1Partition;

            // Biggest number in each partition
            int nums1MaxLeft = (nums1Partition == 0) ? Integer.MIN_VALUE : nums1[nums1Partition - 1];
            int nums2MaxLeft = (nums2Partition == 0) ? Integer.MIN_VALUE : nums2[nums2Partition - 1];

            // Minimum number in second side of each partition
            int nums1MinRight = (nums1Partition == nums1Length) ? Integer.MAX_VALUE : nums1[nums1Partition];
            int nums2MinRight = (nums2Partition == nums2Length) ? Integer.MAX_VALUE : nums2[nums2Partition];

            // if both partitions have the right position it their part
            if (nums1MaxLeft <= nums2MinRight && nums2MaxLeft <= nums1MinRight) {
                if ((nums1Length + nums2Length) % 2 == 0) {
                    return (Math.max(nums1MaxLeft, nums2MaxLeft) + Math.min(nums1MinRight, nums2MinRight)) / 2.0;
                } else {
                    return Math.max(nums1MaxLeft, nums2MaxLeft);
                }
            } else if (nums1MaxLeft > nums2MinRight) {
                endNums1 = nums1Partition - 1;
            } else {
                startNums1 = nums1Partition + 1;
            }
        }
        return 1;
    }
}