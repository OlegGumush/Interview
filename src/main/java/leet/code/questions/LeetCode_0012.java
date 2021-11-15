package leet.code.questions;

public class LeetCode_0012 {

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