package epam.basic.task05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void getSideA() {
        assertEquals(8, new Rectangle(8,4).getSideA());
        assertEquals(8, new Rectangle(8).getSideA());
        assertEquals(4, new Rectangle().getSideA());
    }

    @Test
    void getSideB() {
        assertEquals(4, new Rectangle(8,4).getSideB());
        assertEquals(5, new Rectangle(8).getSideB());
        assertEquals(3, new Rectangle().getSideB());
    }

    @Test
    void area() {
        assertEquals(30, new Rectangle(6,5).area());
        assertEquals(30, new Rectangle(6).area());
        assertEquals(12, new Rectangle().area());
    }

    @Test
    void perimeter() {
        assertEquals(22, new Rectangle(6,5).perimeter());
        assertEquals(22, new Rectangle(6).perimeter());
        assertEquals(14, new Rectangle().perimeter());
    }

    @Test
    void isSquare() {
        assertTrue(new Rectangle(5,5).isSquare());
        assertTrue(new Rectangle(5).isSquare());

        assertFalse(new Rectangle(5,1).isSquare());
        assertFalse(new Rectangle().isSquare());
    }

    @Test
    void replaceSides() {
        Rectangle rectangle = new Rectangle(7,3);
        rectangle.replaceSides();
        assertEquals(3, rectangle.getSideA());
        assertEquals(7, rectangle.getSideB());
    }

    @Test
    void testException() {
        ExceptionInInitializerError exception = Assertions.assertThrows(ExceptionInInitializerError.class, ()->{
            Rectangle rectangle = new Rectangle(5,0);
        });
        Assertions.assertEquals("Not correct data", exception.getMessage());
    }
}