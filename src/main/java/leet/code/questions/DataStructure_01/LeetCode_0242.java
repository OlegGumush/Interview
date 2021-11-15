package leet.code.questions.DataStructure_01;

//        242. Valid Anagram
//        Given two strings s and t, return true if t is an anagram of s, and false otherwise.

//        Example 1:
//        Input: s = "anagram", t = "nagaram"
//        Output: true

//        Example 2:
//        Input: s = "rat", t = "car"
//        Output: false


public class LeetCode_0242 {

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "cat"));
        System.out.println(isAnagram("n1", "cx"));

    }

    public static boolean isAnagram(String s, String t) {

        int n = s.length(), m = t.length();
        if (n != m) {
            return false;
        }
        int[] chars = new int[26];

        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}