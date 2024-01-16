### Coding Challenge: Library Book Management System

#### Objective:
Create a simple Library Book Management System in Java. The system will manage books in a library, allowing you to add new books, check if a book is available, and list all books.

#### Requirements:

1. **Book Class**:
    - Create a `Book` class with the following properties:
        - `String title` (protected)
        - `String author` (protected)
        - `BookStatus status` (protected) - Use an enum for `BookStatus` (e.g., AVAILABLE, BORROWED).
    - Include a constructor method to initialize these properties.
    - Implement a method `isAvailable()` that returns `true` if the book status is `AVAILABLE`.
    - Override the `.equals()` method to compare books based on `title` and `author`.

2. **Library Class**:
    - Create a `Library` class with an `ArrayList<Book>` to store books.
    - Include methods to:
        - `addBook(Book book)`: Adds a new book to the library.
        - `checkAvailability(String title, String author)`: Checks if a book is available by using `.equals()` method.
        - `listAllBooks()`: Lists all books in the library.

3. **Enum for BookStatus**:
    - Define an enum named `BookStatus` with values `AVAILABLE` and `BORROWED`.

4. **Main Class**:
    - In your `main` method, create an instance of `Library`.
    - Use a loop to add a few books to the library (use array or `ArrayList` to store book details before adding them to the library).
    - Demonstrate the use of `try` and `catch` by implementing error handling while adding books (e.g., handling null values).
    - Use `static` and `final` keywords appropriately in your code.
    - Use `this` keyword in the constructor of the `Book` class.

#### Additional Instructions:

- Comment your code

extensively to explain your logic.
- Make sure to handle any exceptions gracefully and provide meaningful messages in the catch blocks.
- Test your code thoroughly to ensure it meets all the requirements.
- As you're new to enums, here's a brief explanation:
  Enums in Java are a special data type that enables for a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it.

#### Sample Enum Usage:
```java
public enum BookStatus {
    AVAILABLE,
    BORROWED
}
```

#### Example Challenge:
- Create a simple interface to interact with your library system through the console. Allow users to add books, check availability, and list all books.

This challenge will help you get hands-on experience with various important concepts in Java, including object-oriented programming, exception handling, and working with collections. Enums will give you insight into a powerful way to handle predefined constants, which is very useful in many programming scenarios.
