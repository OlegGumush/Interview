package leet.code;

public class LeetCode_0009 {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(1214321));
        System.out.println();
        System.out.println(internalSolution(121));
        System.out.println(internalSolution(-121));
        System.out.println(internalSolution(10));
        System.out.println(internalSolution(0));
        System.out.println(internalSolution(123321));
        System.out.println(internalSolution(1234321));
        System.out.println(internalSolution(1214321));
    }

    public static boolean internalSolution(int x) {

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