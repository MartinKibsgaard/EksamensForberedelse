package Polymorfi;

class Magazine extends Media {
    private int issueNumber;

    public Magazine(String title, int issueNumber) {
        super(title);
        this.issueNumber = issueNumber;
    }

    @Override
    public void printDetails() {
        System.out.println("Magazine: " + getTitle() + " (Issue " + issueNumber + ")");
    }
}