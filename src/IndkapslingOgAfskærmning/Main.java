package IndkapslingOgAfskærmning;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 5));
        manager.addBook(new Book("Java Programming", "Daniel Liang", 10));
        manager.addBook(new Book("Clean Code", "Robert C. Martin", 5));
        manager.addBook(new Book("Effective Java", "Joshua Bloch", 8));
        manager.addBook(new Book("Java Concurrency in Practice", "Joshua Bloch", 3));
        manager.addBook(new Book("Effective Java 3rd Edition", "Joshua Bloch", 2));
        manager.addBook(new Book("Java Puzzlers", "Joshua Bloch", 4));
        manager.addBook(new Book("Java Performance", "Joshua Bloch", 6));

        System.out.println("Books in stock:");
        manager.printInventory();

        System.out.println("\nFinding book by title:");
        Book book = manager.findBook("Java Programming");
        System.out.println(book);

        System.out.println("\nFiltering books by author:");
        manager.filterByAuthor("Joshua Bloch").forEach(System.out::println);

        System.out.println("\nRemoving book:");
        Book book1 = manager.findBook("Java Performance");
        manager.removeBook(book1);
        manager.printInventory();

        System.out.println("\nIncreasing stock:");
        Book book2 = manager.findBook("Java Programming");
        book2.increaseStock(5);
        manager.printInventory();

    }
}
