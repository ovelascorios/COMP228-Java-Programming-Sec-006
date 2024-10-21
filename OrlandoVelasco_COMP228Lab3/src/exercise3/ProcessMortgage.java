package exercise3;

// Import necessary packages for user interaction
import javax.swing.JOptionPane;

// Main class for processing mortgages
public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] mortgages = new Mortgage[3]; // Create an array to hold up to 3 Mortgage objects

        // Loop to gather mortgage information for each entry
        for (int i = 0; i < mortgages.length; i++) {
            // Prompt user for the type of mortgage (Business or Personal)
            String type = JOptionPane.showInputDialog("Enter mortgage type (Business/Personal):");
            // Check if the user clicked Cancel
            if (type == null) {
                System.exit(0); // Exit the application
            }

            // Validate mortgage type before proceeding
            if (!type.toUpperCase().equals("BUSINESS") && !type.toUpperCase().equals("PERSONAL")) {
                JOptionPane.showMessageDialog(null, "Invalid mortgage type entered. Please enter either 'Business' or 'Personal'.");
                i--; // Decrement index to retry this entry
                continue; // Skip the rest of the loop and prompt again
            }

            // Prompt for the mortgage number
            String mortgageNumber = JOptionPane.showInputDialog("Enter mortgage number:");
            // Check if the user clicked Cancel
            if (mortgageNumber == null) {
                System.exit(0); // Exit the application
            }

            // Prompt for the customer name
            String customerName = JOptionPane.showInputDialog("Enter customer name:");
            // Check if the user clicked Cancel
            if (customerName == null) {
                System.exit(0); // Exit the application
            }

            // Initialize mortgage amount and prompt until a valid input is provided
            double mortgageAmount = 0;
            while (true) {
                String mortgageAmountInput = JOptionPane.showInputDialog("Enter mortgage amount (Max 300,000):");
                // Check if the user clicked Cancel
                if (mortgageAmountInput == null) {
                    System.exit(0); // Exit the application
                }

                mortgageAmount = Double.parseDouble(mortgageAmountInput);

                // Validate mortgage amount
                if (mortgageAmount > 0) {
                    break; // Valid amount, exit loop
                } else {
                    // Show error message for invalid amount
                    JOptionPane.showMessageDialog(null, "Please enter a valid mortgage amount greater than 0.");
                }
            }

            // Initialize prime rate and prompt until a valid input is provided
            double primeRate = 0;
            while (true) {
                String primeRateInput = JOptionPane.showInputDialog("Enter the current prime interest rate (%):");
                // Check for Cancel
                if (primeRateInput == null) {
                    System.exit(0); // Exit the application
                }

                primeRate = Double.parseDouble(primeRateInput);

                // Validate prime rate
                if (primeRate > 0 && primeRate <= 100) {
                    break; // Valid prime rate, exit loop
                } else {
                    // Show error message for invalid rate
                    JOptionPane.showMessageDialog(null, "Please enter a valid prime interest rate greater than 0 % and less than or equal to 100%.");
                }
            }

            // Initialize term and prompt until a valid input is provided
            int term = 0;
            while (true) {
                String termInput = JOptionPane.showInputDialog("Enter term (1, 3, or 5 years):");
                // Check if the user clicked Cancel
                if (termInput == null) {
                    System.exit(0); // Exit the application
                }

                term = Integer.parseInt(termInput); // Convert input to integer

                // Validate term
                if (term >= 1) {
                    break; // Valid term, exit loop
                } else {
                    // Show error message for invalid term
                    JOptionPane.showMessageDialog(null, "Please enter a term greater than 1 year.");
                }
            }

            // Create the appropriate mortgage object
            if (type.toUpperCase().equals("BUSINESS")) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, primeRate, term);
                mortgages[i].setInterestRate(primeRate); // Calling the setInterestRate method
            } else if (type.toUpperCase().equals("PERSONAL")) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, mortgageAmount, primeRate, term);
                mortgages[i].setInterestRate(primeRate); // Calling the setInterestRate method
            }

        }

        // Display all mortgages
        String mortgageInfo = "Mortgage Information:\n\n";
        for (Mortgage mortgage : mortgages) {
            // Call the getMortgageInfo method to get the mortgage details
            // Determine the mortgage type
            String typeLabel;
            if (mortgage instanceof BusinessMortgage) {
                typeLabel = "Business";
            } else {
                typeLabel = "Personal";
            }

            // Construct mortgage information including the type
            mortgageInfo += "Mortgage Type: " + typeLabel + "\n" + mortgage.getMortgageInfo() + "\n";


            // Calculate and append the current prime rate and final interest rate
            double currentPrimeRate;
            if (mortgage instanceof BusinessMortgage) {
                currentPrimeRate = ((BusinessMortgage) mortgage).interestRate - 1; // Adjusted interest for business
            } else {
                currentPrimeRate = ((PersonalMortgage) mortgage).interestRate - 2; // Adjusted interest for personal
            }

            mortgageInfo += "Prime Interest Rate: " + currentPrimeRate + "%\n\n";
        }

        // Show the mortgage information in a message dialog
        JOptionPane.showMessageDialog(null, mortgageInfo);
    }
}
