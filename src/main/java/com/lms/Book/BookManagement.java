package com.lms.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookManagement {
    Map<String, Book> books;

    public BookManagement() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book added " + book.getTitle());
    }

    public Book removeBook(Book book){
        System.out.println("Book removed " + book.getTitle());
        return books.remove(book.getId());
    }

    public Book getBookById(String id) {
        return books.get(id);
    }

    public void getBooks(SearchBookStrategy searchBookStrategy, String searchFilter) {
        List<Book> resBooks = searchBookStrategy.getBooks(books, searchFilter);
        if(resBooks.size() == 0) {
            System.out.println("No Matching book found with param: " + searchFilter);
        }
        for(Book book : resBooks) {
            System.out.println("Found Book with Matching Title");
            book.display();
        }
    }

    public void updateBook(String id, String _ISBN, String author, String title, int publicationYear, String genre) {
        Book book = books.get(id);
        if(book == null) {
            System.out.println("Unable to find book with id: "+ id);
            return;
        }
        book.setAuthor(author);
        book.setGenre(genre);
        book.setTitle(title);
        book.setiSBN(_ISBN);
        book.setPublicationYear(publicationYear);
        System.out.println("Book updated Successfully");
    }

    public void markBookAsBorrowed(String id) {
        if(!books.containsKey(id)) {
            System.out.println("Unable to find book with id: "+ id);
            return;
        }
        if(books.get(id).isBorrowed()) {
            System.out.println("Book already borrowed");
            return;
        }
        books.get(id).setBorrowed(true);
    }

    public void markBookAsReturned(String id) {
        if(!books.containsKey(id)) {
            System.out.println("Unable to find book with id: "+ id);
            return;
        }
        if(!books.get(id).isBorrowed()) {
            System.out.println("Book has not been borrowed, hence unable to return");
            return;
        }
        books.get(id).setBorrowed(false);
    }

    public Map<String, Book> getAvailableBooks() {
        Map<String, Book> availableBooks = new HashMap<>();
        books.forEach((key, value) -> {
            if (!value.isBorrowed()) {
                availableBooks.put(key, value);
            }
        });
        return availableBooks;
    }

    public Map<String, Book> getBorrowedBooks() {
        Map<String, Book> borrowedBooks = new HashMap<>();
        books.forEach((key, value) -> {
            if (value.isBorrowed()) {
                borrowedBooks.put(key, value);
            }
        });
        return borrowedBooks;
    }
}
