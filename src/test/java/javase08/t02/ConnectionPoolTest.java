package javase08.t02;

import javase08.t02.dao.LibraryDao;
import javase08.t02.dao.LibraryDaoImpl;
import javase08.t02.pool.ConnectionPoolImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class ConnectionPoolTest {
    private Connection connection;
    private LibraryDao libraryDAO;
    private ConnectionPoolImpl connectionPool;

//    @Before
//    public void setup() {
//        connectionPool = new ConnectionPoolImpl();
//        libraryDAO = new LibraryDaoImpl(connectionPool);
//    }
//
//    @After
//    public void close() {
//        connectionPool.returnConnection(connection);
//        connectionPool.closeConnections();
//    }

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


}