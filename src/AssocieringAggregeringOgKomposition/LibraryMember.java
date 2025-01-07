package AssocieringAggregeringOgKomposition;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private String membershipId;
    private List<Loan> loans; //Liste over lån (Komposition)

    public LibraryMember(String name, String membershipId) {
        this.name = name;
        this.membershipId = membershipId;
        this.loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        return name + " (ID: " + membershipId + ")";
    }
}
