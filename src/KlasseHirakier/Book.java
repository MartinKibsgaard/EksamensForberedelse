package KlasseHirakier;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Titel og forfatter kan ikke være tomme.");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Udgivelsesår skal være et positivt heltal.");
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
