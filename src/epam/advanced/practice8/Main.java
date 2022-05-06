package epam.advanced.practice8;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Dao.ActorDao;
import epam.advanced.practice8.Dao.DaoException;
import epam.advanced.practice8.Dao.FilmDao;
import epam.advanced.practice8.Entities.Actor;
import epam.advanced.practice8.Entities.Film;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static FilmDao filmDao;
    private static ActorDao actorDao;
    public static void main(String[] args) throws DaoException, SQLException {
        var connectionPool = BasicConnectionPool.create(
                "jdbc:mysql://localhost:3306/video_library", "root", "pass"
        );
        filmDao = new FilmDao(connectionPool);
        actorDao = new ActorDao(connectionPool);
        
        showAllFilms();
    }

    private static void deleteOldFilm(int years) throws DaoException {
        var films = filmDao.deleteOldFilm(22);
        System.out.println("Deleted films");
        for (var film : films) {
            System.out.println(film);
        }
    }

    private static void showProducer() throws DaoException {
        var actors = actorDao.findActorsProducer();
        for(var actor : actors){
            System.out.println(actor);
        }
    }

    private static void showActorsInFilmManyTimes(int times) throws DaoException {
        var actors = actorDao.findActorsInFilmManyTimes(times);
        for(var actor : actors){
            System.out.println(actor);
        }
    }

    private static void showActorsInFilm(Film film) throws DaoException {
        var actors = actorDao.findActorsInFilm(film);
        for(var actor : actors){
            System.out.println(actor);
        }
    }

    private static void showFilmsCurrentYear() throws DaoException {
        var list = filmDao.findFilmsInThisYear();
        for (var film : list) {
            System.out.println(film);
        }
    }

    private static void deleteActor(Actor actor) throws DaoException {
        boolean deleted = actorDao.delete(actor);
        System.out.println(actor);
        System.out.println(deleted ? "Deleted" : "Did not delete");
    }

    private static void deleteActorWithId(int id) throws DaoException {
        boolean deleted = actorDao.delete(id);
        System.out.println("Id = " + id);
        System.out.println(deleted ? "Deleted" : "Did not delete");
    }

    private static void addActor(Actor actor) throws DaoException {
        boolean added = actorDao.create(actor);
        System.out.println(actor);
        System.out.println(added ? "Added" : "Did not add");
    }

    private static void showActorWithId(int id) throws DaoException {
        var actor = actorDao.findEntityById(id);
        System.out.println(actor);
    }

    private static void showAllActors() throws DaoException {
        var actors = actorDao.findAll();
        for(var actor : actors){
            System.out.println(actor);
        }
    }

    private static void deleteFilm(Film film) throws DaoException {
        boolean deleted = filmDao.delete(film);
        System.out.println(film);
        System.out.println(deleted ? "Deleted" : "Did not delete");
    }

    private static void deleteFilmWithId(int id) throws DaoException {
        boolean deleted = filmDao.delete(id);
        System.out.println("Id = " + id);
        System.out.println(deleted ? "Deleted" : "Did not delete");
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
