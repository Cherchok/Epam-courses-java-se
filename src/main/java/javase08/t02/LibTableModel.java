package javase08.t02;

import javase08.t02.dao.Book;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class LibTableModel extends AbstractTableModel {

    private List<Book> books = new ArrayList<>();
    private static final String[] columns = {"book title", "author"};


    public LibTableModel() {
    }

    public LibTableModel(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Book getBookFromRow(int row) {
        return books.get(row);
    }

    public void update(List<Book> books) {
        if (books == null) books = new ArrayList<>();
        this.books = books;
        fireTableDataChanged();
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getTitle();
            case 1:
                return book.getAuthor();
            default:
                return null;
        }
    }
}
