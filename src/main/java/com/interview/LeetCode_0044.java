package com.interview;

public class LeetCode_0044 {

    public static void main(String[] args) {
        System.out.println(isMatch("abbbbbbbbbbbb", ".*c"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*?"));
        System.out.println(isMatch("aa", "a?"));
        System.out.println(isMatch("", "*************"));
    }

    public static boolean isMatch(String s, String p) {

        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (!s.isEmpty() && p.isEmpty()) {
            return false;
        }
        boolean isStringEmpty = s.isEmpty();

        if (p.charAt(0) == '*') {
            return (!isStringEmpty && isMatch(s.substring(1), p)) || isMatch(s, p.substring(1));
        }
        if (isStringEmpty) {
            return false;
        }
        if (s.charAt(0) == p.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        }
        if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}