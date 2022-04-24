package epam.advanced.practice5.task11;

import java.util.Arrays;
import java.util.Random;

public class Airport {
    private int AirportId;
    private Terminal terminal;
    private Ladder[] ladders;
    private final Random random = new Random();

    public Airport(int airportId, int laddersCount) {
        this.AirportId = airportId;
        terminal = new Terminal();
        ladders = new Ladder[laddersCount];
        for (int i = 0; i < laddersCount; i++) {
            ladders[i] = new Ladder(i, this);
        }
    }

    public int getAirportId() {
        return AirportId;
    }

    public void embarkation(Plane plane) {
        Ladder ladder = searchFreeLadder();
        if (ladder == null) {
            ladders[random.nextInt(ladders.length)].embarkation(plane);
        } else {
            ladder.embarkation(plane);
        }
    }

    public void disembarkation(Plane plane) {
        Ladder ladder = searchFreeLadder();
        if (ladder == null) {
            ladders[random.nextInt(ladders.length)].disembarkation(plane);
        } else {
            ladder.disembarkation(plane);
        }
    }

    private Ladder searchFreeLadder() {
        for (var ladder : ladders) {
            if (ladder.getState() == LaddersState.FREE) {
                return ladder;
            }
        }
        return null;
    }

    public void addHumans(int count){
        terminal.addHumanCount(count);
    }

    public void withdrawHumans(int count){
        terminal.withdrawHumanCount(count);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "AirportId=" + AirportId +
                ", terminalHumanCount=" + terminal.getHumanCount() +
                ", laddersCount=" + ladders.length +
                '}';
    }
}
