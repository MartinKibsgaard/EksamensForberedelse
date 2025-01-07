package KlasseHirakier;

import java.util.*;

public class LibraryManager {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Tilføj en bog");
            System.out.println("2. Slet en bog");
            System.out.println("3. Vis bøger");
            System.out.println("4. Afslut");
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // For at håndtere newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    running = false;
                    System.out.println("Program afsluttes.");
                    break;
                default:
                    System.out.println("Ugyldigt valg, prøv igen.");
            }
        }

        scanner.close();
    }

    public static void addBook(Scanner scanner) {
        try {
            System.out.println("Indtast titel: ");
            String title = scanner.nextLine();
            System.out.print("Indtast forfatter: ");
            String author = scanner.nextLine();
            System.out.print("Indtast udgivelsesår: ");
            int year = Integer.parseInt(scanner.nextLine());
            library.addBook(new Book(title, author, year));
            System.out.println("Bogen er tilføjet!");
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    public static void removeBook(Scanner scanner) {
        System.out.println("Indtast titlen på bogen, der skal slettes: ");
        String titleToRemove = scanner.nextLine();
        if (library.removeBook(titleToRemove)) {
            System.out.println("Bogen er slettet");
        } else {
            System.out.println("Kunne ikke finde en bog med denne title.");
        }
    }

    public static void showBooks() {
        List<Book> books = library.listBooks();
        if (books.isEmpty()) {
            System.out.println("Ingen bøger tilgængelige.");
        } else {
            System.out.println("Bøger i biblioteket");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
