package leetcode.questions.dp;

//        120. Triangle
//        Given a triangle array, return the minimum path sum from top to bottom.
//        For each step, you may move to an adjacent number of the row below. More formally,
//        if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//        Example 1:
//        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//        Output: 11
//        Explanation: The triangle looks like:
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

//        Example 2:
//        Input: triangle = [[-10]]
//        Output: -10


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.youtube.com/watch?v=KukNnoN-SoY
public class LeetCode_0120_Triangle_TODO {

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(2));
        arrays.add(Arrays.asList(3, 4));
        arrays.add(Arrays.asList(5, 6, 7));
        arrays.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(arrays));

        List<List<Integer>> arrays1 = new ArrayList<>();
        arrays1.add(Arrays.asList(-1));
        arrays1.add(Arrays.asList(2, 3));
        arrays1.add(Arrays.asList(1, -1, -3));
        System.out.println(minimumTotal(arrays1));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        // last row
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + (int) Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}


