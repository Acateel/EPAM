package epam.advanced.practice5.task9;

public class Lot {
    private int id;
    private String name;
    private int startPrice;

    public Lot(int id, String name, int startPrice) {
        this.id = id;
        this.name = name;
        this.startPrice = startPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStartPrice() {
        return startPrice;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startPrice=" + startPrice +
                '}';
    }
}
