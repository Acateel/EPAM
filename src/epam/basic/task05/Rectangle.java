package epam.basic.task05;

public class Rectangle {
    double sideA;
    double sideB;

    public Rectangle(double sideA, double sideB) throws ExceptionInInitializerError {
        if(sideA<=0 || sideB <= 0)
            throw new ExceptionInInitializerError("Not correct data");
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double sideA) {
        this(sideA, 5);
    }

    public Rectangle() {
        this(4, 3);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area(){
        return sideA * sideB;
    }

    public double perimeter(){
        return 2*(sideA + sideB);
    }

    public boolean isSquare(){
        return sideA == sideB;
    }

    public void replaceSides(){
        double temp = sideA;
        sideA = sideB;
        sideB = temp;
    }
}
