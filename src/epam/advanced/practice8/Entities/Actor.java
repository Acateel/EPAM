package epam.advanced.practice8.Entities;

public class Actor extends Entity {
    private String firstName;
    private String lastName;
    private int birdsYear;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirdsYear() {
        return birdsYear;
    }

    public void setBirdsYear(int birdsYear) {
        this.birdsYear = birdsYear;
    }
}
