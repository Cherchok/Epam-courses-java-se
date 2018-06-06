package javase08.t02.pool;

import java.sql.Connection;

public interface ConnectionPool extends AutoCloseable {
    Connection getConnection();
}
