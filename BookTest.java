import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BookTest {

    // Declaring a Book instance to be used in the tests
    private Book book;

    // Fixture
    @BeforeEach
    public void setUp() {
        // Initialize a Book object before each test
        book = new Book("1984", "George Orwell");
    }

    @Test
    public void testSetBookStatus() {
        // Initial status of the book should be available
        Book.BookStatus initialStatus = book.getStatus();
        Assertions.assertEquals(Book.BookStatus.AVAILABLE, initialStatus, "Initial status should be AVAILABLE.");

        // Call setBookStatus to change the book's status.
        book.setBookStatus();

        // Check if the status has changed to BORROWED.
        Book.BookStatus updatedStatus = book.getStatus();
        Assertions.assertEquals(Book.BookStatus.BORROWED, updatedStatus, "Status should be BORROWED after setBookStatus is called.");

        // Call setBookStatus again and check if it changes back to AVAILABLE.
        book.setBookStatus();
        updatedStatus = book.getStatus();
        Assertions.assertEquals(Book.BookStatus.AVAILABLE, updatedStatus, "Status should be AVAILABLE after second call to setBookStatus.");
    }

}