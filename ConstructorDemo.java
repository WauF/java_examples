public class ConstructorDemo {
    public static void main(String[] args) {
        // Testing different constructor calls
        Book book1 = new Book();  // No-args constructor
        Book book2 = new Book("The Hobbit");  // One parameter
        Book book3 = new Book("1984", "George Orwell");  // Two parameters
        Book book4 = new Book("Harry Potter", "J.K. Rowling", 29.99);  // Three parameters

        // Display books information
        System.out.println("\nBook 1: " + book1);
        System.out.println("Book 2: " + book2);
        System.out.println("Book 3: " + book3);
        System.out.println("Book 4: " + book4);
    }
}

class Book {
    private String title;
    private String author;
    private double price;

    // Three parameter constructor - This is the main constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Creating book with all parameters");
    }

    // No-args constructor
    public Book() {
        this("Unknown", "Unknown", 0.0);  // Calls the three-parameter constructor
        System.out.println("Creating book with no parameters");
    }

    // One parameter constructor
    public Book(String title) {
        this(title, "Unknown", 0.0);  // Calls the three-parameter constructor
        System.out.println("Creating book with title only");
    }

    // Two parameter constructor
    public Book(String title, String author) {
        this(title, author, 0.0);  // Calls the three-parameter constructor
        System.out.println("Creating book with title and author");
    }


    // ToString method for easy printing
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Price: $%.2f", 
                           title, author, price);
    }
}
