package leetcode.questions.binarysearch;

//        74. Search a 2D Matrix
//        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//
//
//        Example 1:
//        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        Output: true

//        Example 2:
//        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//        Output: false

public class LeetCode_0074_Search_In_Matrix {

    public static void main(String[] args) {

        int mat[][] = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
                //{667, 6360, 9900, 60000}
        };
        System.out.println(searchMatrix(mat, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = matrix.length * matrix[0].length;

        while (start < end) {

            int middle = (start + end) / 2;
            int i = (middle / m);
            int j = middle - (i * m);

            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }
}
















