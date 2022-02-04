package epam.basic.task06;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void giveEverbodyBonus() {
        SalesPerson person1 = new SalesPerson("Taras", new BigDecimal(10_000), 120);
        SalesPerson person2 = new SalesPerson("Oleksiy", new BigDecimal(15_000), 260);
        Manager person3 = new Manager("Den", new BigDecimal(25_000), 160);
        Manager person4 = new Manager("Alica", new BigDecimal(20_000), 210);

        Company company = new Company(new Employee[]{
                person1,
                person2,
                person3,
                person4
        });

        company.giveEverbodyBonus(new BigDecimal(1000));
        assertEquals(new BigDecimal(1000), person1.getBonus());
        assertEquals(new BigDecimal(1000), person2.getBonus());
        assertEquals(new BigDecimal(1000), person3.getBonus());
        assertEquals(new BigDecimal(1000), person4.getBonus());

    }

    @Test
    void totalToPay() {
        SalesPerson person1 = new SalesPerson("Taras", new BigDecimal(10_000), 120);
        SalesPerson person2 = new SalesPerson("Oleksiy", new BigDecimal(15_000), 260);
        Manager person3 = new Manager("Den", new BigDecimal(25_000), 160);
        Manager person4 = new Manager("Alica", new BigDecimal(20_000), 210);

        Company company = new Company(new Employee[]{
                person1,
                person2,
                person3,
                person4
        });

        assertEquals(person1.toPay().add(person2.toPay()).add(person3.toPay()).add(person4.toPay()),
                company.totalToPay());

        company.giveEverbodyBonus(new BigDecimal(1000));

        assertEquals(person1.toPay().add(person2.toPay()).add(person3.toPay()).add(person4.toPay()),
                company.totalToPay());
    }

    @Test
    void nameMaxSalary() {
        SalesPerson person1 = new SalesPerson("Taras", new BigDecimal(10_000), 120);
        SalesPerson person2 = new SalesPerson("Oleksiy", new BigDecimal(15_000), 260);
        Manager person3 = new Manager("Den", new BigDecimal(25_000), 160);
        Manager person4 = new Manager("Alica", new BigDecimal(20_000), 210);

        Company company = new Company(new Employee[]{
                person1,
                person2,
                person3,
                person4
        });

        String name = company.nameMaxSalary();
        assertEquals(person3.getName(), name);
    }
}