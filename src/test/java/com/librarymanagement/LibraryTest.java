package com.librarymanagement;

// Import statements for JUnit Jupiter (JUnit 5) functionalities
import org.junit.jupiter.api.BeforeEach;
// required for the @BeforeEach annotation, which is used to specify a method that should be executed before each test method, setting up any common test data or configurations.
import org.junit.jupiter.api.Test;
// necessary for the @Test annotation, which marks a method as a test method that should be executed when running the test suite.
import org.junit.jupiter.api.Assertions;
// allows access to the Assertions class, which provides static assertion methods used for writing test conditions that must be met for the test to succeed.


public class LibraryTest {

    // Declaring a Library instance to be used in the tests
    public Library library;

    // The @BeforeEach annotation indicates that the annotated method should be executed before each @Test method.
    // A test fixture, as it sets up the necessary preconditions before each test.
    @BeforeEach
    public void setUp() {
        System.out.println("Attempting to initialise Library object.");
        library = new Library();
        System.out.println("LibraryTest setUp: Library object created.");
    }

    // The @Test annotation indicates that this is a test method.
    // test addBook(), check if the total number of books in the library is as expected after the addBook operation
    @Test
    public void testAddBook() {
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);
        // Using Assertions.assertEquals
        // The first parameter is the expected value, and the second is the actual value.
        // If the assertion fails, it means there's an error in the addBook method or related components of the Library class.
        Assertions.assertEquals(1, library.getTotalBooks());
    }

    // test checkAvailability(), check is book availability is accurately reported
    @Test
    public void checkAvailability() {
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);
        String available = library.checkAvailability("1984", "George Orwell");
        Assertions.assertEquals("AVAILABLE", available);
    }
}


