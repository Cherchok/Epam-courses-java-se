package javase08.t02.dao;


import javase08.t02.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDao {

    private ConnectionPool connectionPool;

    public LibraryDaoImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void add(Book book) throws DaoException {
        String sql = "INSERT INTO Module8DB.library (book_title, author) " +
                "VALUES (?,?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Book> findAll() throws DaoException {
        List<Book> library = new ArrayList<>();
        String sql = "SELECT id, book_title, author FROM Module8DB.library ORDER BY book_title";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                library.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return library;
    }

    @Override
    public Book find(int bookId) throws DaoException {
         // 5435' UNION select * from e where u = 'lih
        String sql = "SELECT id, book_title, author FROM Module8DB.library WHERE id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Book> findByTitle(String title) throws DaoException {
        List<Book> lib = new ArrayList<>();

        String sql = "SELECT id, book_title, author FROM Module8DB.library WHERE book_title LIKE ? ORDER BY book_title";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, title + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lib.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return lib;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Book book) throws DaoException {
        String sql = "UPDATE Module8DB.library SET book_title = ? , author = ? WHERE id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(int bookId) throws DaoException {
        String sql = "DELETE FROM Module8DB.library WHERE id = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,bookId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
