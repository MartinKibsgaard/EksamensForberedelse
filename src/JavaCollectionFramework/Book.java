package JavaCollectionFramework;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int copies;

    public Book(String title, String author, String isbn, int copies) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty() || copies < 0) {
            throw new IllegalArgumentException("Ugyldige bogdata");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        if (copies < 0) {
            throw new IllegalArgumentException("Antal eksemplarer skal være positivt");
        }
        this.copies = copies;
    }

    @Override
    public String toString() {
        return String.format("Titel: %s, Forfatter: %s, ISBN: %s, Eksemplarer: %d", title, author, isbn, copies);
    }
}