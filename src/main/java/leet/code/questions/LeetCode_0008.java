package leet.code.questions;

public class LeetCode_0008 {

    public static void main(String[] args) {

        System.out.println(myAtoi("123123"));
        System.out.println(myAtoi("0000123123"));
        System.out.println(myAtoi("-0000123123"));
        System.out.println(myAtoi("asdasdasd-0000123123"));
        System.out.println(myAtoi("-0000123123 sdfsdfsfsdf"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("+1"));

        int num = (int) Math.pow(2, 31) - 1;
        System.out.println(myAtoi("" + num));
        num = (int) Math.pow(2, 31);
        System.out.println(myAtoi("" + num));
        num = (int) Math.pow(-2, 31);
        System.out.println(myAtoi("" + num));
        num = (int) Math.pow(-2, 31) - 1;
        System.out.println(myAtoi("" + num));
    }

    public static int myAtoi(String s) {

        boolean isPositive = true;
        int lowerBound = (int) Math.pow(-2, 31);
        int upperBound = ((int) Math.pow(2, 31));
        long number = 0;

        int k = 0;
        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                k++;
                continue;
            }
            if (c == '-') {
                isPositive = false;
                k++;
                break;
            }
            if (c == '+') {
                isPositive = true;
                k++;
                break;
            }
            break;
        }
        if (k < s.length() && (s.charAt(k) > '9' || s.charAt(k) < '0')) {
            return 0;
        }
        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > '9' || c < '0' ) {
                number = isPositive ? number : number * -1;
                return (int) number;
            }
            if (c == '0' && number == 0) {
                continue;
            }
            number = (number * 10) + (c - 48);
            if (isPositive && number > upperBound) {
                return upperBound ;
            }
            if (!isPositive && (number * -1) < lowerBound) {
                return lowerBound;
            }
        } 
        number = isPositive ? number : number * -1;
        return (int) number;
    }
}