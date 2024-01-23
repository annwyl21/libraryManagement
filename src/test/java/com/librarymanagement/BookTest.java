package com.librarymanagement;
import com.librarymanagement.Library;
import com.librarymanagement.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BookTest {

    // Declaring a Book instance to be used in the tests
    public Book book;

    // Fixture
    @BeforeEach
    public void setUp() {
        // Initialize a Book object before each test
        System.out.println("Attempting to initialise book object.");
        book = new Book("Down & Out in Paris & London", "George Orwell");
        System.out.println("BookTest setUp: Book object created.");
    }

    @Disabled("Reason because fixtures isn't working properly")
    @Test
    public void testSetBookStatus() {
        // test setBookStatus using fixture to create book instance
        System.out.println("test to set book status using fixture to create book instance");

        // Initial status of the book should be available
        Book.BookStatus initialStatus = book.getStatus();
        System.out.println("get status AVAILABLE completed");
        Assertions.assertEquals(Book.BookStatus.AVAILABLE, initialStatus, "Initial status should be AVAILABLE.");

        // Call setBookStatus to change the book's status.
        book.setBookStatus();

        // Check if the status has changed to BORROWED.
        Book.BookStatus updatedStatus = book.getStatus();
        System.out.println("get status BORROWED completed");
        Assertions.assertEquals(Book.BookStatus.BORROWED, updatedStatus, "Status should be BORROWED after setBookStatus is called.");

        // Call setBookStatus again and check if it changes back to AVAILABLE.
        book.setBookStatus();
        updatedStatus = book.getStatus();
        System.out.println("get status AVAILABLE completed");
        Assertions.assertEquals(Book.BookStatus.AVAILABLE, updatedStatus, "Status should be AVAILABLE after second call to setBookStatus.");
    }

}
