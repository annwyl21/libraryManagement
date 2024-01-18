import java.util.ArrayList;

public class Library {
    // Static variable to keep track of total number of books in the library.
    protected static int totalBooks = 0;

    // Static ArrayList to store the books. It's static, it belongs to the class, not instances of the class.
    protected ArrayList<Book> books = new ArrayList<Book>();

    // Method to add a new book to the library.
    public void addBook(Book newBook) {
        books.add(newBook); // Adds the new book to the ArrayList.
        totalBooks ++; // Increments the total book count.
    }

    // getter method to return total books in library
    public int getTotalBooks() {
        return totalBooks;
    }

    // Method to list all books in the library.
    public void listAllBooks() {
        for (int i=0; i<books.size(); i++) {
            int num = i+1; // To display the book number starting from 1 instead of 0.
            System.out.println(num + " " + books.get(i).toString()); // Prints each book's details.
        }
    }

    // Method to check the availability of a book by title and author.
    public String checkAvailability(String title, String author) {
        Boolean notFound = false; // Flag to track if the book is not found.
        for (Book book: books) {
            // Checks if current book matches the provided title OR author.
            if (book.title.equals(title) || book.author.equals(author)) {
                if (book.isAvailable()) {
                    System.out.println(book.title + " by " + book.author);
                    System.out.println("Currently AVAILABLE");
                    System.out.println(book.getStatusAsString());
                    return book.getStatusAsString();
                } else {
                    System.out.println(book.title + " by " + book.author);
                    System.out.println("Currently unavailable");
                    return book.getStatusAsString();
                }
            } else {
                notFound = true; // Sets the notFound flag if the book does not match.
            }
        }
        if (notFound) {
            // Prints a message if the book is not found in the library.
            System.out.println(title + " by " + author + " NOT FOUND");
        }
        return null; // Return null if book not found
    }

    // method to borrow book
    public void borrowBook(String title, String author) {
        Boolean bookFound = false; // flag to indicate when book is located

        for (Book book: books) {
            // Check if current book matches the provided title AND author
            if (book.title.equals(title) && book.author.equals(author)) {
                if (book.isAvailable()) {
                    // change book status from Available to Borrowed
                    book.setBookStatus();
                    System.out.println(book.toString());
                    bookFound = true; // set flag to found, to prevent default output
                }
                break; // Breaks the loop once book is found
            }
        }

        if (!bookFound) {
            // printed if no book is found
            System.out.println("Book NOT FOUND");
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

        // Prints the total number of books in the library instances (not including the digital library subclass).
        System.out.println("Library currently holds " + totalBooks + " books.");
        corringham.listAllBooks();

        // Checks and prints the availability of specific books.
        System.out.println("Check Availability");
        corringham.checkAvailability("The Lord of the Rings", "Tolkien");
        corringham.checkAvailability("Lord of the Dance", "Someone");

        System.out.println("Borrow Book");
        corringham.borrowBook("The Lord of the Rings", "J.R. Tolkien");
        corringham.borrowBook("Lord of the Dance", "Someone");
        corringham.listAllBooks();

        // Creating an instance of subclass DigitalLibrary named WestminsterOnline.
        DigitalLibrary WestminsterOnline = new DigitalLibrary();

        // Creating a new book instance.
        // This creates a book titled "The Secret Barrister" with the author "Secret Barrister".
        Book secretBarrister = new Book("The Secret Barrister", "Secret Barrister");

        // Adding the created book to the EllenHoughton digital library.
        // Since DigitalLibrary extends Library, it inherits the addBook method.
        WestminsterOnline.addBook(secretBarrister);

        // Listing all books in the EllenHoughton digital library.
        // The listAllBooks method is also inherited from the Library class.
        WestminsterOnline.listAllBooks();

        // Prints the total number of books in the digital libraries.
        System.out.println("Library currently holds " + totalBooks + " books.");
    }
}
