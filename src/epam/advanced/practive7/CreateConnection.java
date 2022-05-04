package epam.advanced.practive7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/video_library", "root", "pass");
    }
    public static Statement createStatement() throws SQLException {
        return getConnection().createStatement();
    }
}
