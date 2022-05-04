package epam.advanced.practive7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlService {
    Statement statement;

    public SqlService(Statement statement) {
        this.statement = statement;
    }

    public void showFilmYear(int year) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select distinct title from film where release_year>=" + (year-1));
        while (resultSet.next()){
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
                "where title='"+ film +"'");

        while (resultSet.next()){
            System.out.print(resultSet.getInt("actor.actor_id") + " ");
            System.out.print(resultSet.getString("actor.first_name") + " ");
            System.out.print(resultSet.getString("actor.last_name") + " ");
            System.out.print(resultSet.getInt("actor.birdsyear") + "\n");
        }
    }
}
