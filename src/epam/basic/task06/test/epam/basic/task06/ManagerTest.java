package epam.basic.task06;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void setBonusless100() {
        Manager manager = new Manager("Taras", new BigDecimal(15000), 85);
        manager.setBonus(new BigDecimal(1000));
        manager.setBonus();
        assertEquals(new BigDecimal(1000), manager.getBonus());
    }

    @Test
    void setBonusbigger100() {
        Manager manager = new Manager("Taras", new BigDecimal(15000), 125);
        manager.setBonus(new BigDecimal(1000));
        manager.setBonus();
        assertEquals(new BigDecimal(1500), manager.getBonus());
    }

    @Test
    void setBonusbigger200() {
        Manager manager = new Manager("Taras", new BigDecimal(15000), 258);
        manager.setBonus(new BigDecimal(1000));
        manager.setBonus();
        assertEquals(new BigDecimal(2000), manager.getBonus());
    }
}