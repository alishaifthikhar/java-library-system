# Java Library System

## 📌 Overview
This Java-based Library Management System enables users to:
- Add books with title, author, and quantity.
- Borrow books if available.
- Return books to the library.
- Interact with a menu-driven console interface.

## 🛠 Features
- **Book Management**: Add, borrow, and return books.
- **Input Validation**: Ensures only valid numeric inputs are accepted.
- **Data Storage**: Uses `HashMap<String, Book>` for efficient book retrieval.
- **Menu-Driven Interface**: Simple and interactive user experience.

## 📜 Program Structure
### 1️⃣ **LibrarySystem Class**
- `HashMap<String, Book> books`: Stores books with title as the key.
- `addBook(String title, String author, int quantity)`: Adds a book or updates an existing one.
- `borrowBook(String title, int quantity)`: Allows borrowing if copies are available.
- `returnBook(String title, int quantity)`: Increases book stock when returned.
- `displayMenu()`: Displays available options.

### 2️⃣ **Book Class**
- Attributes: `title`, `author`, and `quantity`.
- Methods:
  - `addQuantity(int quantity)`: Increases book stock.
  - `borrowQuantity(int quantity)`: Reduces stock if available.
  - `returnQuantity(int quantity)`: Adds returned books.
  - `getQuantity()`: Retrieves the available stock.

### 3️⃣ **Main Method**
- Controls user interactions.
- Implements a loop for menu operations.
- Ensures proper input validation using `Scanner`.

## 💻 How to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/alishaifthikhar/java-library-system.git
