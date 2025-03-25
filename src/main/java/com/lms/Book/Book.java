package com.lms.Book;

public class Book {
    private final String id;
    private String title;
    private String author;
    private String iSBN;
    private boolean isBorrowed;
    private String genre;
    private int publicationYear;

    public Book(BookBuilder bookBuilder) {
        this.id = bookBuilder.getId();
        this.author = bookBuilder.getAuthor();
        this.title = bookBuilder.getTitle();
        this.publicationYear = bookBuilder.getPublicationYear();
        this.genre = bookBuilder.getGenre();
        this.iSBN = bookBuilder.getiSBN();
        this.isBorrowed = false;
    }


    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void display() {
        System.out.println(getId());
        System.out.println(getiSBN());
        System.out.println(getTitle());
        System.out.println(getAuthor());
        System.out.println(getGenre());
        System.out.println(getPublicationYear());
    }
}
