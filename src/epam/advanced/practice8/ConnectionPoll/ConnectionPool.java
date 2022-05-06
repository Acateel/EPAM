package epam.advanced.practice8.ConnectionPoll;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final DataSource dataSource;
    private static Connection connection = null;

    static {
        dataSource = MySqlFactory.CreateMysqlDataSource();
    }

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = dataSource.getConnection();
        }
        return connection;
    }
}
