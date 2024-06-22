import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdrawal();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void handleWithdrawal() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    private void handleCheckBalance() {
        bankAccount.checkBalance();
    }
}

// Main class to run the ATM application
public class ATMApplication {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(500.00); // Initial balance of $500
        ATM atm = new ATM(bankAccount);
        atm.showMenu();
    }
}

