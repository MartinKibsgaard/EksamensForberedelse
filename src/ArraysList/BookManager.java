package ArraysList;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Scanner scanner) {
        System.out.print("Indtast titel: ");
        String title = scanner.nextLine();
        System.out.print("Indtast forfatter: ");
        String author = scanner.nextLine();
        System.out.print("Indtast sidetal: ");
        int pages;

        try {
            pages = Integer.parseInt(scanner.nextLine());
            if (pages <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt antal sidetal. Bog blev ikke tilføjet.");
            return;
        }

        books.add(new Book(title, author, pages));
        System.out.println("Bog tilføjet!");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Ingen bøger i samlingen.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(Scanner scanner) {
        System.out.print("Indtast titel at søge efter: ");
        String title = scanner.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Ingen bøger fundet med titlen: " + title);
        }
    }

    public void removeBook(Scanner scanner) {
        System.out.print("Indtast titel at fjerne: ");
        String title = scanner.nextLine();
        boolean removed = books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));

        if (removed) {
            System.out.println("Bogen blev fjernet.");
        } else {
            System.out.println("Ingen bøger fundet med titlen: " + title);
        }
    }
}
