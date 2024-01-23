package com.librarymanagement;

import java.util.ArrayList;

public class Main {
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
        System.out.println("Library currently holds " + Library.totalBooks + " books.");
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
        System.out.println("Library currently holds " + Library.totalBooks + " books.");
    }
}
