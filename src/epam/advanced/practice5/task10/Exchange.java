package epam.advanced.practice5.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exchange {
    private List<Request> requestList = new ArrayList<>();
    private CountDownLatch bargainingState = new CountDownLatch(1);
    private Lock lockAdd = new ReentrantLock();
    private Condition condition = lockAdd.newCondition();

    public CountDownLatch getBargainingState() {
        return bargainingState;
    }

    public void addRequest(Request request) {
        try {
            lockAdd.lock();
            while (bargainingState.getCount() != 0) {
                bargainingState.await();
            }
            System.out.println("\nTry complete request\n" + request);
            if (!tryCompleteRequest(request)) {
                System.out.println("request did not complete, added in list");
                requestList.add(request);
                checkStatus();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockAdd.unlock();
        }
    }

    private boolean tryCompleteRequest(Request request) {
        if (request.getType() == RequestType.BUY) {
            return tryBuyShare(request);
        } else if (request.getType() == RequestType.SELL) {
            return trySellShare(request);
        }
        return false;
    }

    private boolean trySellShare(Request request) {
        Request sellRequest = findRequest(RequestType.BUY, request.getShareName(), request.getShareCount(), request.getSharePrice());
        if (sellRequest == null) {
            return false;
        }
        System.out.println("request complete");
        requestList.remove(sellRequest);
        int price = (int) ((sellRequest.getSharePrice() * sellRequest.getShareCount()) * (1.0 + getDeltaPrice(sellRequest.getShareName())));

        System.out.println("sell broker\n" + request.getBroker() + "+" + price);
        request.getBroker().addCash(price);

        System.out.println("buy broker\n" + sellRequest.getBroker() + "-" + price);
        sellRequest.getBroker().withdrawCash(price);
        return true;
    }

    private boolean tryBuyShare(Request request) {
        Request sellRequest = findRequest(RequestType.SELL, request.getShareName(), request.getShareCount(), request.getSharePrice());
        if (sellRequest == null) {
            return false;
        }
        System.out.println("request complete");
        requestList.remove(sellRequest);
        int price = (int) ((sellRequest.getSharePrice() * sellRequest.getShareCount()) * (1.0 - getDeltaPrice(sellRequest.getShareName())));

        System.out.println("buy broker\n" + request.getBroker() + "+" + price);
        request.getBroker().withdrawCash(price);

        System.out.println("sell broker\n" + sellRequest.getBroker() + "-" + price);
        sellRequest.getBroker().addCash(price);
        return true;
    }

    private double getDeltaPrice(String shareName) {
        int count = 0;
        for (var request : requestList) {
            if (request.getShareName().equals(shareName)) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return 1.0 / count;
    }

    private Request findRequest(RequestType type, String name, int count, int price) {
        for (var request : requestList) {
            if (request.getType() == type
                    && Objects.equals(request.getShareName(), name)
                    && request.getShareCount() == count
                    && request.getSharePrice() == price) {
                return request;
            }
        }
        return null;
    }

    private void checkStatus() {
        int buyCount = 0;
        int sellCount = 0;
        for (var request : requestList) {
            if (request.getType() == RequestType.BUY) {
                buyCount++;
            } else {
                sellCount++;
            }
        }
        if (buyCount >= 4 || sellCount >= 4) {
            closeBargain();
        }
    }

    public void openBargain() {
        System.out.println("Open");
        bargainingState.countDown();
    }

    public void closeBargain() {
        System.out.println("Close");
        bargainingState = new CountDownLatch(1);
        for (var request : requestList) {
            System.out.println(request);
        }
    }
}
