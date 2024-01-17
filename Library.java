import java.util.ArrayList;

public class Library {
    // Static variable to keep track of total number of books in the library.
    protected static int totalBooks = 0;

    // Static ArrayList to store the books. It's static so it belongs to the class, not instances of the class.
    protected static ArrayList<Book> books = new ArrayList<Book>();

    // Method to add a new book to the library.
    public void addBook(Book newBook) {
        books.add(newBook); // Adds the new book to the ArrayList.
        totalBooks ++; // Increments the total book count.
    }

    // Method to list all books in the library.
    public void listAllBooks() {
        for (int i=0; i<books.size(); i++) {
            int num = i+1; // To display the book number starting from 1 instead of 0.
            System.out.println(num + " " + books.get(i).toString()); // Prints each book's details.
        }
    }

    // Method to check the availability of a book by title and author.
    public Boolean checkAvailability(String title, String author) {
        Boolean availability = false; // Flag to track if the book is available.
        Boolean notFound = false; // Flag to track if the book is not found.
        for (Book book: books) {
            // Checks if current book matches the provided title OR author.
            if (book.title.equals(title) || book.author.equals(author)) {
                if (book.isAvailable()) {
                    System.out.println(book.title + " by " + book.author);
                    System.out.println("Currently AVAILABLE");
                } else {
                    System.out.println(book.title + " by " + book.author);
                    System.out.println("Currently unavailable");
                }
                break; // Breaks the loop once the book is found.
            } else {
                notFound = true; // Sets the notFound flag if the book does not match.
            }
        }
        if (notFound) {
            // Prints a message if the book is not found in the library.
            System.out.println(title + " by " + author + " NOT FOUND");
        }
        return availability; // Returns the availability status.
    }

    // method to borrow book
    public void borrowBook(String title, String author) {
        for (Book book: books) {
            // Check if current book matches the provided title AND author
            if (book.title.equals(title) && book.author.equals(author)) {
                if (book.isAvailable()) {
                    // change book status from Available to Borrowed
                    book.changeBookStatus();
                    System.out.println(book.toString());
                }
                break; // Breaks the loop once book is found
            }
        }
    }

    // Main method - entry point of the program.
    public static void main(String[] args) {
        // if the methods above were static they could be called directly on the Library class, Library.addBook()
        // Creating an instance of Library named Corringham.
        Library corringham = new Library();

        // creating books instances
        Book tolkien = new Book("The Lord of the Rings", "J.R. Tolkien");
        Book tolkien2 = new Book("Beowulf: A Translation & Commentary", "J.R. Tolkien");
        // System.out.println(tolkien.toString());

        // creating an arraylist to hold books to be added
        ArrayList<Book> booksToAdd = new ArrayList<>();
        booksToAdd.add(tolkien);
        booksToAdd.add(tolkien2);

        // Adding each book in the ArrayList to the library.
        for (Book book: booksToAdd) {
            try {
                // Tries to add a book to the library.
                corringham.addBook(book);
            } catch (NullPointerException e) {
                // Catches any NullPointerException that might occur (e.g., if book is null).
                System.out.println("Can not add a null book");
            }
        }
//        corringham.addBook(tolkien);
//        corringham.addBook(tolkien2);

        // Prints the total number of books in the library.
        System.out.println("Library currently holds " + totalBooks + " books.");
        corringham.listAllBooks();

        // Checks and prints the availability of specific books.
        System.out.println("Check Availability");
        corringham.checkAvailability("The Lord of the Rings", "Tolkien");
        corringham.checkAvailability("Lord of the Dance", "Someone");

        System.out.println("Borrow Book");
        corringham.borrowBook("The Lord of the Rings", "J.R. Tolkien");
        corringham.listAllBooks();
    }
}
