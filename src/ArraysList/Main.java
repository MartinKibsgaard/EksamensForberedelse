package ArraysList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Vælg en funktion:");
            System.out.println("1: Tilføj bog");
            System.out.println("2: Vis bøger");
            System.out.println("3: Søg efter bog");
            System.out.println("4: Fjern bog");
            System.out.println("5: Afslut");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manager.addBook(scanner);
                case 2 -> manager.showBooks();
                case 3 -> manager.searchBook(scanner);
                case 4 -> manager.removeBook(scanner);
                case 5 -> running = false;
                default -> System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
}
