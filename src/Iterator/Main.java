package Iterator;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.addBook(new Book("One Hundred Years of Solitude", "Gabriel García Márquez", 1967));
        library.addBook(new Book("Brave New World", "Aldous Huxley", 1932));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        library.addBook(new Book("Animal Farm", "George Orwell", 1945));
        library.addBook(new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vælg sorteringsmetode:");
            System.out.println("1. Standard rækkefølge");
            System.out.println("2. Titel");
            System.out.println("3. Udgivelsesår");
            System.out.println("4. Afslut");

            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Afslutter programmet.");
                break;
            }

            Iterator<Book> iterator = null;
            switch (choice) {
                case 1:
                    iterator = library.getStandardIterator();
                    break;
                case 2:
                    iterator = library.getTitleSortedIterator();
                    break;
                case 3:
                    iterator = library.getYearSortedIterator();
                    break;
                default:
                    System.out.println("Ugyldigt valg, prøv igen.");
                    continue;
            }

            System.out.println("Bøger i biblioteket:");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

        scanner.close();
    }
}