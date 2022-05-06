package epam.advanced.practice8;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.ConnectionPool.ConnectionPool;
import epam.advanced.practice8.Dao.DaoException;
import epam.advanced.practice8.Dao.FilmDao;
import epam.advanced.practice8.Entities.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Main {
    private static FilmDao filmDao;
    public static void main(String[] args) throws DaoException, SQLException {
        var connectionPool = BasicConnectionPool.create(
                "jdbc:mysql://localhost:3306/video_library", "root", "pass"
        );
        filmDao = new FilmDao(connectionPool);

        
        showAllFilms();
    }

    private static void addFilm(Film film) throws DaoException {
        boolean added = filmDao.create(film);
        System.out.println(film);
        System.out.println(added ? "Added" : "Did not add");
    }

    private static void showFilmWithId(int id) throws DaoException {
        var film = filmDao.findEntityById(id);
        System.out.println(film);
    }

    private static void showAllFilms() throws DaoException {
        var films = filmDao.findAll();
        for(var film : films){
            System.out.println(film);
        }
    }
}
