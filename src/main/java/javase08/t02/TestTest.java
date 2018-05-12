package javase08.t02;

public class TestTest {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initPool();
        connectionPool.getConnection();

    }
}
