package epam.advanced.practice5.task11;

public class Terminal {
    private int humanCount;

    public Terminal(){
        this(300);
    }
    public Terminal(int humanCount) {
        this.humanCount = humanCount;
    }

    public int getHumanCount() {
        return humanCount;
    }

    public void addHumanCount(int count) {
        humanCount += count;
    }

    public void withdrawHumanCount(int count) {
        humanCount -= count;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "humanCount=" + humanCount +
                '}';
    }
}
