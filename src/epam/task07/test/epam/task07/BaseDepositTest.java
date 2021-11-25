package epam.task07;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BaseDepositTest {

    @Test
    void income() {
        BaseDeposit deposit = new BaseDeposit(1000.0, 12);

        double income = deposit.income();

        assertEquals(795.85, income, 0.01);
    }
}