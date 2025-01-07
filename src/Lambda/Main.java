package Lambda;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Java Programming", 49.99),
                new Book("Effective Java", 39.99),
                new Book("Clean Code", 29.99),
                new Book("Java Streams", 19.99)
        );

        BookStore store = new BookStore(books);

        System.out.println("Filtrér bøger med minimumspris 30:");
        System.out.println(store.filterByPrice(30));

        System.out.println("\nSøg efter bøger med 'Java' i titlen:");
        System.out.println(store.searchByTitle("Java"));

        System.out.println("\nSortér bøger efter pris i stigende rækkefølge:");
        System.out.println(store.sortBooks("price", true));

        System.out.println("\nSortér bøger efter titel i faldende rækkefølge:");
        System.out.println(store.sortBooks("title", false));
    }
}