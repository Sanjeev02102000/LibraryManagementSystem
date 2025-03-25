package com.lms.Lending;

import com.lms.Book.Book;
import com.lms.Book.BookManagement;
import com.lms.Patron.Patron;
import com.lms.Patron.PatronManagement;

public class LendingMgmt {
    private final BookManagement bookManagement;
    private final PatronManagement patronManagement;

    public LendingMgmt(BookManagement bookManagement, PatronManagement patronManagement) {
        this.bookManagement = bookManagement;
        this.patronManagement = patronManagement;
    }

    public void borrowBook(String patronId, String bookId) {
        if (bookManagement.getAvailableBooks().containsKey(bookId)) {
            bookManagement.markBookAsBorrowed(bookId);
            Patron patron = patronManagement.getPatronById(patronId);
            patron.borrowBook(bookManagement.getBookById(bookId));
            System.out.println("Book borrowed successfully. BookId: " + bookId + " Patron: "+ patronId);
        } else {
            System.out.println("Cannot borrow book with id: " + bookId + " Book is already borrowed");
        }
    }

    public void returnBook(String patronId, String bookId) {
        Patron patron = patronManagement.getPatronById(patronId);
        if (patron == null || !patron.getBorrowedBooks().containsKey(bookId)) {
            System.out.println("Cannot return book with id: " + bookId + " Book was not borrowed");
            return;
        }
        patron.returnBook(bookManagement.getBookById(bookId));
        bookManagement.markBookAsReturned(bookId);
        System.out.println("Book returned Successfully");
    }
}
