import java.util.Scanner;

public class SimpleBankingApp {
    // Variables to store the account balance
    static double balance = 0.0;

    // Method to deposit money
    public static void deposit(double amount) {
        balance += amount;
        System.out.println("Your Deposited Amount is: " + amount);
    }

    // Method to withdraw money
    public static void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Your Withdrawn Amount is: " + amount);
        } else {
            System.out.println("Insufficient bank balance.");
        }
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n**********************Banking Application**********************");
            System.out.println("1. Deposit Amount:");
            System.out.println("2. Withdraw Amount:");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using banking app. Visit Again");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4); // Keep running the program until the user chooses to exit

        scanner.close(); // Close the scanner
    }
}
