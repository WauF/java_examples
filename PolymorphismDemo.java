// Shape hierarchy demonstrating polymorphism
class Shape {
    public double getArea() {
        return 0.0;
    }

    // Method overloading example (static polymorphism)
    public void draw() {
        System.out.println("Drawing a shape");
    }

    public void draw(String color) {
        System.out.println("Drawing a " + color + " shape");
    }

    public void draw(String color, boolean filled) {
        System.out.println("Drawing a " + color + " shape" + (filled ? " filled" : " not filled"));
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Method overriding example (dynamic polymorphism)
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Main class demonstrating polymorphism
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Compile-time (static) polymorphism through method overloading
        System.out.println("--- Method Overloading Example ---");
        Shape shape = new Shape();
        shape.draw();                    // Calls no-args version
        shape.draw("red");              // Calls color version
        shape.draw("blue", true);      // Calls color and filled version

        // Runtime (dynamic) polymorphism through method overriding
        System.out.println("\n--- Method Overriding Example ---");
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Shape();

        // Polymorphic method calls
        for (Shape s : shapes) {
            System.out.println("Area: " + s.getArea());
            s.draw();  // Calls appropriate version based on actual object type
        }

        // Demonstrating instanceof operator
        System.out.println("\n--- Type Checking Example ---");
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                System.out.println("This is a Circle");
            } else if (s instanceof Rectangle) {
                System.out.println("This is a Rectangle");
            } else {
                System.out.println("This is a generic Shape");
            }
        }
    }

    // Demonstrating polymorphism in method parameters
    public static void printShapeInfo(Shape shape) {
        System.out.println("Area: " + shape.getArea());
        shape.draw();
    }
}
