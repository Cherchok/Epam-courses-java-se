package javase08.t02;

import java.sql.*;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class ConnectionPool {
    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;
    private BlockingQueue<Connection> connectionPool;
    private BlockingQueue<Connection> usedConnections;

    public ConnectionPool() {
        ResourceManager resourceManager = ResourceManager.getInstance();
        this.driver = resourceManager.getValues(DBParameter.DRIVER);
        this.url = resourceManager.getValues(DBParameter.URL);
        this.user = resourceManager.getValues(DBParameter.USER);
        this.password = resourceManager.getValues(DBParameter.PASSWORD);
        try {
            this.poolSize = Integer.parseInt(resourceManager.getValues(DBParameter.POOLSIZE));
        } catch (NumberFormatException e) {
            poolSize = 5;
        }
    }

    public void initPool() {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(driver);
            connectionPool = new ArrayBlockingQueue<>(poolSize);
            usedConnections = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionPool.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionPool.take();
            connectionPool.remove(connection);
            usedConnections.add(connection);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }



    public void returnConnection(Connection connection) {
        usedConnections.remove(connection);
        connectionPool.add(connection);
    }

    public void closeConnections() {
        try {
            for (Connection connection : connectionPool) {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
