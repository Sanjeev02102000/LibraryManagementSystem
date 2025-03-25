package com.lms.Patron;

import com.lms.Book.Book;

import java.util.HashMap;
import java.util.Map;

public class Patron {
    private final String id;
    private String name;
    private int age;
    private String gender;

    private String emailAddress;

    private String mobileNumber;
    private Map<String, Book> patronHistory;
    private Map<String, Book> borrowedBooks;

    public Map<String, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Patron(String id, String name, int age, String gender, String emailAddress, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.patronHistory = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, Book> getPatronHistory() {
        return patronHistory;
    }

    public void borrowBook(Book book) {
        borrowedBooks.put(book.getId(), book);
        patronHistory.put(book.getId(), book);
        System.out.printf("Book %s borrowed successfully by Patron %s%n", book.getTitle(), this.name);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book.getId());
        System.out.printf("Book %s returned successfully by Patron %s%n", book.getTitle(), this.name);
    }
}
