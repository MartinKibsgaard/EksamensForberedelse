package AssocieringAggregeringOgKomposition;

import java.util.ArrayList;
import java.util.List;

// Klassen Library repræsenterer et bibliotek (Aggregat)
public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(LibraryMember member) {
        members.add(member);
    }

    public void createLoan(LibraryMember member, Book book, String startDate, String endDate) {
        if (!book.isLoaned()) {
            Loan loan = new Loan(book, startDate, endDate);
            member.addLoan(loan);
            book.setLoaned(true);
            System.out.println("Loan created: " + loan);
        } else {
            System.out.println("Book is already loaned: " + book.getTitle());
        }
    }

    public void listLoans(LibraryMember member) {
        System.out.println("Loans for " + member + ":");
        for (Loan loan : member.getLoans()) {
            System.out.println(loan);
        }
    }
}
