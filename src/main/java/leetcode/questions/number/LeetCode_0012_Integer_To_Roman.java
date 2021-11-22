package leetcode.questions.number;

//        12. Integer to Roman
//        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//
//        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
//        The number 27 is written as XXVII, which is XX + V + II.
//        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
//        Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
//        The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
//        Given an integer, convert it to a roman numeral.
//
//        Example 1:
//        Input: num = 3
//        Output: "III"

//        Example 2:
//        Input: num = 4
//        Output: "IV"

//        Example 3:
//        Input: num = 9
//        Output: "IX"

//        Example 4:
//        Input: num = 58
//        Output: "LVIII"
//        Explanation: L = 50, V = 5, III = 3.

//        Example 5:
//        Input: num = 1994
//        Output: "MCMXCIV"
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

public class LeetCode_0012_Integer_To_Roman {

    public static void main(String[] args) {

        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));

    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int n = num / 1000;
        num = num % 1000;
        sb.append("M".repeat(n));

        n = num / 900;
        num = num % 900;
        sb.append("CM".repeat(n));

        n = num / 500;
        num = num % 500;
        sb.append("D".repeat(n));

        n = num / 400;
        num = num % 400;
        sb.append("CD".repeat(n));

        n = num / 100;
        num = num % 100;
        sb.append("C".repeat(n));

        n = num / 90;
        num = num % 90;
        sb.append("XC".repeat(n));

        n = num / 50;
        num = num % 50;
        sb.append("L".repeat(n));

        n = num / 40;
        num = num % 40;
        sb.append("XL".repeat(n));

        n = num / 10;
        num = num % 10;
        sb.append("X".repeat(n));

        n = num / 9;
        num = num % 9;
        sb.append("IX".repeat(n));

        n = num / 5;
        num = num % 5;
        sb.append("V".repeat(n));

        n = num / 4;
        num = num % 4;
        sb.append("IV".repeat(n));

        n = num / 1;
        sb.append("I".repeat(n));

        return sb.toString();
    }

    public static void getSequence(int num, String c, StringBuilder sb) {

        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
    }
}