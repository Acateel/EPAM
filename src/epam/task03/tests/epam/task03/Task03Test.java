package epam.task03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task03Test {

    @Test
    void testMultArithmeticElements() {
        long result = Task03.multArithmeticElements(5,3,4);
        assertEquals(6160, result);
    }
}