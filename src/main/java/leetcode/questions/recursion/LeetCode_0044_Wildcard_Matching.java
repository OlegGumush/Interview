package leetcode.questions.recursion;

//        44. Wildcard Matching
//        Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
//        '?' Matches any single character.
//        '*' Matches any sequence of characters (including the empty sequence).
//        The matching should cover the entire input string (not partial).
//
//        Example 1:
//        Input: s = "aa", p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
//
//        Example 2:
//        Input: s = "aa", p = "*"
//        Output: true
//        Explanation: '*' matches any sequence.
//
//        Example 3:
//        Input: s = "cb", p = "?a"
//        Output: false
//        Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
//
//        Example 4:
//        Input: s = "adceb", p = "*a*b"
//        Output: true
//        Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
//
//        Example 5:
//        Input: s = "acdcb", p = "a*c?b"
//        Output: false

public class LeetCode_0044_Wildcard_Matching {

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