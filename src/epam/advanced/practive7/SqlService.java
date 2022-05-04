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
}
