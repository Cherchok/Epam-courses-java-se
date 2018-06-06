package javase08.t02.dao;

import java.util.List;

public interface LibraryDao {

    void add(Book book) throws DaoException;

    List<Book> findAll() throws DaoException;

    Book find(int bookId) throws DaoException;

    List<Book> findByTitle(String title) throws DaoException;

    void update(Book book) throws DaoException;

    void delete(int bookId) throws DaoException;
}
