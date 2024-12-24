package library.service;

import library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
