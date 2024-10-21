package exercise1;

// Import necessary packages for user interaction
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    // Define the maximum number of beneficiaries
    private static final int MAX_BENEFICIARIES = 3;

    public static void main(String[] args) {
        // Gather user information through input dialogs

        // Input Full Name
        String fullName = JOptionPane.showInputDialog("Enter Full Name:");
        if (fullName == null) {
            System.exit(0);  // Exit if user pressed 'Cancel'
        }

        // Input Phone Number
        String phoneNumber = JOptionPane.showInputDialog("Enter Phone Number:");
        if (phoneNumber == null) {
            System.exit(0);
        }

        // Input Age
        String ageInput = JOptionPane.showInputDialog("Enter Age:");
        if (ageInput == null) {
            System.exit(0);
        }
        int age = Integer.parseInt(ageInput);

        // Input Marital Status
        String maritalStatus = JOptionPane.showInputDialog("Enter Marital Status:");
        if (maritalStatus == null) {
            System.exit(0);
        }

        // Input Number of Dependents
        String dependentsInput = JOptionPane.showInputDialog("Enter Number of Dependents:");
        if (dependentsInput == null) {
            System.exit(0);
        }
        int numberOfDependents = Integer.parseInt(dependentsInput);

        // Input Occupation
        String occupation = JOptionPane.showInputDialog("Enter Occupation:");
        if (occupation == null) {
            System.exit(0);
        }

        // Input Annual Income
        String incomeInput = JOptionPane.showInputDialog("Enter Annual Income ($):");
        if (incomeInput == null) {
            System.exit(0);
        }
        double annualIncome = Double.parseDouble(incomeInput);

        // Input Number of Beneficiaries
        String beneficiariesInput = JOptionPane.showInputDialog("Enter Number of Beneficiaries (Max 3):");
        if (beneficiariesInput == null) {
            System.exit(0);
        }
        int numberOfBeneficiaries = Integer.parseInt(beneficiariesInput);

        // Keep prompting the user if the number of beneficiaries is invalid
        while (numberOfBeneficiaries < 1 || numberOfBeneficiaries > MAX_BENEFICIARIES) {
            numberOfBeneficiaries = Integer.parseInt(JOptionPane.showInputDialog("Please enter a valid number of beneficiaries (1-3):"));
        }

        // Initialize arrays to store the names and affiliations of the beneficiaries
        ArrayList<String> beneficiaryNames = new ArrayList<>();
        ArrayList<String> beneficiaryAffiliations = new ArrayList<>();

        // Collect information for each beneficiary
        for (int i = 1; i <= numberOfBeneficiaries; i++) {
            String name = JOptionPane.showInputDialog("Beneficiary #" + i + "\nEnter Name:");

            if (name == null) {
                System.exit(0);
            }

            String affiliation = JOptionPane.showInputDialog("Beneficiary #" + i + "\nEnter Affiliation:");
            if (affiliation == null) {
                System.exit(0);
            }
            beneficiaryNames.add(name);
            beneficiaryAffiliations.add(affiliation);
        }

        // Prompt user to select the type of insurance
        String insuranceType = JOptionPane.showInputDialog("Select the type of insurance to purchase:\n1. Health Insurance\n2. Life Insurance");
        if (insuranceType == null) {
            System.exit(0);
        }

        Insurance[] insurances = new Insurance[5]; // Array to hold insurance options
        int insuranceCount = 0; // Counter for the number of insurance options

        if (insuranceType.equals("1")) {
            // Offer Health Insurance options based on user input

            // Check if the user qualifies for a basic plan based on age and dependents
            if (age >= 18 && numberOfDependents <= 2) {
                String description = "Covers essential healthcare services.";
                HealthInsurance healthInsurance = new HealthInsurance("Basic plan", "Health Insurance", description);
                healthInsurance.setInsuranceCost(); // Set the insurance cost
                insurances[insuranceCount++] = healthInsurance; // Add the insurance to the array
            }

            // Offer a standard plan based on age, income, and dependents
            if (age >= 18 && annualIncome >= 30000 && numberOfDependents <= 3) {
                String description = "Offers comprehensive coverage.";
                HealthInsurance healthInsurance = new HealthInsurance("Standard plan", "Health Insurance", description);
                healthInsurance.setInsuranceCost();
                insurances[insuranceCount++] = healthInsurance;
            }

            // Offer a premium plan based on age and income
            if (age >= 18 && annualIncome >= 50000) {
                String description = "Covers a wide range of services.";
                HealthInsurance healthInsurance = new HealthInsurance("Premium plan", "Health Insurance", description);
                healthInsurance.setInsuranceCost();
                insurances[insuranceCount++] = healthInsurance;
            }

            // Additional questions for health insurance eligibility

            String hasPreExisting;

            while (true) {
                hasPreExisting = JOptionPane.showInputDialog("Do you have any pre-existing medical conditions? (yes/no)");

                if (hasPreExisting == null) {
                    System.exit(0);
                }

                // Validate user input
                if (hasPreExisting.toUpperCase().equals("YES") || hasPreExisting.toUpperCase().equals("NO")) {
                    break; // Valid input, exit the loop
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'yes' or 'no'.");
                }
            }


            String dentalVision;

            while (true) {
                dentalVision = JOptionPane.showInputDialog("Do you have any pre-existing medical conditions? (yes/no)");

                if (dentalVision == null) {
                    System.exit(0);
                }

                // Validate user input
                if (dentalVision.toUpperCase().equals("YES") || dentalVision.toUpperCase().equals("NO")) {
                    break; // Valid input, exit the loop
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'yes' or 'no'.");
                }
            }

            String maternityCoverage;

            while (true) {
                maternityCoverage = JOptionPane.showInputDialog("Do you have any pre-existing medical conditions? (yes/no)");

                if (maternityCoverage == null) {
                    System.exit(0);
                }

                // Validate user input
                if (maternityCoverage.toUpperCase().equals("YES") || maternityCoverage.toUpperCase().equals("NO")) {
                    break; // Valid input, exit the loop
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'yes' or 'no'.");
                }
            }


            // Validate health insurance eligibility based on pre-existing conditions
            if (hasPreExisting.toUpperCase().equals("YES") && dentalVision.toUpperCase().equals("YES") && maternityCoverage.toUpperCase().equals("YES")) {
                JOptionPane.showMessageDialog(null, "You may not qualify for Basic or Standard Health Insurance due to pre-existing conditions.");
            }

        } else if (insuranceType.equals("2")) {
            // Life Insurance options based on user input
            String lifeType = JOptionPane.showInputDialog("Do you want a term life, whole life, or Final Expense insurance policy?\n1. Term Life Insurance\n2. Whole Life Insurance\n3. Final Expense Insurance");
            if (lifeType  == null) {
                System.exit(0);
            }

            if (lifeType.equals("1")) {
                // Offer Term Life Insurance options
                String termOptions = JOptionPane.showInputDialog("Select coverage:\n1. 20 Years at $250,000\n2. 20 Years at $300,000\n3. 15 Years at $250,000\n4. 15 Years at $300,000");
                LifeInsurance lifeInsurance = null;
                String description = "Provides coverage for a specified term.";

                // Set the appropriate plan based on the user's choice
                switch (termOptions) {
                    case "1":
                        lifeInsurance = new LifeInsurance("20 Years at $250,000 plan", "Term Life Insurance", description);
                        break;
                    case "2":
                        lifeInsurance = new LifeInsurance("20 Years at $300,000 plan", "Term Life Insurance", description);
                        break;
                    case "3":
                        lifeInsurance = new LifeInsurance("15 Years at $250,000 plan", "Term Life Insurance", description);
                        break;
                    case "4":
                        lifeInsurance = new LifeInsurance("15 Years at $300,000 plan", "Term Life Insurance", description);
                        break;
                }

                // Add the insurance to the array if a valid option was selected
                if (lifeInsurance != null) {
                    lifeInsurance.setInsuranceCost(); // Set the cost of the insurance
                    insurances[insuranceCount++] = lifeInsurance;
                }

            } else if (lifeType.equals("2")) {
                // Offer Whole Life Insurance options
                String wholeLifeOptions = JOptionPane.showInputDialog("Select coverage:\n1. $100,000\n2. $150,000");
                LifeInsurance lifeInsurance = null;
                String description = "Provides lifelong coverage with a cash value.";

                // Set the appropriate plan based on the user's choice
                switch (wholeLifeOptions) {
                    case "1":
                        lifeInsurance = new LifeInsurance("$100,000 plan", "Whole Life Insurance", description);
                        break;
                    case "2":
                        lifeInsurance = new LifeInsurance("$150,000 plan", "Whole Life Insurance", description);
                        break;
                }
                if (lifeInsurance != null) {
                    lifeInsurance.setInsuranceCost();
                    insurances[insuranceCount++] = lifeInsurance;
                }

            } else if (lifeType.equals("3")) {
                // Offer Final Expense Insurance options
                String finalExpenseOptions = JOptionPane.showInputDialog("Select coverage:\n1. up to $50,000\n2. up to $100,000");
                LifeInsurance lifeInsurance = null;
                String description = "Covers funeral and burial costs.";
                // Set the appropriate plan based on the user's choice
                switch (finalExpenseOptions) {
                    case "1":
                        lifeInsurance = new LifeInsurance("Up to $50,000 plan", "Final Expense Insurance", description);
                        break;
                    case "2":
                        lifeInsurance = new LifeInsurance("Up to $100,000 plan", "Final Expense Insurance", description);
                        break;
                }
                if (lifeInsurance != null) {
                    lifeInsurance.setInsuranceCost();
                    insurances[insuranceCount++] = lifeInsurance;
                }
            }
        }

        // Display the collected user information in a message dialog
        String userInfo = "User Information:\n" +
                "Full Name: " + fullName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Age: " + age + "\n" +
                "Marital Status: " + maritalStatus + "\n" +
                "Number of Dependents: " + numberOfDependents + "\n" +
                "Occupation: " + occupation + "\n" +
                "Annual Income: $" + String.format("%,.0f", annualIncome) + "\n" +
                "Number of Beneficiaries: " + numberOfBeneficiaries + "\n";

        // Append beneficiary information to the user info string
        for (int i = 0; i < numberOfBeneficiaries; i++) {
            userInfo += "  -Beneficiary #" + (i + 1) + " " + beneficiaryNames.get(i) + " (" +
                  beneficiaryAffiliations.get(i) + ")\n";
        }

        // Show the user information in a message dialog
        JOptionPane.showMessageDialog(null, userInfo);

        // Display the available insurance options, if any were found
        if (insuranceCount > 0) {
            String insuranceMessage = "Based on the information given, the available insurance plans that you can apply for are:\n\n";

            // Loop through the available insurance options
            for (int i = 0; i < insuranceCount; i++) {
                // Use if statements to determine the name, type, description, and cost in the correct order
                if (insurances[i] instanceof HealthInsurance) {
                    HealthInsurance healthInsurance = (HealthInsurance) insurances[i];
                    insuranceMessage += "Plan Name: " + healthInsurance.name + "\n" +   // Plan Name
                            "Insurance Type: " + healthInsurance.getType() + "\n" +  // Insurance Type
                            "Description: " + healthInsurance.description + "\n" +  // Description
                            "Monthly Cost: $" + String.format("%,.0f", healthInsurance.getMonthlyCost() * numberOfBeneficiaries) + "\n\n";  // Monthly Cost
                } else if (insurances[i] instanceof LifeInsurance) {
                    LifeInsurance lifeInsurance = (LifeInsurance) insurances[i];
                    insuranceMessage += "Plan Name: " + lifeInsurance.name + "\n" +  // Plan Name
                            "Insurance Type: " + lifeInsurance.getType() + "\n" +  // Insurance Type
                            "Description: " + lifeInsurance.description + "\n" +  // Description
                            "Monthly Cost: $" + String.format("%,.0f", lifeInsurance.getMonthlyCost() * numberOfBeneficiaries)  + "\n\n";  // Monthly Cost
                }
            }
            // Display the insurance message with the updated order
            JOptionPane.showMessageDialog(null, insuranceMessage);
        } else {
            // Notify the user if no insurance plans are available
            JOptionPane.showMessageDialog(null, "No insurances are available for the information given.");
        }


    }
}
