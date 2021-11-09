/*
Task 3.
In a predetermined two-dimensional integer array (square matrix) matrix
insert  0  into  elements  to  the  left  side  of  the  main  diagonal,  and  1  into
elements to the right side of the diagonal.
Example,
{{2, 4, 3, 3},
 {5, 7, 8, 5},
 {2, 4, 3, 3},
 {5, 7, 8, 5}}

=>

{{2, 1, 1, 1},
 {0, 7, 1, 1},
 {0, 0, 3, 1},
 {0, 0, 0, 5}}

 */

package epam.task02;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        int[][] matrix;
        //matrix = getMatrixInConsole();
        matrix = getMatrixExample();

        changeMatrix(matrix);

        showMatrixInConsole(matrix);
    }

    private static void changeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > j) {
                    matrix[i][j] = 0;
                } else if (i < j) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    private static void showMatrixInConsole(int[][] matrix) {
        for (int[] row : matrix) {
            for (int sell : row) {
                System.out.print(sell + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixInConsole() {
        System.out.println("Write size:");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Write matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] getMatrixExample() {
        return new int[][]{
                {2, 4, 3, 3},
                {5, 7, 8, 5},
                {2, 4, 3, 3},
                {5, 7, 8, 5}};
    }


}
