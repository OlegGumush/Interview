package leet.code.DynamicPrograming_01;

//   70. Climbing Stairs
//   You are climbing a staircase. It takes n steps to reach the top.
//   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class LeetCode_0070 {

    public static void main(String[] args) {

        System.out.println(climbStairs(25));
    }

    public static int climbStairs(int n) {
        int arr[] = new int[n];

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;

        for (int i = 2; i < n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}