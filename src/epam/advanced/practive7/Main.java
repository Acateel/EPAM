package epam.advanced.practive7;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        SqlService service = new SqlService(CreateConnection.createStatement());
        //service.showFilmYear(2022);
        //service.showActorsInFilm("Iron Man");
        service.showActorsWithCount(2);
    }
}
