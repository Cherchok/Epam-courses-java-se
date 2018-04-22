package javase08.t02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    private Connection connection;
    private String sql;

    public LibraryDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBook(Book book) {
        sql = "INSERT INTO Module8DB.library (book_title, author) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getLibrary() {
        List<Book> list = new ArrayList<>();
        sql = "SELECT * FROM Module8DB.library";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getTitle(Book book) {
        sql = "SELECT * FROM Module8DB.library WHERE book_id=" + book.getId();
        String title = null;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                title = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

    public String getAuthor(Book book) {
        sql = "SELECT * FROM Module8DB.library WHERE book_id=" + book.getId();
        String title = null;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                title = rs.getString(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

    public void updateTitle(Book book, String newTitle) {
        sql = "UPDATE Module8DB.library SET=" + "'" + newTitle + "'" + " WHERE book_id=" + book.getId();
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAuthor(Book book, String newAuthor) {
        sql = "UPDATE Module8DB.library SET=" + "'" + newAuthor + "'" + " WHERE book_id=" + book.getId();
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book) {
        sql = "DELETE FROM Module8DB.library WHERE book_title=" + "'" + book.getTitle() + "'";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
