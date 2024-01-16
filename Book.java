public class Book {

    // Instance variables marked as protected and final.
    // Protected: accessible within the package and in subclasses.
    // Final: the value can't be modified after being set.
    protected final String title;
    protected final String author;
    protected BookStatus status; // Represents the current status of the book.

    // Enum for representing book status with two possible values: AVAILABLE and BORROWED.
    protected enum BookStatus {
        AVAILABLE,
        BORROWED
    }

    // Constructor to initialize a Book object.
    public Book(String newTitle, String newAuthor) {
        this.title = newTitle; // Sets the title of the book.
        this.author = newAuthor; // Sets the author of the book.
        this.status = BookStatus.AVAILABLE; // Default status is AVAILABLE.
    }

    // Method to check if the book is available.
    public Boolean isAvailable() {
        // Returns true if the status is AVAILABLE, false otherwise.
        return this.status == BookStatus.BORROWED;
    }

    // Overridden toString method to return the book's details as a string.
    @Override
    public String toString() {
        return title + " by " + author + " "; // Formats and returns book information.
    }

}
