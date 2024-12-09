/*
  File Name:Transaction.java
  Description: Defines a class for executing deposit or withdrawal transactions on a
               bank account. The class supports multithreading by implementing the
               Runnable interface.
  Student's Name: Orlando Velasco Rios
  Student ID: 301368612
  Date: December 7, 2024
*/

package Exercise1;


// Class representing a banking transaction
public class Transaction implements Runnable{
    private final Account account;  // Reference to the account being accessed
    private final boolean isDeposit; // true for deposit, false for withdraw
    private final double amount; // Amount to be deposited or withdrawn


    // Constructor to initialize the transaction details
    public Transaction(Account account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    // The run method to execute the transaction (called when the thread starts)
    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount); // Perform a deposit
        } else {
            account.withdraw(amount); // Perform a withdrawal
        }
    }
}
