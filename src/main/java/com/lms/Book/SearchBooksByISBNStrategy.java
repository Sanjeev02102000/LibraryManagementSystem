package com.lms.Book;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SearchBooksByISBNStrategy implements SearchBookStrategy {
    @Override
    public List<Book> getBooks(Map<String, Book> books, String _ISBN) {
        return books.values().stream()
                .filter(book -> Objects.equals(book.getiSBN(), _ISBN))
                .toList();
    }
}
