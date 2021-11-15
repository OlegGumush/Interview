package leet.code.questions.DynamicPrograming_01;

//        1137 Tribonacci
//        The Tribonacci sequence Tn is defined as follows:
//
//        T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//        Given n, return the value of Tn.
//        Example 1:
//        Input: n = 4
//        Output: 4
//        Explanation:
//        T_3 = 0 + 1 + 1 = 2
//        T_4 = 1 + 1 + 2 = 4
//
//        Example 2:
//        Input: n = 25
//        Output: 1389537
//
//        Constraints:
//        0 <= n <= 37
//        The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

public class LeetCode_1137 {

    public static void main(String[] args) {

        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {

        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int p1 = 0;
        int p2 = 1;
        int p3 = 1;
        int result = -1;

        for (int i = 3; i < n + 1; i++) {
            result = p1 + p2 + p3;
            p1 = p2;
            p2 = p3;
            p3 = result;
        }
        return result;
    }
}