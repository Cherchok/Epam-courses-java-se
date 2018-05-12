package javase08.t02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

class ConnectionPoolTest {
    private Connection connection;
    private LibraryDAO libraryDAO;
    private ConnectionPool connectionPool;

    @Before
    public void setup() {
        connectionPool = new ConnectionPool();
        connectionPool.initPool();
        connection = connectionPool.getConnection();
        libraryDAO = new LibraryDAO(connection);
    }

    @After
    public void close() {
        connectionPool.returnConnection(connection);
        connectionPool.closeConnections();
    }

//    @Test
//    void addBook() {
//        Book book = new Book("BookA", "Ivan Ivanov");
//        libraryDAO.addBook(book);
//        int sizeBefore = libraryDAO.getLibrary().size();
//        System.out.println("size before =" + sizeBefore);
//        Book newBook = new Book("BookB", "Peter Petrov");
//        libraryDAO.addBook(newBook);
//        Assert.assertEquals(sizeBefore + 1, libraryDAO.getLibrary().size());
//    }

    @Test
    void getConnection() {
    }

//    @Test
//    void getLibrary() {
//        List<Book> list = libraryDAO.getLibrary();
//        for (Book b :list) {
//            System.out.println(b.getTitle()+" "+b.getAuthor());
//        }
//    }

    @Test
    void closeResultSet() {
    }

    @Test
    void closeStatement() {
    }
}