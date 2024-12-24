import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // Creating a Scanner object to read from System.in (keyboard input)
        Scanner scanner = new Scanner(System.in);

        try {
            // Example 1: Reading different data types
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();  // Reads entire line

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();       // Reads an integer

            System.out.print("Enter your height in meters: ");
            double height = scanner.nextDouble(); // Reads a double

            System.out.println("\nYour information:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Height: " + height + "m");

            // Example 2: Reading tokens (words)
            scanner.nextLine(); // Consume leftover newline
            System.out.print("\nEnter three favorite colors (space-separated): ");
            String color1 = scanner.next();    // Reads first word
            String color2 = scanner.next();    // Reads second word
            String color3 = scanner.next();    // Reads third word

            System.out.println("Your favorite colors are: " + 
                             color1 + ", " + color2 + ", " + color3);

            // Example 3: Checking input availability
            scanner.nextLine(); // Consume leftover newline
            System.out.print("\nWrite a sentence: ");
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equals("end")) break;
                System.out.println("Word: " + word);
            }

        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        } finally {
            // Always close the Scanner to prevent resource leaks
            scanner.close();
        }
    }
}
