package javase08.t02;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int anInt, String title, String author) {
        this.id=anInt;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
