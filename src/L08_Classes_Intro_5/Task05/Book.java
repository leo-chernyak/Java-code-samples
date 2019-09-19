package L08_Classes_Intro_5.Task05;

import java.util.Comparator;

public class Book {
    private String name;
    private String author;
    private int year;

    Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() { return name;}
    public String getAuthor() { return author;}
    public int getYear() { return year;}


    public static Comparator<Book> ByName = Comparator.comparing(Book::getName);
    public static Comparator<Book> ByAutor = Comparator.comparing(Book::getAuthor);
    public static Comparator<Book> ByYear = Comparator.comparing(Book::getYear);

    @Override
    public String toString() {
        return name + " " + author + " " + year;
    }
}
