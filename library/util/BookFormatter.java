package library.util;

import library.model.Book;

public class BookFormatter {
    public static String formatBookInfo(Book book) {
        return String.format("Title: %s, Author: %s (ISBN: %s)",
                book.getTitle(), book.getAuthor(), book.getIsbn());
    }
}
