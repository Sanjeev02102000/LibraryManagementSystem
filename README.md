# Library Management System

## Overview

The **Library Management System** is a Java-based application that allows users to manage books, library branches, reservations, and recommendations. It follows SOLID principles and good software design practices, making it modular and extendable.

## Features

### Core Features

- **Book Management**: Add, remove, and update books in the library.
- **Patron Management**: Add, remove and update patrons in the library
- **Lending Management**: borrow, return books from the library

## Design Patterns Used

- **Builder Pattern**: Used to construct `Book` objects using a flexible and readable API.
- **Strategy Pattern**: Used for applying strategy when searching books by title, author or ISBN

## Getting Started

### Prerequisites

- Java 17+
- Maven (optional, for dependency management)

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Sanjeev02102000/LibraryManagementSystem.git
   cd library-management-system
   ```
2. Compile and run the application:
   ```sh
   javac -d bin src/main/java/com/lms/*.java
   java -cp bin com.lms.LibraryManagementSystem
   ```

## Code Structure

```
LibraryManagementSystem/
│── src/
│   ├── com/lms/
│   │   ├── Book/
│   │   │   ├── Book.java
│   │   │   ├── BookBuilder.java
│   │   │   ├── BookManagement.java
│   │   │   ├── SearchBooksByAuthorStrategy.java
│   │   │   ├── SearchBooksByTitleStrategy.java
│   │   │   ├── SearchBooksByISBNStrategy.java
│   │   │   ├── SearchBookStrategy.java
│   │   ├── Lending/
│   │   │   ├── LendingMgmt.java
│   │   ├── LibraryManagement/
│   │   │   ├── LibraryManagement.java
│   │   ├── PatronManagement/
│   │   │   ├── Patron.java
│   │   │   ├── PatronManagement.java
│   │   ├── LibraryManagementSystem.java
│── README.md
```

## Usage

### Creating a Book Using `BookBuilder`

```java
Book book = new BookBuilder()
        .setId(UUID.randomUUID().toString())
        .setTitle("Shoe Dog")
        .setAuthor("Phil Knight")
        .setIsbn("JSAC2007")
        .setGenre("Autobiography")
        .setPublicationYear(2007)
        .build();
```

### Borrowing Book By a patron

```java
libraryManagement.borrowBook(patronId, bookId);
```

### Returning a book

```java
libraryManagement.returnBook(patronId, bookId);
```

## Future Improvements

- Implement REST API for remote access.
- Add a frontend interface.
- Integrate a database for persistence.
-
### Transferring Books Between Branches

```java
libraryService.transferBook(bookId, fromBranch, toBranch);
```

### Reserving a Book

```java
reservationService.reserveBook(userId, bookId);
```

### Receiving Book Recommendations

```java
List<Book> recommendations = recommendationService.getRecommendations(userId);
```

## License

This project is licensed under the MIT License.

---

For any queries, feel free to reach out! 🚀

