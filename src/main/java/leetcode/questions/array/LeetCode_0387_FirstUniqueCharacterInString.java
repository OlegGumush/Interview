package leetcode.questions.array;

//        387. First Unique Character in a String
//        Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

import tags.Educative;
import tags.Type;

import java.util.HashMap;

@Educative(value = Type.Arrays)
public class LeetCode_0387_FirstUniqueCharacterInString {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}