package epam.advanced.practice7;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        SqlService service = new SqlService(CreateConnection.createStatement());
        
        service.showProducerActor();
    }
}
