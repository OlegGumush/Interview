package leet.code.DataStructure_01;

//        566. Reshape the Matrix
//
//        In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
//
//        You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
//
//        The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
//
//        If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

import java.util.ArrayList;
import java.util.List;

public class LeetCode_0566 {

    public static void main(String[] args) {

        int arr1[][] = {{1, 2, 3}, {4, 9, 8}};

        System.out.println(matrixReshape(arr1, 3, 2));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int newMat[][] = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                newMat[row][col++] = mat[i][j];
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return newMat;
    }
}