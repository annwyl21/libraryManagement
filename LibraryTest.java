import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);
        // Assuming getTotalBooks() is a method that returns the number of books in the library
        Assertions.assertEquals(1, library.getTotalBooks());
    }
}


