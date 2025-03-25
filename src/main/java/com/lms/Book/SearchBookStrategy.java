package com.lms.Book;

import java.util.List;
import java.util.Map;

public interface SearchBookStrategy {
    public List<Book> getBooks(Map<String, Book> books, String searchFilter);
}
