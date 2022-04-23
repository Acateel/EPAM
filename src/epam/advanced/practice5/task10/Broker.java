package epam.advanced.practice5.task10;

public class Broker extends Thread {
    private int brokerId;
    private int cash;
    private Request request;
    private Exchange exchange;

    public Broker(int brokerId, int cash, Exchange exchange) {
        this.brokerId = brokerId;
        this.cash = cash;
        this.exchange = exchange;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(int brokerId) {
        this.brokerId = brokerId;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void addCash(int cash){
        this.cash += cash;
    }

    public void withdrawCash(int cash){
        this.cash -= cash;
    }

    @Override
    public void run() {
        var latch = exchange.getBargainingState();
        try {
            latch.await();
            exchange.addRequest(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Broker " +
                "Id=" + brokerId +
                ", cash=" + cash;
    }
}
