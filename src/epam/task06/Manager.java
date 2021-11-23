package epam.task06;

import java.math.BigDecimal;

public class Manager extends Employee{
    private int quantity;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        quantity = clientAmount;
    }

    @Override
    void setBonus() {
        if (quantity > 150){
            setBonus(getBonus().add(new BigDecimal(1000)));
        }
        else if(quantity > 100){
            setBonus(getBonus().add(new BigDecimal(500)));
        }
    }
}
