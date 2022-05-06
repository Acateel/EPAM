package epam.advanced.practice8.Dao;

import epam.advanced.practice8.Entities.Entity;

import java.sql.Statement;
import java.util.List;

public interface BaseDao <T extends Entity> {
    List<T> findAll() throws DaoException;
    T findEntityById(int id) throws DaoException;
    boolean delete(T entity) throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean create(T entity) throws DaoException;
}
