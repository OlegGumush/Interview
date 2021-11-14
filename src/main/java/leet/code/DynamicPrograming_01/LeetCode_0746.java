package leet.code.DynamicPrograming_01;

//        746. Min Cost Climbing Stairs
//        You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
//        You can either start from the step with index 0, or the step with index 1.
//        Return the minimum cost to reach the top of the floor.

public class LeetCode_0746 {

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{0, 0, 1, 1}));

    }

    public static int minCostClimbingStairs(int[] cost) {

        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int arr[] = new int[cost.length + 1];
        arr[0] = cost[0];
        arr[1] = cost[1];

        int i = 2;
        while (i < cost.length) {
            if (arr[i - 2] < arr[i - 1]) {
                arr[i] = arr[i - 2] + cost[i];
            } else {
                arr[i] = arr[i - 1] + cost[i];
            }
            i++;
        }
        return Math.min(arr[cost.length - 1], arr[cost.length - 2]);
    }

    ///////////////////////////////// Recursion ////////////////////////////////////////
    public static int minCostClimbingStairs1(int[] cost) {

        return Math.min(minCostClimbingStairs1(cost, 0, 0), minCostClimbingStairs1(cost, 1, 0));
    }

    public static int minCostClimbingStairs1(int[] cost, int index, int sum) {

        if (index >= cost.length) {
            return sum;
        }
        sum += cost[index];

        return Math.min(minCostClimbingStairs1(cost, index + 1, sum), minCostClimbingStairs1(cost, index + 2, sum));
    }
}