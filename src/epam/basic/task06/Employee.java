package epam.basic.task06;

import java.math.BigDecimal;

public abstract class Employee {
    private String name;
    private BigDecimal salary;
    private BigDecimal bonus;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee(String name, BigDecimal salary) {
        setName(name);
        setSalary(salary);
        setBonus(new BigDecimal(0));
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus){
        this.bonus = bonus;
    }

    abstract void setBonus();

    public BigDecimal toPay(){
        return getSalary().add(bonus);
    }
}
