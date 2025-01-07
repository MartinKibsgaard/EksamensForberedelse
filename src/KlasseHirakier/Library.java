package KlasseHirakier;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }
}
