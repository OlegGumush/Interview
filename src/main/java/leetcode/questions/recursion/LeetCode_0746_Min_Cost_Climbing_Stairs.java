package leetcode.questions.recursion;

//        746. Min Cost Climbing Stairs
//        You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
//        You can either start from the step with index 0, or the step with index 1.
//        Return the minimum cost to reach the top of the floor.

public class LeetCode_0746_Min_Cost_Climbing_Stairs {

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{0, 0, 1, 1}));

    }

    public static int minCostClimbingStairs(int[] cost) {

        return Math.min(minCostClimbingStairs(cost, 0, 0), minCostClimbingStairs(cost, 1, 0));
    }

    public static int minCostClimbingStairs(int[] cost, int index, int sum) {

        if (index >= cost.length) {
            return sum;
        }
        sum += cost[index];

        return Math.min(minCostClimbingStairs(cost, index + 1, sum), minCostClimbingStairs(cost, index + 2, sum));
    }
}