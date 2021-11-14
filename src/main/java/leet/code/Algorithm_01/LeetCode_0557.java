package leet.code.Algorithm_01;

//        Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//        Example 1:
//        Input: s = "Let's take LeetCode contest"
//        Output: "s'teL ekat edoCteeL tsetnoc"

//        Example 2:
//        Input: s = "God Ding"
//        Output: "doG gniD"

public class LeetCode_0557 {

    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {

        StringBuilder result = new StringBuilder();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                result.append(reverseString(s, j, i - 1)).append(' ');
                j = i + 1;
            }
        }
        result.append(reverseString(s, j, s.length() - 1));

        return result.toString();
    }

    public static String reverseString(String s, int start, int end) {

        if (s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        while (end >= start) {
            sb.append(s.charAt(end));
            end--;
        }
        return sb.toString();
    }
}