package epam.advanced.practice5.task11;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Airport[] airports = getAirports();
        Plane[] planes = getPlanes(airports);
        showAirports(airports);

        for(var plane : planes){
            plane.start();
        }
        Thread.currentThread().join(3000);

        showAirports(airports);
    }

    private static void showAirports(Airport[] airports) {
        System.out.println("Airports");
        for (var airport : airports) {
            System.out.println(airport);
        }
        System.out.println();
    }

    private static Airport[] getAirports(){
        Airport[] airports = new Airport[4];
        for (int i = 0; i < airports.length; i++) {
            airports[i] = new Airport(i, 2);
        }
        return airports;
    }
    private static Plane[] getPlanes(Airport[] airports){
        Plane[] planes = new Plane[]{
                new Plane(100, RangesType.SHORT),
                new Plane(150, RangesType.MEDIUM),
                new Plane(150, RangesType.MEDIUM),
                new Plane(200, RangesType.LONG),
                new Plane(100, RangesType.LONG),
        };
        planes[0].setStartAirport(airports[0]);
        planes[0].setFinishAirport(airports[2]);

        planes[1].setStartAirport(airports[0]);
        planes[1].setFinishAirport(airports[1]);

        planes[2].setStartAirport(airports[1]);
        planes[2].setFinishAirport(airports[3]);

        planes[3].setStartAirport(airports[0]);
        planes[3].setFinishAirport(airports[3]);

        planes[4].setStartAirport(airports[3]);
        planes[4].setFinishAirport(airports[2]);

        return planes;
    }
}
