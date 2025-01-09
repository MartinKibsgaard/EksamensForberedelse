package ArraysList;

public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Titel: " + title + ", Forfatter: " + author + ", Sidetal: " + pages;
    }
}
