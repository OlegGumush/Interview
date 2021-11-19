package leet.code.questions;

import java.util.ArrayList;
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

public class LeetCode_0056_TODO {

    public static void main(String[] args) {

        int invervals[][] = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int invervals1[][] = new int[][]{
                {1, 4},
                {0, 4},
        };


        System.out.println(merge(invervals1));
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();

        int current[] = intervals[0];

        int i = 1;
        while (i < intervals.length) {

            int[] next = intervals[i];
            if (next[0] > current[1]) {
                result.add(current);
                current = next;
                i++;
                continue;
            }
            if (next[1] < current[0]) {
                result.add(next);
                i++;
                continue;
            }
            if (current[0] <= next[0] && current[1] >= next[1]) {
                // nothing
                System.out.println();
            } else if (next[0] <= current[0] && next[1] >= current[1]) {
                current = next;
            } else if (next[0] <= current[0] && next[1] <= current[1]) {
                current[0] = next[0];
            } else if (next[0] <= current[1] && next[1] >= current[1]) {
                current[1] = next[1];
            }
            i++;
        }
        result.add(current);


        int arr[][] = new int[result.size()][2];
        for (int k = 0; k < result.size(); k++) {
            arr[k] = result.get(k);
        }
        return arr;
    }
}