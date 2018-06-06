package javase08.t02.dbconnection;

import javase08.t02.dao.Book;
import javase08.t02.dao.LibraryDao;
import javase08.t02.dao.LibraryDaoImpl;
import javase08.t02.pool.ConnectionPool;
import javase08.t02.pool.ConnectionPoolImpl;

import java.util.List;

public class MyLibrary {

    public static void main(String[] args) throws Exception {
        try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
            LibraryDao libraryDAO = new LibraryDaoImpl(connectionPool);
            List<Book> books = libraryDAO.findAll();
            for (Book book : books) {
                System.out.println("book = " + book);
            }
        }
    }
}
