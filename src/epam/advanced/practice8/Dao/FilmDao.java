package epam.advanced.practice8.Dao;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Entities.Actor;
import epam.advanced.practice8.Entities.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FilmDao extends BaseDao<Film> {
    private static final String SQL_SELECT_ALL_FILMS =
            "select * from film";
    private static final String SQL_SELECT_FILM =
            "select * from film where film_id=?";
    private static final String SQL_INSERT_FILM =
            "insert into film (title, release_year, release_country) values (?, ?, ?);";
    private static final String SQL_DELETE_ENTITY =
            "delete from film where title=? and release_year=? and release_country=?;";
    private static final String SQL_DELETE_ENTITY_WITH_ID =
            "delete from film where film_id=?";
    private static final String SQL_FIND_FILM_ID =
            "select * from film where title=? and release_year=? and release_country=?;";
    private static final String SQL_FIND_ACTOR_ID =
            "select * from actor where first_name=? and last_name=? and birdsyear=?;";
    private static final String SQL_INSERT_FILM_ACTOR =
            "insert into film_actor (film_id, actor_id) values (?, ?)";
    private static final String SQL_INSERT_FILM_PRODUCER =
            "insert into film_producer (film_id, actor_id) values (?, ?)";
    private static final String SQL_SELECT_FILM_WITH_YEAR =
            "select * from film where release_year>=?";
    private static final String SQL_SELECT_OLD_FILM =
            "select * from film where film.release_year<=?";
    private static final String SQL_DELETE_OLD_FILM =
            "delete from film where film.release_year<=?";

    public FilmDao(BasicConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Film> findAll() throws DaoException {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FILMS);
            while (resultSet.next()){
                films.add(parseResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return films;
    }

    @Override
    public Film findEntityById(int id) throws DaoException {
        Film film = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_FILM);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            film = parseResultSet(resultSet);
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return film;
    }

    @Override
    public boolean delete(Film entity) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ENTITY);
            statement.setString(1, entity.getTitle());
            statement.setInt(2, entity.getReleaseYear());
            statement.setString(3, entity.getReleaseCounty());
            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ENTITY_WITH_ID);
            statement.setInt(1, id);
            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    @Override
    public boolean create(Film entity) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_INSERT_FILM);
            statement.setString(1, entity.getTitle());
            statement.setInt(2, entity.getReleaseYear());
            statement.setString(3, entity.getReleaseCounty());
            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    public boolean addActorToFilm(Film film, Actor actor) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_FILM_ID);
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getReleaseYear());
            statement.setString(3, film.getReleaseCounty());
            ResultSet filmSet = statement.executeQuery();
            filmSet.next();
            int filmId = filmSet.getInt(1);

            statement = connection.prepareStatement(SQL_FIND_ACTOR_ID);
            statement.setString(1, actor.getFirstName());
            statement.setString(2, actor.getLastName());
            statement.setInt(3, actor.getBirdsYear());
            ResultSet actorSet = statement.executeQuery();
            actorSet.next();
            int actorId = actorSet.getInt(1);

            statement = connection.prepareStatement(SQL_INSERT_FILM_ACTOR);
            statement.setInt(1, filmId);
            statement.setInt(2, actorId);

            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    public boolean addProducerToFilm(Film film, Actor actor) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_FIND_FILM_ID);
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getReleaseYear());
            statement.setString(3, film.getReleaseCounty());
            ResultSet filmSet = statement.executeQuery();
            filmSet.next();
            int filmId = filmSet.getInt(1);

            statement = connection.prepareStatement(SQL_FIND_ACTOR_ID);
            statement.setString(1, actor.getFirstName());
            statement.setString(2, actor.getLastName());
            statement.setInt(3, actor.getBirdsYear());
            ResultSet actorSet = statement.executeQuery();
            actorSet.next();
            int actorId = actorSet.getInt(1);

            statement = connection.prepareStatement(SQL_INSERT_FILM_PRODUCER);
            statement.setInt(1, filmId);
            statement.setInt(2, actorId);

            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    public List<Film> findFilmsInThisYear() throws DaoException {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_FILM_WITH_YEAR);
            statement.setInt(1, Calendar.getInstance().get(Calendar.YEAR)-1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                films.add(parseResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return films;
    }

    private Film parseResultSet(ResultSet resultSet){
        Film film = new Film();
        try {
            film.setId(resultSet.getInt(1));
            film.setTitle(resultSet.getString(2));
            film.setReleaseYear(resultSet.getInt(3));
            film.setReleaseCounty(resultSet.getString(4));
        } catch (SQLException throwables) {
            // log
        }
        return film;
    }

    public List<Film> deleteOldFilm(int years) throws DaoException {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_OLD_FILM);
            statement.setInt(1, Calendar.getInstance().get(Calendar.YEAR)-years);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                films.add(parseResultSet(resultSet));
            }
            statement = connection.prepareStatement(SQL_DELETE_OLD_FILM);
            statement.setInt(1, Calendar.getInstance().get(Calendar.YEAR)-years);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return films;
    }
}
