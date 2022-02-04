package epam.basic.task07.test.epam.task07;

import epam.basic.task07.BaseDeposit;
import epam.basic.task07.Client;
import epam.basic.task07.LongDeposit;
import epam.basic.task07.SpecialDeposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void addDeposit() {
        Client client = new Client();
        assertTrue(client.addDeposit(new BaseDeposit(1000, 12)));

        for (int i = 0; i < 9; i++) {
            client.addDeposit(new LongDeposit(1000.0, 18));
        }

        assertFalse(client.addDeposit(new BaseDeposit(1000, 12)));
    }

    @Test
    void totalIncome() {
        Client client = new Client();
        client.addDeposit(new BaseDeposit(1000, 12));
        client.addDeposit(new SpecialDeposit(1000, 12));
        client.addDeposit(new LongDeposit(1000, 12));

        double total = client.totalIncome();

        assertEquals(3224.61, total, 0.03);
    }

    @Test
    void maxIncome() {
        Client client = new Client();
        client.addDeposit(new BaseDeposit(1000, 12));
        client.addDeposit(new SpecialDeposit(1000, 12));
        client.addDeposit(new LongDeposit(1000, 12));

        double max = client.maxIncome();

        assertEquals(1313.06, max, 0.01);
    }

    @Test
    void getIncomeByNumber() {
        Client client = new Client();
        client.addDeposit(new BaseDeposit(1000, 12));
        client.addDeposit(new SpecialDeposit(1000, 12));
        client.addDeposit(new LongDeposit(1000, 12));

        assertEquals(0, client.getIncomeByNumber(0));
        assertEquals(1115.7, client.getIncomeByNumber(2), 0.01);
        assertEquals(0, client.getIncomeByNumber(5));
    }
}