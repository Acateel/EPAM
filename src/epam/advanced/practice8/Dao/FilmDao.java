package epam.advanced.practice8.Dao;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Entities.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmDao extends BaseDao<Film> {
    private static final String SQL_SELECT_ALL_FILMS =
            "select * from film";


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
        return null;
    }

    @Override
    public boolean delete(Film entity) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Film entity) throws DaoException {
        return false;
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
}
