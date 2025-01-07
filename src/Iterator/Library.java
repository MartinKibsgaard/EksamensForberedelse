package Iterator;

import java.util.*;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Iterator<Book> getStandardIterator() {
        return books.iterator();
    }

    public Iterator<Book> getTitleSortedIterator() {
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle));
        return sortedBooks.iterator();
    }

    public Iterator<Book> getYearSortedIterator() {
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparingInt(Book::getYear));
        return sortedBooks.iterator();
    }
}