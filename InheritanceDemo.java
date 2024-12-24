// Base class (superclass)
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("Vehicle starting...");
    }

    public void stop() {
        System.out.println("Vehicle stopping...");
    }

    public String getInfo() {
        return year + " " + brand + " " + model;
    }
}

// First level inheritance (subclass of Vehicle)
class Car extends Vehicle {
    private int numDoors;
    
    public Car(String brand, String model, int year, int numDoors) {
        super(brand, model, year);  // Call parent constructor
        this.numDoors = numDoors;
    }

    // Method overriding
    @Override
    public void start() {
        super.start();  // Call parent method
        System.out.println("Car engine purring...");
    }

    // Additional method specific to Car
    public void honk() {
        System.out.println("Beep beep!");
    }
}

// Another subclass of Vehicle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Motorcycle engine roaring...");
    }

    // Additional method specific to Motorcycle
    public void wheelie() {
        System.out.println("Doing a wheelie!");
    }
}

// Main class to demonstrate inheritance
public class InheritanceDemo {
    public static void main(String[] args) {
        // Creating objects of different classes
        Car car = new Car("Toyota", "Camry", 2022, 4);
        Motorcycle motorcycle = new Motorcycle("Harley", "Sportster", 2021, false);

        // Demonstrating inheritance and polymorphism
        System.out.println("--- Car Details ---");
        System.out.println(car.getInfo());  // Inherited method
        car.start();  // Overridden method
        car.honk();   // Car-specific method

        System.out.println("\n--- Motorcycle Details ---");
        System.out.println(motorcycle.getInfo());  // Inherited method
        motorcycle.start();  // Overridden method
        motorcycle.wheelie();  // Motorcycle-specific method

        // Demonstrating polymorphism
        System.out.println("\n--- Polymorphism Demo ---");
        Vehicle[] vehicles = {car, motorcycle};
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getInfo());
            vehicle.start();
            // Note: can't call honk() or wheelie() here without casting
        }
    }
}
