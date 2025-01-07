package Polymorfi;

class Book extends Media {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public void printDetails() {
        System.out.println("Book: " + getTitle() + " by " + author);
    }
}