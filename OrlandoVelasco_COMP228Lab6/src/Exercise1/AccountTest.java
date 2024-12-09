/*
  File Name: AccountTest.java
  Description: Simulates concurrent banking transactions on an account
               using multithreading.
  Student's Name: Orlando Velasco Rios
  Student ID: 301368612
  Date: December 7, 2024
*/


package Exercise1;

import java.util.ArrayList; // For creating a list of transactions
import java.util.concurrent.ExecutorService; // For managing a thread pool
import java.util.concurrent.Executors; // To create thread pool executors

public class AccountTest {
    public static void main(String[] args) {

        // Create an account with initial balance of 1000.
        Account account = new Account(1000);

        // Print the initial account balance after all transactions
        System.out.printf("%nInitial account balance: %.2f%n%n", account.getBalance());


        // Create a list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, true, 500)); // Deposit 500
        transactions.add(new Transaction(account, false, 2200)); // Withdraw 2200
        transactions.add(new Transaction(account, false, 1200)); // Withdraw 1200
        transactions.add(new Transaction(account, true, 800)); // Deposit 800
        transactions.add(new Transaction(account, true, 400)); // Deposit 400
        transactions.add(new Transaction(account, false, 800)); // Withdraw 800

        // Create ExecutorService instance with a thread pool of 3 threads.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Execute each transaction in a separate thread
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        // Shutdown the executor
        executor.shutdown();

        // Ensure all tasks have finished
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }

        // Print the final account balance after all transactions
        System.out.printf("%nFinal account balance: %.2f%n", account.getBalance());
    }
}
