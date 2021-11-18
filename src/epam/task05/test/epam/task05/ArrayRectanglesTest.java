package epam.task05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRectanglesTest {


    @Test
    void addRectangle() {
        ArrayRectangles rectangles = new ArrayRectangles(1);
        assertTrue(rectangles.addRectangle(new Rectangle()));
        assertFalse(rectangles.addRectangle(new Rectangle()));
        Rectangle[] rectangles1 = new Rectangle[]{new Rectangle()};
        rectangles = new ArrayRectangles(rectangles1);
        assertFalse(rectangles.addRectangle(new Rectangle()));
    }

    @Test
    void numberMaxArea() {
        ArrayRectangles rectangles = new ArrayRectangles(3);
        rectangles.addRectangle(new Rectangle(5, 5));
        rectangles.addRectangle(new Rectangle(6));
        rectangles.addRectangle(new Rectangle());
        assertEquals(1, rectangles.numberMaxArea());
    }

    @Test
    void numberMinPerimeter() {
        ArrayRectangles rectangles = new ArrayRectangles(3);
        rectangles.addRectangle(new Rectangle(5, 5));
        rectangles.addRectangle(new Rectangle(6));
        rectangles.addRectangle(new Rectangle());
        assertEquals(2, rectangles.numberMinPerimeter());
    }

    @Test
    void numberSquare() {
        ArrayRectangles rectangles = new ArrayRectangles(3);
        rectangles.addRectangle(new Rectangle(5, 5));
        rectangles.addRectangle(new Rectangle(6));
        rectangles.addRectangle(new Rectangle());
        assertEquals(1, rectangles.numberSquare());
    }

    @Test
    void testException(){
        ArrayRectangles rectangles = new ArrayRectangles(0);
        ArrayIndexOutOfBoundsException exception1 = assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
           int index = rectangles.numberMaxArea();
        });
        ArrayIndexOutOfBoundsException exception2 = assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int index = rectangles.numberMinPerimeter();
        });
        ArrayIndexOutOfBoundsException exception3 = assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int index = rectangles.numberSquare();
        });
        assertEquals("Rectangle array is empty", exception1.getMessage());
        assertEquals("Rectangle array is empty", exception2.getMessage());
        assertEquals("Rectangle array is empty", exception3.getMessage());
    }
}