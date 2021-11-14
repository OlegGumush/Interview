package leet.code;

public class LeetCode_0014 {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        String result = "";
        if (strs.length == 0) {
            return result;
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i >= s.length() || c != s.charAt(i)) {
                    return result;
                }
                continue;
            }
            result += c;
        }

        return result;
    }
}