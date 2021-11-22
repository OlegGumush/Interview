package leetcode.questions.number;

//        9. Palindrome Number
//        Given an integer x, return true if x is palindrome integer.
//
//        An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
//
//        Example 1:
//        Input: x = 121
//        Output: true

//        Example 2:
//        Input: x = -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

//        Example 3:
//        Input: x = 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

//        Example 4:
//        Input: x = -101
//        Output: false

public class LeetCode_0009_Palindrome_Number {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(1214321));
        System.out.println();
        System.out.println(internetSolution(121));
        System.out.println(internetSolution(-121));
        System.out.println(internetSolution(10));
        System.out.println(internetSolution(0));
        System.out.println(internetSolution(123321));
        System.out.println(internetSolution(1234321));
        System.out.println(internetSolution(1214321));
    }

    public static boolean internetSolution(int x) {

        if (x < 0) {
            return false;
        }
        int reverseNumber = 0;
        int temp = x;

        while (temp != 0) {
            reverseNumber = (reverseNumber * 10) + (temp % 10);
            temp = temp / 10;
        }

        return reverseNumber == x;
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        int numberOfDigits = getNumberOfDigits(x);

        while (numberOfDigits > 1) {

            int last = x % 10;
            int temp = (int) Math.pow(10, numberOfDigits - 1);
            int first = x / temp;

            if (first != last) {
                return false;
            }
            x = x % temp;
            x = x / 10;

            numberOfDigits = numberOfDigits - 2;
        }

        return true;
    }

    private static int getNumberOfDigits(int x) {

        int digits = 0;
        while (x != 0) {
            x = x / 10;
            digits++;
        }
        return digits;
    }
}