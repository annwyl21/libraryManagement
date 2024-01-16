public class Book {

    // static variable
    public static int totalBooks = 0;

    // Instance variables
    protected String title;
    protected String author;
    protected BookStatus status;

    protected enum BookStatus {
        AVAILABLE,
        BORROWED
    }

    public Book(String newTitle, String newAuthor) {
        this.title = newTitle;
        this.author = newAuthor;
        this.status = BookStatus.AVAILABLE;

        totalBooks += 1;
    }

    public Boolean isAvailable() {
        if (this.status.equals("AVAILABLE")) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Book: " + title + " " + author + " ";
    }

    public static void main(String[] args) {

        Book tolkien = new Book("The Lord of the Rings", "J. R. Tolkien");
        System.out.println(tolkien.toString());

        System.out.println(totalBooks);

    }
}
