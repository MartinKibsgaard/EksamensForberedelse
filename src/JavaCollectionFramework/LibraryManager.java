package JavaCollectionFramework;

import java.util.*;


public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public LibraryManager() {
        books.add(new Book("Java in a Nutshell", "Benjamin J. Evans", "978-1-4493-7986-4", 5));
        books.add(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 3));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", "978-0-596-00712-6", 2));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-1-4088-5569-0", 4));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "978-1-4088-5578-2", 3));
        books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "978-1-4088-5560-7", 2));
        books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", "978-1-4088-5561-4", 1));
        books.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "978-1-4088-5562-1", 0));
        books.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", "978-1-4088-5563-8", 5));
        books.add(new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", "978-1-4088-5564-5", 6));
        books.add(new Book("Fantastic Beasts and Where to Find Them", "J.K. Rowling", "978-1-4088-5579-9", 7));
        books.add(new Book("Quidditch Through the Ages", "J.K. Rowling", "978-1-4088-5580-5", 8));
        books.add(new Book("The Tales of Beedle the Bard", "J.K. Rowling", "978-1-4088-5581-2", 9));
        books.add(new Book("The Casual Vacancy", "J.K. Rowling", "978-0-316-20687-2", 10));
        books.add(new Book("The Cuckoo's Calling", "J.K. Rowling", "978-1-4088-5778-6", 11));
        books.add(new Book("The Silkworm", "J.K. Rowling", "978-1-4088-5779-3", 12));
        books.add(new Book("Career of Evil", "J.K. Rowling", "978-0-7515-6287-7", 13));
    }

    public void run() {
        System.out.println("Velkommen til Bibliotekssystemet!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tilføj ny bog");
            System.out.println("2. Søg efter bog");
            System.out.println("3. Opdater antal eksemplarer");
            System.out.println("4. Sorter bøger");
            System.out.println("5. Vis alle bøger");
            System.out.println("6. Afslut");

            System.out.print("Vælg en handling: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // For at rydde buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> searchBook();
                case 3 -> updateCopies();
                case 4 -> sortBooks();
                case 5 -> displayBooks();
                case 6 -> {
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
        System.out.print("Indtast antal eksemplarer: ");
        int copies = scanner.nextInt();
        scanner.nextLine();

        try {
            books.add(new Book(title, author, isbn, copies));
            System.out.println("Bogen er tilføjet!");
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    private void searchBook() {
        System.out.println("Søg baseret på:");
        System.out.println("1. Titel");
        System.out.println("2. Forfatter");
        System.out.println("3. ISBN");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Indtast søgetekst: ");
        String query = scanner.nextLine();

        books.stream()
                .filter(book -> (choice == 1 && book.getTitle().toLowerCase().contains(query.toLowerCase())) ||
                        (choice == 2 && book.getAuthor().toLowerCase().contains(query.toLowerCase())) ||
                        choice == 3 && book.getIsbn().equalsIgnoreCase(query))
                .forEach(System.out::println);
    }

    private void updateCopies() {
        System.out.print("Indtast ISBN på bogen, der skal opdateres: ");
        String isbn = scanner.nextLine();

        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                System.out.print("Indtast nyt antal eksemplarer: ");
                int newCopies = scanner.nextInt();
                scanner.nextLine();
                try {
                    book.setCopies(newCopies);
                    System.out.println("Antal eksemplarer opdateret!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Fejl: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Bog ikke fundet.");
    }

    private void sortBooks() {
        System.out.println("Sortér efter:");
        System.out.println("1. Titel");
        System.out.println("2. Forfatter");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            books.sort(Comparator.comparing(Book::getTitle));
        } else if (choice == 2) {
            books.sort(Comparator.comparing(Book::getAuthor));
        } else {
            System.out.println("Ugyldigt valg.");
            return;
        }
        System.out.println("Bøger sorteret!");
    }

    private void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Ingen bøger at vise.");
        } else {
            books.forEach(System.out::println);
        }
    }
}