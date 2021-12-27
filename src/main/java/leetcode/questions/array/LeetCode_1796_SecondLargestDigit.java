package leetcode.questions.array;

//        387. First Unique Character in a String
//        Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

import tags.Educative;
import tags.Type;

@Educative(value = Type.Arrays)
public class LeetCode_1796_SecondLargestDigit {

    public static void main(String[] args) {

        System.out.println(secondHighest("abc1111"));
    }

    public static int secondHighest(String s) {
        if (s == null || s.length() == 1 || s.length() == 0) {
            return -1;
        }
        int max = -1;
        int secondMax = -1;

        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));

            if (digit < 0 || digit > 9 ) {
                continue;
            }
            if (digit == max) {
                continue;
            }
            if (max < digit) {
                secondMax = max;
                max = digit;
            } else if (secondMax < digit) {
                secondMax = digit;
            }
        }

        return secondMax;
    }
}