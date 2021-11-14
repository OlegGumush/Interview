package leet.code;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_0020 {

    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("{]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{}("));
    }

    public static boolean isValid(String s) {

        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.remove(stack.size() - 1);
                if (pop == '(' && c == ')') {
                    continue;
                }
                if (pop == '[' && c == ']') {
                    continue;
                }
                if (pop == '{' && c == '}') {
                    continue;
                }
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}