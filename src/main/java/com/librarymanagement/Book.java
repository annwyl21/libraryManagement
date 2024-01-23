package com.librarymanagement;
import com.librarymanagement.Library;

public class Book {

    // Instance variables marked as protected and final.
    // Protected: accessible within the package and in subclasses.
    // Final: the value can't be modified after being set.
    protected final String title;
    protected final String author;
    protected BookStatus status; // Represents the current status of the book.

    protected BookType bookType;

    // Enum for representing book status with two possible values: AVAILABLE and BORROWED.
    protected enum BookStatus {
        AVAILABLE,
        BORROWED
    }

    protected enum BookType {
        PRINTED,
        ONLINE
    }

    // Constructor to initialize a Book object.
    public Book(String newTitle, String newAuthor) {
        this.title = newTitle; // Sets the title of the book.
        this.author = newAuthor; // Sets the author of the book.
        this.status = BookStatus.AVAILABLE; // Default status is AVAILABLE.
        this.bookType = BookType.PRINTED; // Default book type is printed format unless otherwise specified.
    }

    // Setter for BookType
    public void setBookType() {
        this.bookType = BookType.ONLINE;
        System.out.println(this.bookType);
    }

    // Getter for Enum
    public String getStatusAsString() {
        return this.status.toString();
    }

    // Method to check if the book is available.
    public Boolean isAvailable() {
        // Returns true if the status is AVAILABLE, false otherwise.
        return this.status == BookStatus.AVAILABLE;
    }

    // Setter for book status
    public void setBookStatus() {
        if (this.status == BookStatus.AVAILABLE) {
            // Update status to Borrowed if Available
            this.status = BookStatus.BORROWED;
        } else {
            // Update status to Available if Borrowed
            this.status = BookStatus.AVAILABLE;
        }
    }

    // Getter for book status
    public BookStatus getStatus() {
        return this.status;
    }

    // Overridden toString method to return the book's details as a string.
    @Override
    public String toString() {
        return status + " " + bookType + " " + title + " by " + author; // Formats and returns book information.
    }

}
