package leetcode.questions.bits;

//        231. Power of Two
//        Given an integer n, return true if it is a power of two. Otherwise, return false.
//        An integer n is a power of two, if there exists an integer x such that n == 2^x.
//
//        Example 1:
//        Input: n = 1
//        Output: true
//        Explanation: 2^0 = 1

//        Example 2:
//        Input: n = 16
//        Output: true
//        Explanation: 2^4 = 16

//        Example 3:
//        Input: n = 3
//        Output: false

//        Example 4:
//        Input: n = 4
//        Output: true

//        Example 5:
//        Input: n = 5
//        Output: false

public class LeetCode_0231_Power_Of_Two {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(-2147483648));
    }

    public static boolean isPowerOfTwo(int n) {

        if (n < 0) {
            return false;
        }
        int count = 0;
        while (n > 0) {
            int bit = n & 1;
            if (bit == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count == 1;
    }
}