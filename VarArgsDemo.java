public class VarArgsDemo {
    public static void main(String[] args) {
        // Example 1: Basic varargs usage
        System.out.println("Sum of numbers: " + sum(1, 2, 3, 4, 5));
        System.out.println("Sum of numbers: " + sum(10, 20, 30));
        System.out.println("Sum of no numbers: " + sum());

        // Example 2: Mixing regular parameters with varargs
        printStudentInfo("John", 85, 90, 95, 88);
        printStudentInfo("Alice", 92, 88);

        // Example 3: Array vs varargs
        String[] fruits = {"Apple", "Banana", "Orange"};
        printItems(fruits);  // passing array
        printItems("Mango", "Grape", "Pear");  // passing individual items
    }

    // Basic varargs method
    // The '...' syntax indicates variable-length argument list
    public static int sum(int... numbers) {
        int total = 0;
        // numbers is treated as an array inside the method
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    // Mixing regular parameters with varargs
    // Note: varargs parameter must be the last parameter
    public static void printStudentInfo(String name, int... grades) {
        System.out.println("\nStudent: " + name);
        System.out.print("Grades: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    // Demonstrating varargs with objects
    public static void printItems(String... items) {
        System.out.println("\nItems:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}
