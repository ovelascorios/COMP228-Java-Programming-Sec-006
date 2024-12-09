/*
  File Name: Account.java
  Description: This class models a bank account with thread-safe methods for deposit,
               withdrawal, and balance retrieval. It ensures proper synchronization for
                safe concurrent access in a multithreaded environment.
  Student's Name: Orlando Velasco Rios
  Student ID: 301368612
  Date: December 7, 2024
*/

package Exercise1;

public class Account {

    // Private field to store the balance of the account
    private double balance =0;

    // Constructor to initialize the account with a starting balance
    public Account(double initialBalance) {
        // Check if the initial balance is positive before setting it
        if (initialBalance > 0.0) {
            balance = initialBalance;
        }
    }

    //  Synchronized method to deposit a specified amount into the account.
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            System.out.printf("Depositing %.2f to the account.%n", amount);
            balance += amount;
            System.out.printf("New balance after deposit: %.2f%n", balance);
        }
    }

    // Synchronized method to withdraw a specified amount from the account
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            System.out.printf("Withdrawing %.2f from the account.%n", amount);
            balance -= amount;
            System.out.printf("New balance after withdrawal: %.2f%n", balance);
        } else {
            System.out.printf("Insufficient funds for withdrawal of %.2f.%n", amount);
        }
    }

    // Synchronized method to retrieve the current balance of the account.
    public synchronized double getBalance() {
        return balance;
    }
}
