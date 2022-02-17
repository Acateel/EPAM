package epam.advanced.practice2.data;

public class City {
    private String name;
    private double landArea;
    private long population;

    public City(String name, double landArea, long population) {
        this.name = name;
        this.landArea = landArea;
        this.population = population;
    }
    public City(){
        this("Default",0.0,0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", landArea=" + landArea +
                ", population=" + population +
                "}\n";
    }
}
