package com.librarymanagement;

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

}
