package epam.advanced.practice8;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Dao.ActorDao;
import epam.advanced.practice8.Dao.FilmDao;
import epam.advanced.practice8.Presentation.MainMenu;

import java.sql.SQLException;

public class Main {
    private static FilmDao filmDao;
    private static ActorDao actorDao;
    public static void main(String[] args) throws SQLException {
        var connectionPool = BasicConnectionPool.create(
                "jdbc:mysql://localhost:3306/video_library", "root", "pass"
        );
        filmDao = new FilmDao(connectionPool);
        actorDao = new ActorDao(connectionPool);

        MainMenu mainMenu = new MainMenu(filmDao, actorDao);
        mainMenu.Start();
    }
}
