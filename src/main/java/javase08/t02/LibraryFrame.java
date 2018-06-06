package javase08.t02;

import javase08.t02.dao.Book;
import javase08.t02.dao.LibraryDao;
import javase08.t02.dao.LibraryDaoImpl;
import javase08.t02.pool.ConnectionPool;
import javase08.t02.pool.ConnectionPoolImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class LibraryFrame extends JFrame {

    public static final int NO_SELECTION = -1;
    private final LibTableModel model;
    private final JTextField titleText;
    private final JTextField authorText;

    private int currentSelectedBookId = NO_SELECTION;

    public LibraryFrame(String title) {
        super(title);
        JTable table = new JTable();



        model = new LibTableModel();

        table.setModel(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        Font font = new Font("", Font.PLAIN, 22);
        table.setFont(font);
        table.setRowHeight(30);

        //        JLabel idLabel = new JLabel("id:");
        JLabel titleLabel = new JLabel("book title:");
        JLabel authorLabel = new JLabel("last name:");

        titleText = new JTextField();
        authorText = new JTextField();


        titleText.setMaximumSize(new Dimension(500, 30));
        authorText.setMaximumSize(new Dimension(500, 30));

        JButton addButton = new JButton("add");
        JButton deleteButton = new JButton("delete");
        deleteButton.setEnabled(false);
        JButton updateButton = new JButton("update");
        updateButton.setEnabled(false);
        JButton findAllButton = new JButton("find all");
        JButton findButton = new JButton("find book");
        JButton clearButton = new JButton("clear");

        this.add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel buttons = new JPanel(new GridLayout(0, 3));
//        buttons.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        buttons.setMaximumSize(new Dimension(300, 100));
//        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        buttons.add(addButton);
        buttons.add(deleteButton);
        buttons.add(updateButton);
        buttons.add(findAllButton);
        buttons.add(findButton);
        buttons.add(clearButton);


        JPanel controls = new JPanel();
        controls.setLayout(new BoxLayout(controls, BoxLayout.PAGE_AXIS));


        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.LINE_AXIS));

        titlePanel.add(titleLabel);
        titlePanel.add(titleText);

        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new BoxLayout(authorPanel, BoxLayout.LINE_AXIS));

        authorPanel.add(authorLabel);
        authorPanel.add(authorText);

        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 10));
        authorPanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 10));
        controls.add(titlePanel);
        controls.add(authorPanel);
        controls.add(buttons);
        controls.add(Box.createVerticalGlue());


        this.add(controls, BorderLayout.EAST);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                Book bookFromRow = model.getBookFromRow(selectedRow);
                titleText.setText(bookFromRow.getTitle());
                authorText.setText(bookFromRow.getAuthor());
                currentSelectedBookId = bookFromRow.getId();

                updateButton.setEnabled(true);
                deleteButton.setEnabled(true);
            }
        });
        addButton.addActionListener(e -> {
            Book book = new Book(titleText.getText(), authorText.getText());
            try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
                LibraryDao libraryDAO = new LibraryDaoImpl(connectionPool);
                libraryDAO.add(book);

                refreshTable();
                JOptionPane.showMessageDialog(null, "Book " + book.getTitle()
                        + " has been added!!!!");

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            } finally {
                resetFields();
            }
        });

        deleteButton.addActionListener(e -> {
            if (currentSelectedBookId != NO_SELECTION) {
                try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
                    LibraryDao libraryDAO = new LibraryDaoImpl(connectionPool);
                    libraryDAO.delete(currentSelectedBookId);
                    refreshTable();
//                    JOptionPane.showMessageDialog(null, "Book has been deleted successful!!!");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Book with id=" + currentSelectedBookId
                            + " does not exist!!!! " + e1.getMessage());
                } finally {
                    resetFields();
                    currentSelectedBookId = NO_SELECTION;
                    deleteButton.setEnabled(false);
                }
            }
        });

        updateButton.addActionListener(e -> {
            if (currentSelectedBookId != NO_SELECTION) {
                Book book = new Book(currentSelectedBookId, titleText.getText(), authorText.getText());
                try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
                    LibraryDao libraryDao = new LibraryDaoImpl(connectionPool);
                    libraryDao.update(book);
                    refreshTable();
//                    JOptionPane.showMessageDialog(null, "book has been updated successful!!!");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                } finally {
                    resetFields();
                    currentSelectedBookId = NO_SELECTION;
                    updateButton.setEnabled(false);
                }
            }
        });

        findAllButton.addActionListener(e -> {
            try {
                refreshTable();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            } finally {
                resetFields();
            }
        });

        findButton.addActionListener(e -> {
            try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
                LibraryDao libraryDAO = new LibraryDaoImpl(connectionPool);
                List<Book> books = libraryDAO.findByTitle(titleText.getText());
                model.update(books);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Book with id=" + currentSelectedBookId
                        + " does not exist!!!! " + e1.getMessage());
            } finally {
                resetFields();
            }
        });

        clearButton.addActionListener(e -> {
            cleanTable();
            resetFields();
        });

        this.setSize(900, 400);
    }

    private void cleanTable() {
        model.update(null);
    }


    private void refreshTable() throws Exception {
        try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
            LibraryDao libraryDAO = new LibraryDaoImpl(connectionPool);
            List<Book> books = libraryDAO.findAll();

            model.update(books);
        }
    }

    private void resetFields() {
        titleText.setText(null);
        authorText.setText(null);
    }
}
