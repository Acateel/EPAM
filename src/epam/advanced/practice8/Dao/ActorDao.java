package epam.advanced.practice8.Dao;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Entities.Actor;
import epam.advanced.practice8.Entities.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorDao extends BaseDao<Actor> {
    private static final String SQL_SELECT_ALL_ACTORS =
            "select * from actor";
    private static final String SQL_SELECT_FILM =
            "select * from film where film_id=?";
    private static final String SQL_INSERT_FILM =
            "insert into film (title, release_year, release_country) values (?, ?, ?);";
    private static final String SQL_DELETE_ENTITY =
            "delete from film where title=? and release_year=? and release_country=?;";
    private static final String SQL_DELETE_ENTITY_WITH_ID =
            "delete from film where film_id=?";

    public ActorDao(BasicConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Actor> findAll() throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ACTORS);
            while (resultSet.next()){
                actors.add(parseResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables.getMessage());
        }
        finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    @Override
    public Actor findEntityById(int id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Actor entity) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Actor entity) throws DaoException {
        return false;
    }

    private Actor parseResultSet(ResultSet resultSet){
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
