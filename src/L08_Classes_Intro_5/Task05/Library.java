package L08_Classes_Intro_5.Task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
    List<Book> books;

    Library(ArrayList<Book> books) {
        this.books = books;
    }

    public void deleteBook( Book book) {
        books.remove(book);
    }

    public void addBook( Book book) {
        books.add(book);
    }

    public void sort(Comparator comp) {
        Collections.sort(books, comp);
    }

    public void print() {
        for (var book : books)
            System.out.println(book);
    }

    public Book findBook(Book book, Comparator comp) {
        System.out.println("\nFounded...");
        for (var Book : books){
            if (comp.compare(Book, book) == 0) {
                System.out.println(Book);
                return Book;
            }
        }
        return null;
    }
}