package com.lms.Book;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public class SearchBooksByTitleStrategy implements SearchBookStrategy{

    @Override
    public List<Book> getBooks(Map<String, Book> books, String title) {
        return books.values()
                .stream()
                .filter(book -> Objects.equals(book.getTitle(), title))
                .toList();
    }
}
