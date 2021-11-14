package com.interview.Algorithm_01;


//278. First Bad Version
//        You are a product manager and currently leading a team to develop a new product.
//        Unfortunately, the latest version of your product fails the quality check. Since each version is developed
//        based on the previous version, all the versions after a bad version are also bad.
//
//        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all
//        the following ones to be bad.
//
//        You are given an API bool isBadVersion(version) which returns whether version is bad.
//        Implement a function to find the first bad version. You should minimize the number of calls to the API.

public class LeetCode_0278 {

    public static void main(String[] args) {

        System.out.println(firstBadVersion(Integer.MAX_VALUE));
        System.out.println(firstBadVersion(1));
    }

    public static int firstBadVersion(int n) {

        long start = 1;
        long end = n;
        long middle = -1;

        while (start < end) {

            middle = (start + end) / 2;
            if (isBadVersion((int) middle)) {
                end = (int) middle;
            } else {
                start = (int) middle + 1;
            }
        }
        return (int) start;
    }

    public static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}