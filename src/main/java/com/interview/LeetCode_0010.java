package com.interview;

public class LeetCode_0010 {

    public static void main(String[] args) {

        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("bbb", "..."));

    }
    public static boolean isMatch(String s, String p) {

        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (!s.isEmpty() && p.isEmpty()) {
            return false;
        }
        // s.isEmpty() && !p.isEmpty() can be true

        boolean isFirstChangeMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) // Take zero characters
                    ||
                   (isFirstChangeMatch && isMatch(s.substring(1), p)); // Take 1 character only if there was a match
        } else {
            return isFirstChangeMatch && isMatch(s.substring(1), p.substring(1)); // Take 1 character from both only if there was a match
        }
    }
}