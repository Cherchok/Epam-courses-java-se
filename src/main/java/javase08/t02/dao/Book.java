package javase08.t02.dao;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;

    public Book(String title, String author){
        this.author = author;
        this.title = title;
    }

}
