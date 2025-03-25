package com.lms.LibraryManagement;

import com.lms.Book.*;
import com.lms.Lending.LendingMgmt;
import com.lms.Patron.PatronManagement;

import java.util.Collections;
import java.util.List;

public class LibraryManagement {
    private String id;
    private String address;
    private String name;
    private BookManagement bookManagement;
    private PatronManagement patronManagement;

    private LendingMgmt lendingMgmt;

    public LibraryManagement(String id, String address, String name, BookManagement bookManagement, PatronManagement patronManagement, LendingMgmt lendingMgmt) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.bookManagement = bookManagement;
        this.patronManagement = patronManagement;
        this.lendingMgmt = lendingMgmt;
    }

    public void borrowBook(String patronId, String bookId) {
        lendingMgmt.borrowBook(patronId, bookId);
    }

    public void returnBook(String patronId, String bookId) {
        lendingMgmt.returnBook(patronId, bookId);
    }

    public void searchBooksByTitle(String title) {
        bookManagement.getBooks(new SearchBooksByTitleStrategy(), title);
    }

    public void searchBooksByAuthor(String author) {
        bookManagement.getBooks(new SearchBooksByAuthorStrategy(), author);
    }

    public void searchBooksByISBN(String _ISBN) {
        bookManagement.getBooks(new SearchBooksByISBNStrategy(), _ISBN);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
