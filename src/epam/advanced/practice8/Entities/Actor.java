package epam.advanced.practice8.Entities;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Actor{" +
                "id='" + getId() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Year=" + birdsYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return birdsYear == actor.birdsYear && Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birdsYear);
    }
}
