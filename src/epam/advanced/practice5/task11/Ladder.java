package epam.advanced.practice5.task11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ladder {
    private int ladderId;
    private LaddersState state = LaddersState.FREE;
    private final Lock lock = new ReentrantLock();
    private Airport airport;

    public Ladder(int ladderId, Airport airport) {
        this.ladderId = ladderId;
        this.airport = airport;
    }

    public LaddersState getState() {
        return state;
    }

    public void setFree(){
        state = LaddersState.FREE;
    }

    public void setBusy(){
        state = LaddersState.BUSY;
    }

    public void embarkation(Plane plane){
        try{
            lock.lock();
            setBusy();
            System.out.println("Airport:" + airport.getAirportId() + " Ladder:" + ladderId + " -> Plane embarkation\n" + plane);
            airport.withdrawHumans(plane.getCapacity());
            //simulation embarkation
            TimeUnit.MILLISECONDS.sleep(plane.getCapacity()+100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Airport:" + airport.getAirportId() + " Ladder:" + ladderId + " -> Ladder free");
            setFree();
            lock.unlock();
        }
    }

    public void disembarkation(Plane plane){
        try{
            lock.lock();
            System.out.println("Airport:" + airport.getAirportId() + " Ladder:" + ladderId + " -> Plane disembarkation\n" + plane + "\n");
            setBusy();
            airport.addHumans(plane.getCapacity());
            //simulation disembarkation
            TimeUnit.MILLISECONDS.sleep(plane.getCapacity()+100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Airport:" + airport.getAirportId() + " Ladder:" + ladderId + " -> Ladder free");
            setFree();
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "state=" + state +
                ", airportID=" + airport.getAirportId() +
                '}';
    }
}
