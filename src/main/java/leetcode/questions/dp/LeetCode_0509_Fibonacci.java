package leetcode.questions.dp;

//        509. Fibonacci Number
//        The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
//        such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//        F(0) = 0, F(1) = 1
//        F(n) = F(n - 1) + F(n - 2), for n > 1.
//        Given n, calculate F(n).

//        Example 1:
//        Input: n = 2
//        Output: 1
//        Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

//        Example 2:
//        Input: n = 3
//        Output: 2
//        Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

public class LeetCode_0509_Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibArray(3));
        System.out.println(fibArray(10));

        System.out.println(fibWithoutArray(3));
        System.out.println(fibWithoutArray(10));
    }

    public static int fibArray(int n) {

        if (n <= 1) {
            return n;
        }
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static int fibWithoutArray(int n) {

        if (n <= 1) {
            return n;
        }
        int p1 = 0;
        int p2 = 1;
        int result = -1;

        for (int i = 2; i < n + 1; i++) {
            result = p1 + p2;
            p1 = p2;
            p2 = result;
        }
        return result;
    }
}