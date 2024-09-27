package exercise2;

// Import necessary packages for user interaction
import javax.swing.JOptionPane;
import java.util.Random;

// Lotto class definition
public class Lotto {
    private int[] numbers = new int[3]; // Array to hold random numbers

    // Constructor to generate random numbers
    public Lotto() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(9) + 1; // Random number between 1 and 9
        }
    }

    // Method to get the sum of the numbers
    public int getSum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to return the numbers array
    public int[] getNumbers() {
        return numbers;
    }

    // Method to handle the lotto game logic
    private void playLotto(int userChoice) {
        // User has 5 attempts to win
        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto(); // Generate random lotto numbers
            int sum = lotto.getSum(); // Calculate the sum
            int[] generatedNumbers = lotto.getNumbers(); // Get the generated numbers

            // Create a string to display the generated numbers
            String numbersDisplay = "";
            for (int j = 0; j < generatedNumbers.length; j++) {
                numbersDisplay += generatedNumbers[j]; // Append each number
                if (j < generatedNumbers.length - 1) {
                    numbersDisplay += ", "; // Add a comma for all except the last number
                }
            }

            // Check if user wins
            if (userChoice == sum) {
                JOptionPane.showMessageDialog(null, "Congratulations! You won! \nNumbers generated: " + numbersDisplay + "\nThe Lotto sum is: " + sum);
                return; // Exit the method if the user wins
            } else {
                JOptionPane.showMessageDialog(null, "You lost! \nAttempt " + (i + 1) + " out of 5: \nNumbers generated: " + numbersDisplay + ". \nThe Lotto sum is: " + sum + ".");
            }
        }

        // If user doesn't win after 5 attempts
        JOptionPane.showMessageDialog(null, "Computer won! T_T \nBetter luck next time.");
    }

    // Main method to start the lotto game
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Lotto's game.");
        JOptionPane.showMessageDialog(null, "Instructions:\nThree random numbers will be generated from 1 to 9, and your mission is to determine the total sum. The game starts when you guess the result (between 3 and 27). \nThe lotto will run for a total of 5 attempts, and you win if, in any of the attempts, the total sum equals your choice. \nGood luck, and let’s play!");
        int userChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number between 3 and 27:"));
        Lotto lottoGame = new Lotto(); // Create a Lotto object
        lottoGame.playLotto(userChoice); // Start the game
    }
}
