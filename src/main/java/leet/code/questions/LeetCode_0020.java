package leet.code.questions;

import java.util.ArrayList;
import java.util.List;

//        20. Valid Parentheses
//        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//
//        Example 1:
//        Input: s = "()"
//        Output: true

//        Example 2:
//        Input: s = "()[]{}"
//        Output: true
//
//        Example 3:
//        Input: s = "(]"
//        Output: false

//        Example 4:
//        Input: s = "([)]"
//        Output: false

//        Example 5:
//        Input: s = "{[]}"
//        Output: true

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