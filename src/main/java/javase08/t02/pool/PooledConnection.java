package javase08.t02.pool;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.sql.Connection;
import java.util.function.Consumer;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PooledConnection implements Connection {

    private Consumer<PooledConnection> closer;

    @Delegate(excludes = Closeable.class)
    private Connection connection;

    @Override
    public void close() {
        closer.accept(this);
    }

    @SneakyThrows
    public void reallyClose() {
        connection.close();
    }
}
