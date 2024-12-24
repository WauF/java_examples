class Resource {
    private String name;
    private static int count = 0;
    private int id;

    public Resource(String name) {
        this.name = name;
        this.id = ++count;
        System.out.println("Creating resource: " + name + " (ID: " + id + ")");
    }

    // finalize method (deprecated since Java 9)
    @Override
    protected void finalize() {
        System.out.println("Finalizing resource: " + name + " (ID: " + id + ")");
    }
}

public class GarbageCollectionDemo {
    public static void main(String[] args) {
        createTemporaryResources();
        // Example 1: Creating objects that will become eligible for GC
        System.out.println("Creating objects...");
        for(int i = 0; i < 3; i++) {
            new Resource("Temp" + i); // No reference maintained
        }

        // Example 2: Nullifying references
        Resource r1 = new Resource("Persistent");
        System.out.println("r1 is active");
        r1 = null; // Object becomes eligible for GC

        // Example 3: Object reference reassignment
        Resource r2 = new Resource("Original");
        r2 = new Resource("Replacement"); // First object becomes eligible for GC

        // Request garbage collection (no guarantee it will run)
        System.out.println("\nRequesting garbage collection...");
        System.gc();
        //Runtime.getRuntime().runFinalization();

        // Sleep to allow GC to work (just for demonstration)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Example method demonstrating scope-based garbage collection
    public static void createTemporaryResources() {
        Resource temp = new Resource("ScopedResource");
        // temp will become eligible for GC after method ends
    }
}
