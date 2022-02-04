package epam.basic.task05;

public class ArrayRectangles {
    private Rectangle[] rectangle_array;
    private int lastIndex = 0;

    public ArrayRectangles(int length) {
        rectangle_array = new Rectangle[length];
        lastIndex = 0;
    }

    public ArrayRectangles(Rectangle... rectangles) {
        rectangle_array = rectangles;
        lastIndex = rectangle_array.length;
    }

    public boolean addRectangle(Rectangle rectangle) {
        if (lastIndex >= rectangle_array.length)
            return false;
        rectangle_array[lastIndex++] = rectangle;
        return true;
    }

    public int numberMaxArea() throws ArrayIndexOutOfBoundsException {
        if (lastIndex == 0)
            throw new ArrayIndexOutOfBoundsException("Rectangle array is empty");
        double maxArea = rectangle_array[0].area();
        int indexMaxArea = 0;
        for (int i = 0; i < lastIndex; i++) {
            if (rectangle_array[i].area() > maxArea) {
                maxArea = rectangle_array[i].area();
                indexMaxArea = i;
            }
        }
        return indexMaxArea;
    }

    public int numberMinPerimeter() throws ArrayIndexOutOfBoundsException {
        if (lastIndex == 0)
            throw new ArrayIndexOutOfBoundsException("Rectangle array is empty");
        double minPerimeter = rectangle_array[0].perimeter();
        int indexMinPerimeter = 0;
        for (int i = 0; i < lastIndex; i++) {
            if (minPerimeter > rectangle_array[i].perimeter()) {
                minPerimeter = rectangle_array[i].perimeter();
                indexMinPerimeter = i;
            }
        }
        return indexMinPerimeter;
    }

    public int numberSquare() throws ArrayIndexOutOfBoundsException {
        if (lastIndex == 0)
            throw new ArrayIndexOutOfBoundsException("Rectangle array is empty");
        int number = 0;
        for (int i = 0; i < lastIndex; i++) {
            if (rectangle_array[i].isSquare())
                number++;
        }
        return number;
    }
}
