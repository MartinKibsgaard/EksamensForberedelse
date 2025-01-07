package AssocieringAggregeringOgKomposition;

// Klassen Loan repræsenterer et lån (Komposition)
public class Loan {
    private Book book;
    private String startDate;
    private String endDate;

    public Loan(Book book, String startDate, String endDate) {
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return book.getTitle() + " loaned from " + startDate + " to " + endDate;
    }
}
