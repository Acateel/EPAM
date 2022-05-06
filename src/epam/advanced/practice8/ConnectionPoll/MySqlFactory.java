package epam.advanced.practice8.ConnectionPoll;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Properties;

public class MySqlFactory {
    public static MysqlDataSource CreateMysqlDataSource() {
        MysqlDataSource dataSource = null;
        dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/video_library");
        dataSource.setUser("root");
        dataSource.setPassword("pass");
        return dataSource;
    }
}
