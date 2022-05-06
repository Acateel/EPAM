package epam.advanced.practice8;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.ConnectionPool.ConnectionPool;
import epam.advanced.practice8.Dao.DaoException;
import epam.advanced.practice8.Dao.FilmDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws DaoException, SQLException {
        var connectionPool = BasicConnectionPool.create(
                "jdbc:mysql://localhost:3306/video_library", "root", "pass"
        );
        FilmDao filmDao = new FilmDao(connectionPool);
        var films = filmDao.findAll();
        for(var film : films){
            System.out.println(film);
        }
    }
}
