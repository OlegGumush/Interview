package leet.code.questions;

import tags.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//        56. Merge Intervals
//        Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//        Example 1:
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

//        Example 2:
//        Input: intervals = [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

@Facebook(value = "002", description = "https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions")
public class LeetCode_0056 {

    public static void main(String[] args) {

        int invervals[][] = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int invervals1[][] = new int[][]{
                {1, 4},
                {2, 3}
        };
        int[][] merge = merge(invervals1);
        System.out.println(merge);
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int current[] = intervals[0];

        int i = 1;
        while (i < intervals.length) {

            int[] next = intervals[i];

            if (current[1] < next[0]) {
                result.add(current);
                current = next;
            } else if (next[1] > current[1]) {
                current[1] = next[1];
            }
            i++;
        }
        result.add(current);
        return result.toArray(new int[0][0]);
    }
}