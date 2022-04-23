package epam.advanced.practice5.task10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        Broker[] brokers = new Broker[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            brokers[i] = new Broker(i, 1000, exchange);
        }
        Request[] requests = new Request[]{
                new Request(RequestType.BUY, "VWG", 20, 10, brokers[4]),
                new Request(RequestType.BUY, "LNV", 50, 3, brokers[5]),
                new Request(RequestType.SELL, "VWG", 10, 10, brokers[0]),
                new Request(RequestType.BUY, "VWG", 10, 10, brokers[1]),
                new Request(RequestType.SELL, "HPG", 15, 11, brokers[2]),
                new Request(RequestType.SELL, "LNV", 50, 3, brokers[3]),
                new Request(RequestType.BUY, "VWG", 30, 8, brokers[6]),
                new Request(RequestType.BUY, "VWG", 40, 5, brokers[7]),
                new Request(RequestType.BUY, "VWG", 100, 3, brokers[8]),
                new Request(RequestType.BUY, "HPG", 15, 11, brokers[9]),
        };
        System.out.println("Brokers");
        for (var broker : brokers){
            System.out.println(broker);
            broker.start();
        }

        exchange.openBargain();
    }
}
