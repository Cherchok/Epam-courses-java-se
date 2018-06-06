package javase08.t02.pool;

import javase08.t02.ResourceManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ConnectionPoolImpl implements ConnectionPool, Consumer<PooledConnection> {
    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;
    private BlockingQueue<PooledConnection> connectionPool;
    private Set<PooledConnection> usedConnections;

    public ConnectionPoolImpl() {
        ResourceManager resourceManager = ResourceManager.getInstance();
        this.driver = resourceManager.getValues("driver");
        this.url = resourceManager.getValues("url");
        this.user = resourceManager.getValues("user");
        this.password = resourceManager.getValues("password");
        try {
            this.poolSize = Integer.parseInt(resourceManager.getValues("poolsize"));
        } catch (NumberFormatException e) {
            poolSize = 5;
        }
        initPool();
    }

    private void initPool() {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(driver);
            connectionPool = new ArrayBlockingQueue<>(poolSize);
            usedConnections = ConcurrentHashMap.newKeySet();
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                PooledConnection pooledConnection = new PooledConnection(this, connection);
                connectionPool.add(pooledConnection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @SneakyThrows
    public Connection getConnection() {
        PooledConnection connection = connectionPool.take();
        usedConnections.add(connection);
        return connection;
    }

    public void closeConnections() {
        try {
            for (PooledConnection connection : connectionPool) {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }
                connection.reallyClose();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void accept(PooledConnection connection) {
        usedConnections.remove(connection);
        connectionPool.add(connection);
    }

    public int usedConnectionsCount() {
        return usedConnections.size();
    }

    @Override
    public void close() throws Exception {
        closeConnections();
    }
}
