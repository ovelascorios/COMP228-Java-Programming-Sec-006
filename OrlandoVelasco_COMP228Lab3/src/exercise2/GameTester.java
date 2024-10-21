package exercise2;

// Import necessary packages for user interaction
import javax.swing.JOptionPane;

// Abstract class representing a game tester
abstract class GameTester {
    protected String gameTesterName; // Name of the game tester
    protected boolean fullTimeStatus; // Status indicating if the tester is full-time or part-time

    // Constructor to initialize the game tester's name and status
    public GameTester(String gameTesterName, boolean fullTimeStatus) {
        this.gameTesterName= gameTesterName;
        this.fullTimeStatus = fullTimeStatus;
    }

    // Abstract method to determine salary, to be implemented by subclasses
    public abstract double determineSalary();

}

// Full-time game tester class, extending the GameTester class
class FullTimeGameTester extends GameTester {

    // Constructor to initialize the full-time game tester's name
    public FullTimeGameTester(String gameTesterName) {
        super(gameTesterName, true);
    } // Call the superclass constructor with full-time status

    // Implement the determineSalary method for full-time testers
    @Override
    public double determineSalary() {
        return 3000;
    }  // Fixed salary for full-time testers


    // Method to display information about the full-time game tester
    public void displayInfo() {
        // Create a message for display with the tester's information
        String message = "Game Tester Name: " + gameTesterName +
                "\nStatus: Full-Time" +
                "\nSalary fixed: $" + String.format("%,.0f", determineSalary());  // Display fixed salary

        // Show the information in a dialog box
        JOptionPane.showMessageDialog(null, message);
    }
}

// Part-time game tester class, extending the GameTester class
class PartTimeGameTester extends GameTester {
    private int hoursWorked; // Variable to store hours worked by the part-time tester

    // Constructor to initialize the part-time game tester's name and hours worked
    public PartTimeGameTester(String gameTesterName, int hoursWorked) {
        super(gameTesterName, false);// Call the superclass constructor with part-time status
        this.hoursWorked = hoursWorked; // Set the hours worked
    }

    // Implement the determineSalary method for part-time testers
    @Override
    public double determineSalary() {
        return hoursWorked * 20;
    } // Calculate salary based on hourly rate of $20

    // Method to display information about the part-time game tester

    public void displayInfo() {
        // Create a message for display with the tester's information
        String message = "Game Tester Name: " + gameTesterName +
                "\nStatus: Part-Time" +
                "\nHourly Rate: $20 per hour" +
                "\nHours Worked: " + hoursWorked + // Display hours worked
                "\nSalary: $" + String.format("%,.0f", determineSalary()); // Display calculated salary

        // Show the information in a dialog box
        JOptionPane.showMessageDialog(null, message);
    }
}

