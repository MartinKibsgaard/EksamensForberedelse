package IndkapslingOgAfskærmning;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Book> books;

    public InventoryManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> filterByAuthor(String author) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public void printInventory() {
        for (Book book : books) {
            System.out.println(book);
        }
    }


}