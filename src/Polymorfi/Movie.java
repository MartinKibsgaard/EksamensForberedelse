package Polymorfi;

class Movie extends Media {
    private String director;

    public Movie(String title, String director) {
        super(title);
        this.director = director;
    }

    @Override
    public void printDetails() {
        System.out.println("Movie: " + getTitle() + " directed by " + director);
    }
}