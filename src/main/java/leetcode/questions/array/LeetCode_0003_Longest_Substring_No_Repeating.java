package leetcode.questions.array;

//        3. Longest Substring Without Repeating Characters
//        Given a string s, find the length of the longest substring without repeating characters.
//
//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//
//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//
//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//        Example 4:
//        Input: s = ""
//        Output: 0

public class LeetCode_0003_Longest_Substring_No_Repeating {

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int bruteForce(String s) {

        int map[] = new int[256];
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sequence = 0;
                map = new int[256];
                for (int k = i; k < n; k++) {
                    char c = s.charAt(k);
                    if (map[c] == 0) {
                        sequence++;
                        map[c]++;
                        if (sequence > result) {
                            result = sequence;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static int lengthOfLongestSubstring(String s) {

        int map[] = new int[256];
        int startWindow = 0;
        int endWindow = 0;
        int result = 0;

        while (endWindow < s.length()) {

            char c = s.charAt(endWindow);

            if (map[c] == 1) {
                while (s.charAt(startWindow) != c) {
                    map[s.charAt(startWindow)]--;
                    startWindow++;
                }
                map[s.charAt(startWindow)]--;
                startWindow++;
            }

            // calculate window size
            map[c]++;
            result = Math.max(result, endWindow - startWindow + 1);
            endWindow++;
        }

        return result;
    }
}