import java.util.Scanner;

public class ATMSystem {
    private static final String USER_ID = "hiranmai";
    private static final String USER_PIN = "1234";
    private static double balance = 7000.0; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the ATM System!");
        System.out.print("Enter your user ID: ");
        String userIdInput = sc.nextLine();
        System.out.print("Enter your user PIN: ");
        String userPinInput = sc.nextLine();

        if (authenticateUser(userIdInput, userPinInput)) {
            System.out.println("Login successful!");
            showMenu();
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private static boolean authenticateUser(String userId, String userPin) {
        return userId.equals(USER_ID) && userPin.equals(USER_PIN);
    }

    private static void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void viewBalance() {
        System.out.println("Your current balance: $" + balance);
    }

    private static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: $");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter deposit amount: $");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void transfer() {
        System.out.println("Transfer feature coming soon!");
    }
}
