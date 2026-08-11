# Library Book Management System

A console-based **Library Book Management System** built in Java to practice **Object-Oriented Programming (OOP), Collections, object relationships, and basic business logic**.

This project was developed as part of my Java Backend learning roadmap.

## Features

### 1. Add Book

* Add a new book to the library.
* Store:

  * Book ID
  * Title
  * Author
  * Availability status
* Prevent duplicate Book IDs.

### 2. View All Books

* Display all books in the library.
* Show:

  * Book ID
  * Title
  * Author
  * Availability status
* Display an appropriate message when no books are available.

### 3. Search Book

Books can be searched using:

* Book ID
* Title
* Author

Title and author searches support partial matching.

### 4. Register Member

* Register new library members.
* Store:

  * Member ID
  * Member name
  * Borrowed books
* Prevent duplicate Member IDs.

### 5. View Members

* Display all registered members.
* Show Member ID and Member Name.
* Handle the case where no members are registered.

### 6. Borrow Book

* A registered member can borrow an available book.
* A borrowed book is marked as `Borrowed`.
* The book is added to the member's borrowed-book list.
* Prevent borrowing a book that is already borrowed.
* Validate both Member ID and Book ID.

### 7. Return Book

* A member can return a book they have borrowed.
* The book's availability is changed back to `Available`.
* The book is removed from the member's borrowed-book list.
* Prevent returning a book that the member has not borrowed.

### 8. View Borrowed Books

* View all books borrowed by a particular member.
* Display:

  * Book ID
  * Title
  * Author
* Display an appropriate message when the member has no borrowed books.

### 9. Exit

* Exit the application through the main menu.

---

## OOP Concepts Practiced

This project focuses on the following Java concepts:

* Classes and Objects
* Encapsulation
* Private fields
* Getters and Setters
* Object relationships
* Constructors
* `List`
* `ArrayList`
* `Set`
* `HashSet`
* Enhanced `for` loops
* Index-based iteration
* Basic state management
* Method-based organization

### Object Relationships

A `Library` manages:

```text
Library
 ├── Books
 └── Members
       └── Borrowed Books
```

A `Member` maintains a collection of `Book` objects representing the books currently borrowed by that member.

---

## Collections Used

### ArrayList

Used to maintain:

```text
collectionOfBooks
collectionOfMembers
borrowedBooks
```

### HashSet

Used to efficiently track unique:

```text
Book IDs
Member IDs
```

This allows the application to detect duplicate IDs before adding new records.

---

## Project Structure

The project contains the following main classes:

```text
Main
 └── Application entry point and menu

Library
 ├── Book management
 ├── Member management
 ├── Search functionality
 ├── Borrow functionality
 ├── Return functionality
 └── Borrowed-book viewing

Book
 ├── Book ID
 ├── Title
 ├── Author
 └── Availability status

Member
 ├── Member ID
 ├── Member name
 └── Borrowed books
```

---

## Example Menu

```text
===== LIBRARY MANAGEMENT SYSTEM =====

1. Add Book
2. View All Books
3. Search Book
4. Register Member
5. View Members
6. Borrow Book
7. Return Book
8. View Borrowed Books
9. Exit

Enter choice:
```

---

## Business Rules

The application follows these basic rules:

1. Book IDs must be unique.
2. Member IDs must be unique.
3. Only registered members can borrow books.
4. Only existing books can be borrowed.
5. A book can only be borrowed when its status is `Available`.
6. Borrowing changes the book status to `Borrowed`.
7. A borrowed book is associated with the member who borrowed it.
8. A member can only return a book they currently have borrowed.
9. Returning a book changes its status back to `Available`.
10. Returned books are removed from the member's borrowed-book list.

---

## Testing

The application was manually tested for:

* Adding multiple books
* Adding duplicate Book IDs
* Registering multiple members
* Registering duplicate Member IDs
* Borrowing available books
* Attempting to borrow unavailable books
* Borrowing multiple books
* Returning borrowed books
* Attempting to return a book that was not borrowed
* Invalid Member IDs
* Viewing borrowed books
* Viewing books when the collection is empty
* Viewing members when the collection is empty

All planned functional test cases passed successfully.

---

## Key Learning

The main goal of this project was to move beyond simple Java programs and start modeling a real-world system using objects.

The project helped practice relationships such as:

```text
Library → manages Books
Library → manages Members
Member → has Borrowed Books
```

It also provided practice with modifying collections safely, particularly when removing an element from a list while iterating through it.

---

## Limitations

This is intentionally a **console-based learning project**.

It does not currently include:

* Database persistence
* File storage
* Authentication
* Due dates
* Fines
* Book categories
* Book reservations
* Input validation for every possible invalid input
* Exception handling for invalid numeric input
* GUI or web interface

These features were intentionally excluded to keep the project within the planned learning scope and time limit.

---

## Technologies

* **Java**
* Java Collections Framework
* `ArrayList`
* `HashSet`
* `Scanner`

---

## Project Status

**Completed ✅**

Project completed as part of my Java Backend learning roadmap, with a focus on strengthening Java OOP fundamentals before progressing toward more advanced backend development with Spring Boot.

