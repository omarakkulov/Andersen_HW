package ru.akkulov.logic;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/andersen_hw2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        dataSource.setMinIdle(100);
        dataSource.setMaxIdle(1000);
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection is OK");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection is not OK");
        }
        return connection;
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
