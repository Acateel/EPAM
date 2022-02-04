package epam.basic.task06;

import java.math.BigDecimal;

public class SalesPerson extends Employee {
    private int percent;

    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);
        this.percent = percent;
    }

    @Override
    public void setBonus() {
        if(percent > 200){
            setBonus(getBonus().multiply(new BigDecimal(3)));
        }
        else if(percent > 100){
            setBonus(getBonus().multiply(new BigDecimal(2)));
        }
    }
}
