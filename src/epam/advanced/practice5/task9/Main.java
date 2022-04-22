package epam.advanced.practice5.task9;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Auction auction = getAuction();
        while (auction.hasLots()){
            System.out.println("\nStart auction\n" + auction.getLot() + "\n");
            auction.start();
            TimeUnit.MILLISECONDS.sleep(500);
            auction.findWinner();
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    private static Auction getAuction() {
        Auction auction = new Auction();
        //initialize lots
        auction.addLot(new Lot(0, "first", 50));
        auction.addLot(new Lot(1, "second", 100));
        auction.addLot(new Lot(2, "third", 25));
        auction.addLot(new Lot(3, "forth", 50));

        //initialize participant
        Participant[] participants = new Participant[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            participants[i] = new Participant(i,50+random.nextInt(100), auction);
            auction.addParticipant(participants[i]);
            participants[i].start();
        }
        return auction;
    }
}
