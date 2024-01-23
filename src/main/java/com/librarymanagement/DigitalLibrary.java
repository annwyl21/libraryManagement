package com.librarymanagement;
import com.librarymanagement.Library;
import com.librarymanagement.Book;

// DigitalLibrary class extending the Library class.
// This means DigitalLibrary inherits all non-private properties and methods of Library.
public class DigitalLibrary extends Library {

    // Method to add a new book to the library.
    // Polymorphism, where the method from the superclass is overridden to make it specific to the subclass of the digital library
    @Override
    public void addBook(Book newBook) {
        books.add(newBook); // Adds the new book to the ArrayList.
        newBook.setBookType(); // Sets book type to online
        totalBooks ++; // Increments the total book count.
    }

}

