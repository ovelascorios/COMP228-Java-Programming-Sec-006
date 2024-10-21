package exercise2;

// Import necessary packages for user interaction
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Prompt for the game tester's name
        String name = JOptionPane.showInputDialog("Enter the game tester's name:");
        if (name == null) {
            System.exit(0);
        }

// Declare a variable of type GameTester
        GameTester tester;

        String status; // Variable to store user input for full-time or part-time status

        while (true) { // Infinite loop to repeatedly ask for input until valid
            // Prompt for full-time or part-time status with yes/no input
            status = JOptionPane.showInputDialog("Is the tester full-time? (yes/no)");

            // Check if the user pressed Cancel (status will be null)
            if (status == null) {
                System.exit(0); // Exit the program
            }

            // Check if the input is "yes" or "no"
            if (status.equalsIgnoreCase("yes")) {
                // If yes, create a new FullTimeGameTester instance with the provided name
                tester = new FullTimeGameTester(name);
                // Display the information for the full-time game tester
                ((FullTimeGameTester) tester).displayInfo();
                break; // Exit the loop since the input was valid
            } else if (status.equalsIgnoreCase("no")) {
                // If not full-time, prompt for the number of hours worked
                String hoursWorked = JOptionPane.showInputDialog("Enter the number of hours worked:");
                if (hoursWorked == null) {
                    System.exit(0); // Exit if Cancel is pressed
                }
                int hours = Integer.parseInt(hoursWorked); // Convert the input string to an integer
                // Create a new PartTimeGameTester instance with the provided name and hours worked
                tester = new PartTimeGameTester(name, hours);
                // Display the information for the part-time game tester
                ((PartTimeGameTester) tester).displayInfo();
                break; // Exit the loop since the input was valid
            } else {
                // If the input is neither "yes" nor "no", show an error message
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'yes' or 'no'.");
            }
        }

    }
}

