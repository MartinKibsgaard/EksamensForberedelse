package AssocieringAggregeringOgKomposition;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isLoaned;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isLoaned = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ")";
    }
}