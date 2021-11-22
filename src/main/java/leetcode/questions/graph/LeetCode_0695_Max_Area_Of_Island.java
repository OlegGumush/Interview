package leetcode.questions.graph;

//        695. Max Area of Island
//
//        You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
//        You may assume all four edges of the grid are surrounded by water.
//        The area of an island is the number of cells with a value 1 in the island.
//        Return the maximum area of an island in grid. If there is no island, return 0.

public class LeetCode_0695_Max_Area_Of_Island {

    public static void main(String[] args) {

        int mat[][] = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println(maxAreaOfIsland(mat));
    }

    static boolean visited[][];

    public static int maxAreaOfIsland(int[][] grid) {

        int ans = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, maxAreaOfIsland(grid, visited, i, j));
            }
        }
        return ans;
    }

    private static int maxAreaOfIsland(int[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + maxAreaOfIsland(grid, visited, i, j - 1) + maxAreaOfIsland(grid, visited, i, j + 1) +
                maxAreaOfIsland(grid, visited, i - 1, j) + maxAreaOfIsland(grid, visited, i + 1, j);
    }
}