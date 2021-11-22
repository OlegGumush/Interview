package leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;

//        22. Generate Parentheses
//        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//        Example 1:
//        Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]
//
//        Example 2:
//        Input: n = 1
//        Output: ["()"]

public class LeetCode_0022_GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        solve(result, "", n, n);
        return result;
    }

    private static void solve(List<String> result, String s, int openP, int closeP) {

        if (openP == 0 && closeP == 0) {
            result.add(s);
            return;
        }
        if (openP > closeP) {
            return;
        }
        if (openP > 0) {
            solve(result, s + "(", openP - 1, closeP);
        }
        solve(result, s + ")", openP, closeP - 1);
    }
}