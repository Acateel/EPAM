package epam.task09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void setElement() {
        Matrix matrix = new Matrix(5, 5);

        matrix.setElement(0, 1, 5.5);

        assertEquals(5.5, matrix.getMatrix()[0][1]);
    }

    @Test
    void addition() throws MatrixException {
        Matrix matrix = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        matrix = matrix.addition(matrix2);

        assertArrayEquals(new double[]{10, 10, 10}, matrix.getMatrix()[0]);
        assertArrayEquals(new double[]{10, 10, 10}, matrix.getMatrix()[1]);
        assertArrayEquals(new double[]{10, 10, 10}, matrix.getMatrix()[2]);
    }

    @Test
    void deduction() throws MatrixException {
        Matrix matrix = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        });

        matrix = matrix.deduction(matrix2);

        assertArrayEquals(new double[]{1, 1, 1}, matrix.getMatrix()[0]);
        assertArrayEquals(new double[]{1, 1, 1}, matrix.getMatrix()[1]);
        assertArrayEquals(new double[]{1, 1, 1}, matrix.getMatrix()[2]);
    }

    @Test
    void multiplication() throws MatrixException {
        Matrix matrix = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {4, 5, 6}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {4, 3, 7, 6}
        });

        matrix = matrix.multiplication(matrix2);

        assertArrayEquals(new double[]{23, 23, 38, 38}, matrix.getMatrix()[0]);
        assertArrayEquals(new double[]{53, 56, 89, 92}, matrix.getMatrix()[1]);
        assertArrayEquals(new double[]{83, 89, 140, 146}, matrix.getMatrix()[2]);
        assertArrayEquals(new double[]{53, 56, 89, 92}, matrix.getMatrix()[3]);
    }
    @Test
    void testException() {
        Matrix matrix = new Matrix(new double[][]{
                {1, 2},
                {4, 5}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {4, 3, 7, 6}
        });

        MatrixException exceptionAddition = assertThrows(MatrixException.class, () -> {
            Matrix matrix3 = matrix.addition(matrix2);
        });
        MatrixException exceptionDeduction = assertThrows(MatrixException.class, () -> {
            Matrix matrix3 = matrix.deduction(matrix2);
        });
        MatrixException exceptionMultiplication = assertThrows(MatrixException.class, () -> {
            Matrix matrix3 = matrix.multiplication(matrix2);
        });

        assertEquals("Operations with matrix of incompatible sizes", exceptionAddition.getMessage());
        assertEquals("Operations with matrix of incompatible sizes", exceptionDeduction.getMessage());
        assertEquals("Operations with matrix of incompatible sizes", exceptionMultiplication.getMessage());
        assertEquals(matrix, exceptionMultiplication.getFirstMatrix());
        assertEquals(matrix2, exceptionMultiplication.getSecondMatrix());
    }
    @Test
    void testException_in_constructor() {
        IllegalArgumentException exceptionRows = assertThrows(IllegalArgumentException.class, () -> {
            Matrix matrix = new Matrix(-6,6);
        });
        IllegalArgumentException exceptionColumn = assertThrows(IllegalArgumentException.class, () -> {
            Matrix matrix = new Matrix(6,0);
        });

        assertEquals("Illegal number of row or column", exceptionRows.getMessage());
        assertEquals("Illegal number of row or column", exceptionColumn.getMessage());
    }
    @Test
    void testException_in_setElement() {
        Matrix matrix = new Matrix(2,2);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            matrix.setElement(3,2, 5.5);
        });

        assertEquals("Illegal number of row or column", exception.getMessage());
    }
}