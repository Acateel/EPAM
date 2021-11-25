package epam.task07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDepositTest {

    @Test
    void income() {
        SpecialDeposit deposit = new SpecialDeposit(1000.0, 12);

        double income = deposit.income();

        assertEquals(1115.7, income, 0.01);
    }
}