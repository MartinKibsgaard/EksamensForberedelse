package Polymorfi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private List<Media> library = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addMedia(Media media) {
        library.add(media);
    }

    public void displayAllMedia() {
        if (library.isEmpty()) {
            System.out.println("No media in the library.");
        } else {
            for (Media media : library) {
                media.printDetails();
            }
        }
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add Movie");
            System.out.println("4. Add Audio Book");
            System.out.println("5. Display All Media");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addMagazine();
                    case 3 -> addMovie();
                    case 4 -> addAudioBook();
                    case 5 -> displayAllMedia();
                    case 6 -> running = false;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty!");
            return;
        }

        System.out.print("Enter author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Author cannot be empty!");
            return;
        }

        addMedia(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private void addMagazine() {
        System.out.print("Enter magazine title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty!");
            return;
        }

        System.out.print("Enter issue number: ");
        try {
            int issueNumber = Integer.parseInt(scanner.nextLine());
            addMedia(new Magazine(title, issueNumber));
            System.out.println("Magazine added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Issue number must be a valid number!");
        }
    }

    private void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty!");
            return;
        }

        System.out.print("Enter director: ");
        String director = scanner.nextLine().trim();
        if (director.isEmpty()) {
            System.out.println("Director cannot be empty!");
            return;
        }

        addMedia(new Movie(title, director));
        System.out.println("Movie added successfully!");
    }

    private void addAudioBook() {
        System.out.println("Enter Audio Book title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty");
            return;
        }

        System.out.println("Enter author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Author cannot be empty");
            return;
        }

        System.out.println("Enter duration");

        try {
            int duration = Integer.parseInt(scanner.nextLine());
            addMedia(new AudioBook(title, author, duration));
            System.out.println("Audio Book added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Duration must be a valid number!");
        }

    }


    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addMedia(new Book("The Alchemist", "Paulo Coelho"));
        librarySystem.addMedia(new Magazine("National Geographic", 202));
        librarySystem.addMedia(new Movie("Inception", "Christopher Nolan"));

        librarySystem.start();
    }
}