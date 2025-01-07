package ArkitekturOgSerializable;

import java.io.Serializable;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getters og setters
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + publicationYear + "]";
    }
}