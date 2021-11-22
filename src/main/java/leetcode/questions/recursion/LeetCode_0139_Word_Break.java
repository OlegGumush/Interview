package leetcode.questions.recursion;

//        139. Word Break
//        Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//        Note that the same word in the dictionary may be reused multiple times in the segmentation.

import tags.Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Facebook(value = "006", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions", video = "https://www.youtube.com/watch?v=Sx9NNgInc3A")
public class LeetCode_0139_Word_Break {

    // TODO - There is also a complicated DP solution
    public static void main(String[] args) {

        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Boolean> cache = new HashMap<>();
        return wordBreak(s, wordDict, cache);
    }

    private static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> cache) {

        if (cache.get(s) != null) {
            return cache.get(s);
        }
        if (s.isEmpty()) {
            return true;
        }
        boolean result = false;
        for (int i = 0; i < wordDict.size(); i++) {

            if (s.startsWith(wordDict.get(i))) {
                String newStr = s.substring(wordDict.get(i).length());
                boolean temp = wordBreak(newStr, wordDict, cache);
                cache.put(newStr, temp);
                result = result || temp;
            }
        }
        return result;
    }
}