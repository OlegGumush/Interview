package leet.code.questions;

public class LeetCode_0007 {

    public static void main(String[] args) {

        System.out.println(reverse(12345));
        System.out.println(reverse(-12345));
        System.out.println(reverse(-123450));
        System.out.println(reverse(123450));
        System.out.println(reverse(0));
        System.out.println(reverse(9));
        System.out.println(reverse(-9));

        System.out.println(reverse(2147483647)); // 2147483640
        System.out.println(reverse(-2147483647));
        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {

        int result = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;

        while (x != 0) {
            int remainder = x % 10;

            if (result > max ||  (result == max && remainder > 7)) {
                return 0;
            }
            if (result < min ||  (result == min && remainder < -8)) {
                return 0;
            }
            result = result * 10;
            result += remainder;
            x = x / 10;
        }

        return result;
    }
}