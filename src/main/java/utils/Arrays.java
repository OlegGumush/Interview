package utils;

public class Arrays {

    public static void print(int mat[][]) {
        for (int k = 0; k < mat.length; k++) {
            System.out.println();
            for (int l = 0; l < mat[0].length; l++) {
                System.out.print(mat[k][l] + " ");
            }
        }
        System.out.println();
    }
}
