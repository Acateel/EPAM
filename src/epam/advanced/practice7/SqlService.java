package epam.advanced.practice7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlService {
    Statement statement;

    public SqlService(Statement statement) {
        this.statement = statement;
    }

    public void showFilmYear(int year) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select distinct title from film where release_year>=" + (year - 1));
        while (resultSet.next()) {
            System.out.println(resultSet.getString("title"));
        }
    }

    public void showActorsInFilm(String film) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "select actor.actor_id, actor.first_name, actor.last_name, actor.birdsyear\n" +
                        "from actor\n" +
                        "left join film_actor\n" +
                        "on film_actor.actor_id=actor.actor_id\n" +
                        "left join film\n" +
                        "on film.film_id=film_actor.film_id\n" +
                        "where title='" + film + "'");

        while (resultSet.next()) {
            System.out.print(resultSet.getInt("actor.actor_id") + " ");
            System.out.print(resultSet.getString("actor.first_name") + " ");
            System.out.print(resultSet.getString("actor.last_name") + " ");
            System.out.print(resultSet.getInt("actor.birdsyear") + "\n");
        }
    }

    public void showActorsWithCount(int count) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "select actor.* from actor left join film_actor on film_actor.actor_id=actor.actor_id where film_id > 0"
        );

        int replicaCount = 1;

        int oldId = 0;
        String oldFirstName = "";
        String oldLastName = "";
        int oldYear = 0;


        int id;
        String firstName;
        String lastName;
        int year;

        while (resultSet.next()) {
            id = resultSet.getInt("actor.actor_id");
            firstName = resultSet.getString("actor.first_name");
            lastName = resultSet.getString("actor.last_name");
            year = resultSet.getInt("actor.birdsyear");
            if (id == oldId) {
                replicaCount++;
            } else {
                if (replicaCount >= count) {
                    System.out.println(oldId + " " + oldFirstName + " " + oldLastName + " " + oldYear);
                }
                replicaCount = 1;
            }
            oldId = id;
            oldFirstName = firstName;
            oldLastName = lastName;
            oldYear = year;
        }
    }

    public void showProducerActor() throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "select actor.actor_id, actor.first_name, actor.last_name, actor.birdsyear\n" +
                        "from actor \n" +
                        "left join film_producer \n" +
                        "on film_producer.actor_id=actor.actor_id\n" +
                        "where film_id > 0");

        int oldId = 0;
        String oldFirstName = "";
        String oldLastName = "";
        int oldYear = 0;


        int id;
        String firstName;
        String lastName;
        int year;

        while (resultSet.next()) {
            id = resultSet.getInt("actor.actor_id");
            firstName = resultSet.getString("actor.first_name");
            lastName = resultSet.getString("actor.last_name");
            year = resultSet.getInt("actor.birdsyear");
            if (id != oldId && oldId!=0) {
                System.out.println(oldId + " " + oldFirstName + " " + oldLastName + " " + oldYear);
            }
            oldId = id;
            oldFirstName = firstName;
            oldLastName = lastName;
            oldYear = year;
        }
    }

    public void deleteOldFilm(int number) throws SQLException {
        int year = 2022 - number;
        statement.execute("delete\n" +
                "from film\n" +
                "where film.release_year<=" + year);
    }
}
