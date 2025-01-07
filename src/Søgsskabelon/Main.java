package Søgsskabelon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.run();
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

class BookStore {
    private ArrayList<Book> catalog = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        seedBooks(); // Tilføj nogle foruddefinerede bøger
        boolean running = true;

        while (running) {
            System.out.println("\n--- Book Store ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Books");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBooks();
                case 4 -> displayAllBooks();
                case 5 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void seedBooks() {
        catalog.add(new Book("Java Programming", "Daniel Liang", "1234567890123"));
        catalog.add(new Book("Clean Code", "Robert C. Martin", "9876543210987"));
        catalog.add(new Book("Head First Java", "Kathy Sierra", "1234509876543"));
        catalog.add(new Book("Effective Java", "Joshua Bloch", "4567891234567"));
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN (13 digits): ");
        String isbn = scanner.nextLine();

        if (isbn.length() != 13 || !isbn.matches("\\d+")) {
            System.out.println("Invalid ISBN format. ISBN must be 13 digits.");
            return;
        }

        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Book with this ISBN already exists.");
                return;
            }
        }

        catalog.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    private void removeBook() {
        System.out.print("Enter ISBN of book to remove: ");
        String isbn = scanner.nextLine();

        Book toRemove = null;
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                toRemove = book;
                break;
            }
        }

        if (toRemove != null) {
            catalog.remove(toRemove);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("No book found with the given ISBN.");
        }
    }

    private void searchBooks() {
        System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. ISBN");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter search query: ");
        String query = scanner.nextLine().toLowerCase();

        ArrayList<Book> results = new ArrayList<>();
        switch (choice) {
            case 1 -> results = searchByTitle(query);
            case 2 -> results = searchByAuthor(query);
            case 3 -> results = searchByIsbn(query);
            default -> System.out.println("Invalid option. Please try again.");
        }

        if (!results.isEmpty()) {
            System.out.println("Search Results:");
            for (Book book : results) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found matching your query.");
        }
    }

    private ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(title)) {
                results.add(book);
            }
        }
        return results;
    }

    private ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getAuthor().toLowerCase().contains(author)) {
                results.add(book);
            }
        }
        return results;
    }

    private ArrayList<Book> searchByIsbn(String isbn) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                results.add(book);
            }
        }
        return results;
    }

    private void displayAllBooks() {
        System.out.println("Books in catalog:");
        for (Book book : catalog) {
            System.out.println(book);
        }
    }
}