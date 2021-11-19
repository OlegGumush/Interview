package leet.code.questions;

//        14. Longest Common Prefix
//        Write a function to find the longest common prefix string amongst an array of strings.
//        If there is no common prefix, return an empty string "".

//        Example 1:
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"

//        Example 2:
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.

public class LeetCode_0014 {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        String result = "";
        if (strs.length == 0) {
            return result;
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i >= s.length() || c != s.charAt(i)) {
                    return result;
                }
                continue;
            }
            result += c;
        }

        return result;
    }
}