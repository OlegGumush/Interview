package leet.code.questions;

//        151. Reverse Words in a String
//        Given an input string s, reverse the order of the words.
//
//        A word is defined as a sequence of non-space characters.
//        The words in s will be separated by at least one space.
//
//        Return a string of the words in reverse order concatenated by a single space.
//
//        Note that s may contain leading or trailing spaces or multiple spaces between two words.
//        The returned string should only have a single space separating the words. Do not include any extra spaces.

import tags.Facebook;

import java.util.ArrayList;
import java.util.List;

@Facebook(value = "005", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0151 {

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        String[] split = s.trim().split("\\s+");

        int i = 0;
        int j = split.length - 1;
        while (i < j) {
            String temp = split[i];
            split[i] = split[j];
            split[j] = temp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (j = 0; j < split.length; j++) {
            for (int k = 0; k < split[j].length(); k++) {
                sb.append(split[j].charAt(k));
            }
            if (j != split.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    public static String reverseWords1(String s) {

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                chars.add(s.charAt(i));
                continue;
            }
            if (i != 0 && s.charAt(i - 1) != ' ') {
                chars.add(s.charAt(i));
            }
        }
        if (chars.get(chars.size() - 1) == ' ') {
            chars.remove(chars.size() - 1);
        }
        reverse(chars, 0, chars.size() - 1);

        int start = 0;
        int end = 0;
        while (end < chars.size() - 1) {
            if (chars.get(end) == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        reverse(chars, start, end);

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < chars.size(); j++) {
            sb.append(chars.get(j));
        }
        return sb.toString();
    }

    public static void reverse(List<Character> arr, int i, int j) {

        char temp;
        while (i < j) {
            temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }
}