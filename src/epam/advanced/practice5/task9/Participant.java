package epam.advanced.practice5.task9;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Participant extends Thread {
    private int participantId;
    private int cash;
    private int currentLotPrice;
    private Auction auction;
    private CountDownLatch startLatch;
    private CountDownLatch finishLatch;
    private boolean access;
    private int fineCounter;

    public Participant(int participantId, int cash, Auction auction) {
        this.participantId = participantId;
        this.cash = cash;
        this.auction = auction;
        this.access = true;
        this.fineCounter = 0;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getCash() {
        return cash;
    }

    public int getCurrentLotPrice() {
        return currentLotPrice;
    }

    public void setCurrentLotPrice(int currentLotPrice) {
        this.currentLotPrice = currentLotPrice;
    }

    public void addCurrentLotPrice(int addedPrice) {
        this.currentLotPrice += addedPrice;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public void setFineCounter(int fineCounter) {
        this.fineCounter = fineCounter;
    }

    public int getFineCounter() {
        return fineCounter;
    }

    public void withdrawFineCounter() {
        if (fineCounter != 0) {
            this.fineCounter--;
        }
        if (fineCounter == 0) {
            access = true;
        }
    }

    @Override
    public void run() {
        try {
            while (auction.hasLots()) {
                waitStart();
                if (access) {
                    currentLotPrice = getCurrentPrice();
                    System.out.println(participantId + " -> " + currentLotPrice);
                    addedPrice();
                } else {
                    currentLotPrice = 0;
                }
                waitFinish();
                System.out.println(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addedPrice() {
        Random random = new Random();
        if (random.nextInt(3) == 0) {
            addCurrentLotPrice(random.nextInt(20));
            System.out.println("Update:" + participantId + " -> " + currentLotPrice);
        }
    }

    private int getCurrentPrice() {
        int price = auction.getLot().getStartPrice();
        Random random = new Random();
        addCurrentLotPrice(random.nextInt(20));
        return price;
    }

    public void waitFinish() throws InterruptedException {
        finishLatch = auction.getFinishLatch();
        finishLatch.await();
    }

    public void waitStart() throws InterruptedException {
        startLatch = auction.getStartLatch();
        startLatch.await();
    }

    public boolean withdrawMoney() {
        if (cash - currentLotPrice > 0) {
            cash -= currentLotPrice;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Participant{" +
                " Id=" + participantId +
                ", cash=" + cash +
                ", access=" + access +
                ", fineCounter=" + fineCounter +
                '}';
    }
}

