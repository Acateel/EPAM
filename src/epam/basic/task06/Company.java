package epam.basic.task06;

import java.math.BigDecimal;

public class Company {
    private Employee[] staff;

    public Company(Employee[] staff) {
        this.staff = staff;
    }

    public void giveEverbodyBonus(BigDecimal money) {
        for (Employee employee : staff) {
            employee.setBonus(money);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal total = new BigDecimal(0);

        for (Employee employee : staff) {
            total = total.add(employee.toPay());
        }

        return total;
    }

    public String nameMaxSalary() {
        String name = staff[0].getName();
        BigDecimal maxSalary = staff[0].toPay();

        for (Employee employee : staff) {
            maxSalary = maxSalary.max(employee.toPay());
            if (maxSalary.equals(employee.toPay())) {
                name = employee.getName();
            }
        }

        return name;
    }
}
