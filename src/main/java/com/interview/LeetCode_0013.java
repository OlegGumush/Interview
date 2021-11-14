package com.interview;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_0013 {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));

    }

    private static final Map<Character, Integer> translation = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String roman) {

        int result = 0;

        int i = 0;
        while (i < roman.length()) {

            if (i != (roman.length() - 1) && translation.get(roman.charAt(i)) < translation.get(roman.charAt(i + 1))) {
                result += translation.get(roman.charAt(i + 1)) - translation.get(roman.charAt(i));
                i+=2;
            } else {
                result += translation.get(roman.charAt(i));
                i++;
            }
        }
        return result;
    }
}