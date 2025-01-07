package Lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public List<Book> filterByPrice(double minPrice) {
        return books.stream()
                .filter(book -> book.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }

    public List<Book> searchByTitle(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooks(String criteria, boolean ascending) {
        Comparator<Book> comparator;

        if ("price".equalsIgnoreCase(criteria)) {
            comparator = Comparator.comparing(Book::getPrice);
        } else if ("title".equalsIgnoreCase(criteria)) {
            comparator = Comparator.comparing(Book::getTitle);
        } else {
            throw new IllegalArgumentException("Ugyldigt sorteringskriterium");
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        return books.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}