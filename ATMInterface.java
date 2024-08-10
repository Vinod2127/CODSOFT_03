import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed: Insufficient funds or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit failed: Amount must be positive.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive amount to withdraw.");
        } else if (account.getBalance() >= amount) {
            account.withdraw(amount);
            System.out.println("Please collect your money.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive amount to deposit.");
        } else {
            account.deposit(amount);
            System.out.println("Your money has been successfully deposited.");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAutomated Teller Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.next(); // Clear invalid input
                System.out.print("Choose the operation you want to perform: ");
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                        System.out.print("Enter amount to withdraw: ");
                    }
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                        System.out.print("Enter amount to deposit: ");
                    }
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
