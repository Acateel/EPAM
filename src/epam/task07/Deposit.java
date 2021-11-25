package epam.task07;

public abstract class Deposit {
    private double depositAmount;
    private int depositPeriod;

    public double amount() {
        return depositAmount;
    }

    private void setAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int period() {
        return depositPeriod;
    }

    private void setPeriod(int depositPeriod) {
        this.depositPeriod = depositPeriod;
    }

    protected Deposit(double depositAmount, int depositPeriod) {
        setAmount(depositAmount);
        setPeriod(depositPeriod);
    }

    abstract double income();
}
