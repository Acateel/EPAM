package epam.advanced.practice5.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Auction {
    private List<Lot> lots;
    private List<Participant> participants;
    private CountDownLatch startLatch;
    private CountDownLatch finishLatch;

    public Auction() {
        lots = new ArrayList<>();
        participants = new ArrayList<>();
        startLatch = new CountDownLatch(1);
        finishLatch = new CountDownLatch(1);
    }

    public CountDownLatch getStartLatch() {
        return startLatch;
    }

    public CountDownLatch getFinishLatch() {
        return finishLatch;
    }

    public boolean addParticipant(Participant participant) {
        return participants.add(participant);
    }

    public boolean addLot(Lot lot) {
        return lots.add(lot);
    }

    public Lot getLot() {
        return lots.get(0);
    }

    public boolean hasLots() {
        return !lots.isEmpty();
    }

    public void start(){
        startLatch.countDown();
        startLatch = new CountDownLatch(1);
    }

    public Participant findWinner() throws InterruptedException {
        Participant winner = findProbablyWinner();
        withdrawFineCounters();
        System.out.println("\nWinner Id = " + winner.getParticipantId() + ", Cash = " + winner.getCash() + ", Price = " + winner.getCurrentLotPrice());
        if (!distractPrice(winner)) {
            System.out.println("Winner can't pay");
            winner = null;
        }
        lots.remove(0);
        finish();
        return winner;
    }

    private void finish() {
        finishLatch.countDown();
        finishLatch = new CountDownLatch(1);
    }

    private void withdrawFineCounters() {
        for (var participant : participants) {
            if (!participant.isAccess()) {
                participant.withdrawFineCounter();
            }
        }
    }

    private Participant findProbablyWinner() {
        Participant winner = participants.get(0);
        for (var participant : participants) {
            if (participant.getCurrentLotPrice() > winner.getCurrentLotPrice() && participant.isAccess()) {
                winner = participant;
            }
        }
        return winner;
    }

    private boolean distractPrice(Participant participant) {
        if (!participant.withdrawMoney()) {
            participant.setAccess(false);
            participant.setFineCounter(1);
            return false;
        }
        return true;
    }
}
