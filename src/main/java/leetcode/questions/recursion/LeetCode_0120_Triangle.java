package leetcode.questions.recursion;

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
public class LeetCode_0120_Triangle {

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

        if (triangle.size() == 0) {
            return 0;
        }
        return minimumTotal(triangle, 0, 0, 0);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int sum, int level, int index) {

        if (level == triangle.size()) {
            return sum;
        }
        List<Integer> levelList = triangle.get(level);
        int minimum = Integer.MAX_VALUE;

        for (int i = index; i < index + 1; i++) {

            int currentValue = levelList.get(i) + sum;

            int result = Math.min(minimumTotal(triangle, currentValue, level + 1, i), minimumTotal(triangle, currentValue, level + 1, i + 1));
            if (result < minimum) {
                minimum = result;
            }
        }
        return minimum;
    }
}


