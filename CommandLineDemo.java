public class CommandLineDemo {
    public static void main(String[] args) {
        // Check if any arguments were provided
        if (args.length == 0) {
            System.out.println("No arguments provided!");
            System.out.println("Usage examples:");
            System.out.println("1. java CommandLineDemo John 25");
            System.out.println("2. java CommandLineDemo sum 5 10 15");
            System.out.println("3. java CommandLineDemo concat Hello World");
            return;
        }

        // Example 1: Basic argument reading
        System.out.println("Number of arguments: " + args.length);
        System.out.println("Arguments provided:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }

        // Example 2: Command-based argument processing
        if (args[0].equals("sum") && args.length > 1) {
            int sum = 0;
            for (int i = 1; i< args.length; i++)  {
                try {
                    sum += Integer.parseInt(args[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + args[i] + " is not a number");
                    return;
                }
            }
            System.out.println("Sum of numbers: " + sum);
        }

        // Example 3: String manipulation with args
        if (args[0].equals("concat") && args.length > 1) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                result.append(args[i]).append(" ");
            }
            System.out.println("Concatenated string: " + result.toString().trim());
        }
    }


}
