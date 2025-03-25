package com.lms;

import com.lms.Book.Book;
import com.lms.Book.BookBuilder;
import com.lms.Book.BookManagement;
import com.lms.Lending.LendingMgmt;
import com.lms.LibraryManagement.LibraryManagement;
import com.lms.Patron.Patron;
import com.lms.Patron.PatronManagement;

import java.util.UUID;

public class LibraryManagementSystem {
    public static void main(String [] args) {
        Book book = new BookBuilder()
                .setId(UUID.randomUUID().toString())
                .setTitle("Shoe Dog")
                .setAuthor("Phil Knight")
                .setiSBN("JSAC2007")
                .setGenre("autobiography")
                .setPublicationYear(2007)
                .build();
        Patron patron = new Patron(UUID.randomUUID().toString(), "Maverick", 27, "Male", "maverick@gmail.com", "987654321");

        BookManagement bookManagement = new BookManagement();
        PatronManagement patronManagement = new PatronManagement();
        LendingMgmt lendingMgmt = new LendingMgmt(bookManagement, patronManagement);

        LibraryManagement libraryManagement = new LibraryManagement(UUID.randomUUID().toString(), "Hyderabad", "city library", bookManagement, patronManagement, lendingMgmt);
        bookManagement.addBook(book);
        patronManagement.addPatron(patron);

        lendingMgmt.borrowBook(patron.getId(), book.getId());

        Patron patron2 = new Patron(UUID.randomUUID().toString(), "Stephen", 45, "Male", "stephen@yahoo.com", "7323715241");

        patronManagement.addPatron(patron2);

        libraryManagement.borrowBook(patron2.getId(), book.getId());
        libraryManagement.returnBook(patron.getId(), book.getId());
        libraryManagement.borrowBook(patron2.getId(), book.getId());
        libraryManagement.searchBooksByTitle("Shoe Dog");
        libraryManagement.searchBooksByTitle("Shoe Dog 2");
    }
}
