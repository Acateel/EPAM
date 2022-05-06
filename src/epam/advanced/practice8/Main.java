package epam.advanced.practice8;

import epam.advanced.practice8.ConnectionPool.BasicConnectionPool;
import epam.advanced.practice8.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        BasicConnectionPool connectionPool = BasicConnectionPool.create(
                "jdbc:mysql://localhost:3306/video_library", "root", "pass");
        Connection connection = connectionPool.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from film");
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

        connectionPool.releaseConnection(connection);
    }
}
