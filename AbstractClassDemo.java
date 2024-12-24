// Abstract base class
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountHolder;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Abstract methods (must be implemented by subclasses)
    abstract double calculateInterest();
    abstract void performMonthlyMaintenance();

    // Concrete method (shared implementation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        }
    }

    // Concrete method with final (cannot be overridden)
    final public void displayAccountInfo() {
        System.out.println("\nAccount Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("Interest Rate: " + calculateInterest() * 100 + "%");
    }
}

// Concrete subclass
class SavingsAccount extends BankAccount {
    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(String accountNumber, String accountHolder, 
                         double initialBalance, double interestRate, 
                         double minimumBalance) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    @Override
    double calculateInterest() {
        return interestRate;
    }

    @Override
    void performMonthlyMaintenance() {
        if (balance < minimumBalance) {
            balance -= 10;  // Penalty fee
            System.out.println("Maintenance fee applied: Below minimum balance");
        }
    }
}

// Another concrete subclass
class CheckingAccount extends BankAccount {
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;

    public CheckingAccount(String accountNumber, String accountHolder, 
                          double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
        this.transactionCount = 0;
    }

    @Override
    double calculateInterest() {
        return 0.01;  // 1% interest rate
    }

    @Override
    void performMonthlyMaintenance() {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fee = (transactionCount - FREE_TRANSACTIONS) * 2.0;
            balance -= fee;
            System.out.println("Transaction fee applied: $" + fee);
        }
        transactionCount = 0;  // Reset for new month
    }
}

// Main class to demonstrate abstract classes
public class AbstractClassDemo {
    public static void main(String[] args) {
        // Cannot instantiate abstract class
         //BankAccount account = new BankAccount(); // This would cause err

        // Create concrete class instances
        SavingsAccount savings = new SavingsAccount("SAV001", "John Doe", 
                                                   1000.0, 0.025, 500.0);
        CheckingAccount checking = new CheckingAccount("CHK001", "Jane Smith", 
                                                     2000.0);

        // Demonstrate polymorphic behavior
        System.out.println("--- Testing Savings Account ---");
        savings.deposit(500.0);
        savings.performMonthlyMaintenance();
        savings.displayAccountInfo();

        System.out.println("\n--- Testing Checking Account ---");
        checking.deposit(200.0);
        checking.performMonthlyMaintenance();
        checking.displayAccountInfo();
    }
}
