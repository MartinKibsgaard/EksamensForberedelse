package ArkitekturOgSerializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.dat";
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nBibliotek Menu:");
            System.out.println("1. Tilføj ny bog");
            System.out.println("2. Vis bøger");
            System.out.println("3. Gem bøger");
            System.out.println("4. Læs bøger");
            System.out.println("5. Afslut");
            System.out.print("Vælg en mulighed: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Ryd scanner buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> saveBooks();
                case 4 -> loadBooks();
                case 5 -> {
                    System.out.println("Farvel!");
                    return;
                }
                default -> System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void addBook() {
        System.out.print("Indtast titel: ");
        String title = scanner.nextLine();
        System.out.print("Indtast forfatter: ");
        String author = scanner.nextLine();
        System.out.print("Indtast ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Indtast udgivelsesår: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Ryd scanner buffer

        books.add(new Book(title, author, isbn, year));
        System.out.println("Bogen er tilføjet!");
    }

    private void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Der er ingen bøger i biblioteket.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
            System.out.println("Bøger gemt til filen " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Fejl under gemning: " + e.getMessage());
        }
    }

    private void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
            System.out.println("Bøger indlæst fra filen " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fejl under indlæsning: " + e.getMessage());
        }
    }
}
