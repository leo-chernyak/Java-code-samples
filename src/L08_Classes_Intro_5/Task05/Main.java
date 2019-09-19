package L08_Classes_Intro_5.Task05;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 10; ++i) {
            books.add(new Book("John" + i + 1, "Doe " + i, (int)(Math.random() * 2006)));
        }
        Library library = new Library(books);
        library.print();
        library.sort(Book.ByYear);
        System.out.println();
        library.print();
        library.findBook(new Book("", "Doe 1", 0), Book.ByAutor);
    }
}
