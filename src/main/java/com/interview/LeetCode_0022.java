package com.interview;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_0022 {

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