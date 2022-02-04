package epam.basic.task07.test.epam.task07;

import epam.basic.task07.LongDeposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongDepositTest {

    @Test
    void income() {
        LongDeposit deposit = new LongDeposit(1000,12);

        double income = deposit.income();

        assertEquals(1313.06, income, 0.01);
    }
}