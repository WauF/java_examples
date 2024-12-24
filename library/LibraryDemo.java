package library;

import library.model.Book;
import library.service.LibraryService;
import library.util.BookFormatter;

public class LibraryDemo {
    public static void main(String[] args) {
        // Create service instance
        LibraryService service = new LibraryService();

        // Add some books
        service.addBook(new Book("1984", "George Orwell", "123456"));
        service.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "789012"));

        // Display all books using the formatter
        System.out.println("\nLibrary Catalog:");
        for (Book book : service.getAllBooks()) {
            System.out.println(BookFormatter.formatBookInfo(book));
        }
    }
}
