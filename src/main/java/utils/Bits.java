package utils;

public class Bits {

    public static void printBits(int number) {

        String s = "";

        while (number > 0) {
            if (number % 2 == 1) {
                s = "1" + s;
            } else {
                s = "0" + s;
            }
            number = number / 2;
        }
        System.out.println(s);
    }

    public static void printBitsString(int number) {

        System.out.println(Integer.toBinaryString(number));
    }
}
