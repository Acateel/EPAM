package epam.advanced.practice8.Dao;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Entities.Actor;
import epam.advanced.practice8.Entities.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao extends BaseDao<Actor> {
    private static final String SQL_SELECT_ALL_ACTORS =
            "select * from actor";
    private static final String SQL_SELECT_ACTOR =
            "select * from actor where actor_id=?";
    private static final String SQL_INSERT_FILM =
            "insert into actor (first_name, last_name, birdsyear) values (?, ?, ?);";
    private static final String SQL_DELETE_ENTITY =
            "delete from actor where first_name=? and last_name=? and birdsyear=?;";
    private static final String SQL_DELETE_ENTITY_WITH_ID =
            "delete from actor where actor_id=?";
    private static final String SQL_SELECT_ACTOR_IN_FILM =
            "select actor.* from actor left join film_actor on film_actor.actor_id=actor.actor_id " +
                    "left join film on film.film_id=film_actor.film_id where title=?;";

    public ActorDao(BasicConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Actor> findAll() throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ACTORS);
            while (resultSet.next()) {
                actors.add(parseResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    @Override
    public Actor findEntityById(int id) throws DaoException {
        Actor actor = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ACTOR);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            actor = parseResultSet(resultSet);
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actor;
    }

    @Override
    public boolean delete(Actor entity) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ENTITY);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setInt(3, entity.getBirdsYear());
            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        } finally {
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
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ENTITY_WITH_ID);
            statement.setInt(1, id);
            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    @Override
    public boolean create(Actor entity) throws DaoException {
        int undate = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_INSERT_FILM);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setInt(3, entity.getBirdsYear());
            undate = statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return undate > 0;
    }

    public List<Actor> findActorsInFilm(Film film) throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ACTOR_IN_FILM);
            statement.setString(1, film.getTitle());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                actors.add(parseResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    private Actor parseResultSet(ResultSet resultSet) {
        Actor film = new Actor();
        try {
            film.setId(resultSet.getInt(1));
            film.setFirstName(resultSet.getString(2));
            film.setLastName(resultSet.getString(3));
            film.setBirdsYear(resultSet.getInt(4));
        } catch (SQLException throwables) {
            // log
        }
        return film;
    }
}
