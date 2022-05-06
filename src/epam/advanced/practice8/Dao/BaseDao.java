package epam.advanced.practice8.Dao;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.Entities.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDao <T extends Entity> {
    protected BasicConnectionPool connectionPool;

    public BaseDao(BasicConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    abstract List<T> findAll() throws DaoException;
    abstract T findEntityById(int id) throws DaoException;
    abstract boolean delete(T entity) throws DaoException;
    abstract boolean delete(int id) throws DaoException;
    abstract boolean create(T entity) throws DaoException;

    public void close(Statement statement){
        try {
            if(statement != null){
                statement.close();
            }
        } catch (SQLException throwables) {
            //log
        }
    }
    public void close(Connection connection){
        if(connection != null){
            connectionPool.releaseConnection(connection);
        }
    }
}
