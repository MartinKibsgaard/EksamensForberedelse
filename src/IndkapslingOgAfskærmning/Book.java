package IndkapslingOgAfskærmning;


public class Book {
    private String title;
    private String author;
    private int stock;

    public Book(String title, String author, int stock) {
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    public void increaseStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        stock += amount;
    }

    public void decreaseStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (stock - amount < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        stock -= amount;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Stock: " + stock;
    }
}