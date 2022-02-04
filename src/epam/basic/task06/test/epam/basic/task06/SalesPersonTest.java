package epam.basic.task06;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalesPersonTest {

    @Test
    void setBonusless100() {
        SalesPerson person = new SalesPerson("Taras", new BigDecimal(15000), 50);
        person.setBonus(new BigDecimal(1000));
        person.setBonus();
        assertEquals(new BigDecimal(1000), person.getBonus());
    }

    @Test
    void setBonusbiger100() {
        SalesPerson person = new SalesPerson("Taras", new BigDecimal(15000), 120);
        person.setBonus(new BigDecimal(1000));
        person.setBonus();
        assertEquals(new BigDecimal(2000), person.getBonus());
    }

    @Test
    void setBonusbiger200() {
        SalesPerson person = new SalesPerson("Taras", new BigDecimal(15000), 210);
        person.setBonus(new BigDecimal(1000));
        person.setBonus();
        assertEquals(new BigDecimal(3000), person.getBonus());
    }

    @Test
    void setBonus() {
    }
}