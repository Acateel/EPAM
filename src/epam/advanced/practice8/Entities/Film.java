package epam.advanced.practice8.Entities;

public class Film extends Entity{
    private String title;
    private int releaseYear;
    private String releaseCounty;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getReleaseCounty() {
        return releaseCounty;
    }

    public void setReleaseCounty(String releaseCounty) {
        this.releaseCounty = releaseCounty;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", year=" + releaseYear +
                ", county='" + releaseCounty + '\'' +
                '}';
    }
}
