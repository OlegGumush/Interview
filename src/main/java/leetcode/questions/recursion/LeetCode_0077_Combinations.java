package leetcode.questions.recursion;

//        77. Combinations
//        Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
//        You may return the answer in any order.

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=KukNnoN-SoY
public class LeetCode_0077_Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List combination = new ArrayList<>();

        combine(result, combination, n, k, 1);
        return result;
    }

    public static void combine(List<List<Integer>> result, List combination, int n, int k, int start) {

        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            combine(result, combination, n, k, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}


