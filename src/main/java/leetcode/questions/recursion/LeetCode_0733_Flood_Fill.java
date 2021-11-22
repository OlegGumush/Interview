package leetcode.questions.recursion;


//        733. Flood Fill
//
//        An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//        You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from
//        the pixel image[sr][sc].
//        To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
//        pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
//        (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
//        Return the modified image after performing the flood fill.
//
//        Example 1:
//        Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
//        Output: [[2,2,2],[2,2,0],[2,0,1]]
//        Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
//        all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels)
//        are colored with the new color.
//        Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
//
//        Example 2:
//        Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
//        Output: [[2,2,2],[2,2,2]]

import utils.Arrays;

public class LeetCode_0733_Flood_Fill {

    public static void main(String[] args) {

        int mat[][] = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        mat = floodFill(mat, 1, 1, 2);
        Arrays.print(mat);

        int mat1[][] = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        mat1 = floodFill(mat1, 0, 0, 2);
        Arrays.print(mat1);

        int mat2[][] = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        mat2 = floodFill(mat2, 1, 0, 2);
        Arrays.print(mat2);
    }

    public static int[][] floodFill(int[][] image, int i, int j, int newColor) {

        int[][] result = new int[image.length][image[0].length];
        for (int k = 0; k < result.length; k++) {
            for (int l = 0; l < result[0].length; l++) {
                result[k][l] = image[k][l];
            }
        }
        int initialColor = image[i][j];
        boolean visited[][] = new boolean[image.length][image[0].length];

        return floodFill(image, i, j, newColor, initialColor, visited, result);
    }

    private static int[][] floodFill(int[][] image, int i, int j, int newColor, int initialColor, boolean[][] visited, int[][] result) {

        if (i < 0 || i >= image.length) {
            return result;
        }
        if (j < 0 || j >= image[0].length) {
            return result;
        }
        if (visited[i][j]) {
            return result;
        }
        visited[i][j] = true;

        if (image[i][j] == initialColor) {
            result[i][j] = newColor;
        } else {
            return result;
        }

        floodFill(image, i - 1, j, newColor, initialColor, visited, result);
        floodFill(image, i + 1, j, newColor, initialColor, visited, result);
        floodFill(image, i, j - 1, newColor, initialColor, visited, result);
        floodFill(image, i, j + 1, newColor, initialColor, visited, result);

        return result;
    }

    ///////////////////////////////////// Internet //////////////////////////////////////////////////////////

    public static int[][] floodFillInternet(int[][] image, int i, int j, int newColor) {

        int initialColor = image[i][j];
        if (initialColor == newColor) {
            return image;
        }
        floodFillInternet(image, i, j, newColor, initialColor);
        return image;
    }

    private static void floodFillInternet(int[][] image, int i, int j, int newColor, int initialColor) {

        if (i < 0 || i >= image.length) {
            return;
        }
        if (j < 0 || j >= image[0].length) {
            return;
        }
        if (image[i][j] != initialColor) {
            return;
        }
        image[i][j] = newColor;
        floodFillInternet(image, i - 1, j, newColor, initialColor);
        floodFillInternet(image, i + 1, j, newColor, initialColor);
        floodFillInternet(image, i, j - 1, newColor, initialColor);
        floodFillInternet(image, i, j + 1, newColor, initialColor);
    }
}