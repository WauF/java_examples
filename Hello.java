public class Hello {
    public static void main(String[] args) {
        // Example 1: Primitive type (pass by value)
        int number = 10;
        System.out.println("Before modifyPrimitive: " + number);
        modifyPrimitive(number);
        System.out.println("After modifyPrimitive: " + number);

        // Example 2: Object reference (pass by value of reference)
        Student student = new Student("John");
        System.out.println("\nBefore modifyObject: " + student.name);
        modifyObject(student);
        System.out.println("After modifyObject: " + student.name);
    }

    // Example 1: Primitive type parameter
    public static void modifyPrimitive(int x) {
        x = x + 5;  // This change won't haffect the original variable
        System.out.println("Inside modifyPrimitive: " + x);
    }

    // Example 2: Object reference parameter
    public static void modifyObject(Student s) {
        s.name = "Jane";  // This change will affect the original object
        System.out.println("Inside modifyObject: " + s.name);
    }
}

// Simple Student class for demonstration
class Student {
    String name;
    
    Student(String name) {
        this.name = name;
    }
}
