package AssocieringAggregeringOgKomposition;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Tilføj bøger
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "12345");
        Book book2 = new Book("1984", "George Orwell", "67890");
        Book book3 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "54321");
        Book book4 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "09876");
        Book book5 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "13579");
        Book book6 = new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", "24680");
        Book book7 = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "97531");
        Book book8 = new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", "86420");
        Book book9 = new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", "75319");


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);

        // Registrer låner
        LibraryMember member1 = new LibraryMember("John Doe", "001");
        LibraryMember member2 = new LibraryMember("Martin Kibsgaard", "204");
        library.registerMember(member1);

        // Opret lån
        library.createLoan(member1, book1, "2025-01-05", "2025-01-20");
        library.createLoan(member2, book3, "2025-01-05", "2025-01-20");
        library.createLoan(member2, book4, "2025-01-05", "2025-01-20");

        // Vis lån
        library.listLoans(member1);
        System.out.println();
        library.listLoans(member2);
    }
}