package leet.code.DataStructure_01;

//        118. Pascal's Triangle
//        Given an integer numRows, return the first numRows of Pascal's triangle.
//        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//        Example 1:
//        Input: numRows = 5
//        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

//        Example 2:
//        Input: numRows = 1
//        Output: [[1]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode_0118 {

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));

        List<Integer> toAdd = null;

        for (int i = 2; i < numRows; i++) {

            toAdd = new ArrayList<>();
            toAdd.add(1);
            for (int j = 1; j < i; j++) {
                toAdd.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            toAdd.add(1);
            result.add(toAdd);
        }

        return result;
    }
}