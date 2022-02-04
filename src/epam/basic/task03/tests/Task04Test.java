import epam.basic.task03.Task04;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task04Test {

    @Test
    void symGeometricElements() {
        int result = Task04.symGeometricElements(100,0.5,20);
        assertEquals(175, result);
    }
}