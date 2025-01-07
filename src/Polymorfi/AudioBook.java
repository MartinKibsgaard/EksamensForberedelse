package Polymorfi;

public class AudioBook extends Media{
    private String author;
    private int duration;

    public AudioBook(String title, String author, int duration) {
        super(title);
        this.author = author;
        this.duration = duration;
    }

    @Override
    public void printDetails() {
        System.out.println("AudioBook: " + getTitle() + " by " + author + " (" + duration + ")");
    }
}
