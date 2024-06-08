
package com.ATM.Interface;
import java.util.Scanner;
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        double amount;

        switch (option) {
            case 1:
                System.out.println("Balance: $" + account.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                amount = scanner.nextDouble();
                account.deposit(amount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                amount = scanner.nextDouble();
                account.withdraw(amount);
                break;
            case 4:
                System.out.println("Thank you for using our ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            atm.processOption(option);
        }
    }
}
