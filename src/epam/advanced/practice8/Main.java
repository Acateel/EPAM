package epam.advanced.practice8;

import epam.advanced.practice8.ConnectionPoll.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionPool.getConnection();

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from film");
        while (result.next()){
            System.out.println(result.getString(2));
        }
    }
}
