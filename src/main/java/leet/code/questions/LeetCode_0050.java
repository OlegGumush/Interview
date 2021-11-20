package leet.code.questions;

//        50. Pow(x, n)
//        Example 1:
//
//        Input: x = 2.00000, n = 10
//        Output: 1024.00000
//        Example 2:
//
//        Input: x = 2.10000, n = 3
//        Output: 9.26100
//        Example 3:
//
//        Input: x = 2.00000, n = -2
//        Output: 0.25000
//        Explanation: 2-2 = 1/22 = 1/4 = 0.25

import tags.Facebook;

@Facebook(value = "008", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0050 {

    public static void main(String[] args) {

        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(0.00001, 2147483647));

    }

    public static double myPow(double x, int n) {

        double result = pow(x, n > 0 ? n : n * -1);
        return n < 0 ? 1 / result : result;
    }

    public static double pow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = pow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return x * result * result;
        }
    }
}