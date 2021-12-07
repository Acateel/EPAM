package epam.task09;

public class MatrixException extends Exception {
    Matrix first;
    Matrix second;

    public Matrix getFirstMatrix() {
        return first;
    }

    public Matrix getSecondMatrix() {
        return second;
    }

    public MatrixException(String message, Matrix first, Matrix second) {
        super(message);
        this.first = first;
        this.second = second;
    }
}
