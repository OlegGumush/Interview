package com.interview.Algorithm_01;

// Write a function that reverses a string. The input string is given as an array of characters s.

import java.util.Arrays;

public class LeetCode_0344 {

    public static void main(String[] args) {

        char arr[] = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseString(char[] s) {

        if (s.length <= 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        char temp;
        while (i < j) {
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}