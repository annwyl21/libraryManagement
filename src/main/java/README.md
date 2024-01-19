### Coding Challenge: Library Book Management System

#### Objectives:
- To learn and practice coding in Java
- To learn and practice writing unit tests in Jtest
- Create a simple Library Book Management System in Java. The system will manage books in a library, allowing you to add new books, check if a book is available, and list all books.

#### Features:

1. **Book Class**:
    - `Book` class with protected properties, and using ENUM's
    - A constructor method to initialize these properties.
    - A method `isAvailable()` that returns `true` if the book status is `AVAILABLE`.
    - Overriding the `.toString()` method to return books with `title` and `author`.

2. **Library Class**:
    - A `Library` class with an `ArrayList<Book>` to store books with methods.
    - A `DigitalLibrary` subclass with an example of polymorphism, by overriding the `addBook` method

3. **Main Class**:
    - Use of `try` and `catch` by implementing error handling while adding books (e.g., handling null values).

4. **Test Class**:
    - Using a fixture
    - Use unit tests

