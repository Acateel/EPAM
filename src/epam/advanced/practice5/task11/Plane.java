package epam.advanced.practice5.task11;

import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private static int countId = 0;
    private int planeId;
    private int capacity;
    private RangesType range;
    private Airport startAirport;
    private Airport finishAirport;

    public Plane(int capacity, RangesType range) {
        planeId = countId++;
        this.capacity = capacity;
        this.range = range;
    }

    public int getCapacity() {
        return capacity;
    }

    public RangesType getRange() {
        return range;
    }

    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    public void setFinishAirport(Airport finishAirport) {
        this.finishAirport = finishAirport;
    }

    @Override
    public void run() {
        try {
            startAirport.embarkation(this);
            TimeUnit.MILLISECONDS.sleep(getFlyTime());
            finishAirport.disembarkation(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int getFlyTime(){
        int flyTime = 0;
        switch (range){
            case LONG -> flyTime = 1500;
            case MEDIUM -> flyTime = 1000;
            case SHORT -> flyTime = 500;
        }
        return flyTime;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + planeId +
                ", capacity=" + capacity +
                ", range=" + range +
                ", startAirportID=" + startAirport.getAirportId() +
                ", finishAirportID=" + finishAirport.getAirportId() +
                '}';
    }
}
