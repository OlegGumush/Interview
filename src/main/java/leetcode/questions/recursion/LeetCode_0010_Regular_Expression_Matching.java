package leetcode.questions.recursion;

//        10. Regular Expression Matching
//        Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//        '.' Matches any single character.​​​​
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//
//        Example 1:
//        Input: s = "aa", p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".

//        Example 2:
//        Input: s = "aa", p = "a*"
//        Output: true
//        Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

//        Example 3:
//        Input: s = "ab", p = ".*"
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".

//        Example 4:
//        Input: s = "aab", p = "c*a*b"
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

//        Example 5:
//        Input: s = "mississippi", p = "mis*is*p*."
//        Output: false

public class LeetCode_0010_Regular_Expression_Matching {

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