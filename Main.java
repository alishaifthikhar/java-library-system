import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            library.displayMenu();
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                    }
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addBook(title, author, quantity);
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter quantity to borrow: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                    }
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.borrowBook(title, quantity);
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter quantity to return: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                    }
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.returnBook(title, quantity);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

class LibrarySystem {
    private HashMap<String, Book> books;

    public LibrarySystem() {
        books = new HashMap<>();
    }

    public void addBook(String title, String author, int quantity) {
        if (books.containsKey(title)) {
            books.get(title).addQuantity(quantity);
        } else {
            books.put(title, new Book(title, author, quantity));
        }
        System.out.println("Book added/updated successfully.");
    }

    public void borrowBook(String title, int quantity) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            if (book.getQuantity() >= quantity) {
                book.borrowQuantity(quantity);
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Error: Not enough copies available.");
            }
        } else {
            System.out.println("Error: Book not found.");
        }
    }

    public void returnBook(String title, int quantity) {
        if (books.containsKey(title)) {
            books.get(title).returnQuantity(quantity);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Error: Book not found.");
        }
    }

    public void displayMenu() {
        System.out.println("Library System Menu:");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
    }
}

class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void borrowQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        }
    }

    public void returnQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
