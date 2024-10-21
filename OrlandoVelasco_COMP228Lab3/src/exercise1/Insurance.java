package exercise1;

// Import necessary packages for user interaction
import javax.swing.JOptionPane;

// Abstract superclass for different types of Insurance
abstract class Insurance {
    private String type; // Type of insurance (e.g., Health, Life)
    private double monthlyCost; // Monthly cost of the insurance

    // Constructor to initialize the insurance type
    public Insurance(String type) {
        this.type = type;
    }

    // Getter method for insurance type
    public String getType() {
        return type;
    }

    // Getter method for monthly cost
    public double getMonthlyCost() {
        return monthlyCost;
    }

    // Setter method for monthly cost
    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    // Abstract method to set the insurance cost, to be implemented by subclasses
    public abstract void setInsuranceCost();

    // Abstract method to display insurance information, to be implemented by subclasses
    public abstract void displayInfo();
}

// Subclass for Health Insurance
class HealthInsurance extends Insurance {
    protected String name; // Name of the health insurance plan
    protected String description; // Description of the health insurance plan

    // Constructor to initialize health insurance details
    public HealthInsurance(String name, String type, String description) {
        super(type); // Call to the superclass constructor to set the insurance type
        this.name = name;
        this.description = description;
    }

    // Method to set the monthly cost based on the selected health insurance plan
    @Override
    public void setInsuranceCost() {
        // Set monthly cost based on the name  of health insurance plan
        switch (name) {
            case "Basic plan":
                setMonthlyCost(150); // Cost for Basic plan
                break;
            case "Standard plan":
                setMonthlyCost(300); // Cost for Standard plan
                break;
            case "Premium plan":
                setMonthlyCost(500); // Cost for Premium plan
                break;
        }
    }

    // Method to display information about the health insurance plan
    @Override
    public void displayInfo() {
        // Display insurance details in a message dialog
        JOptionPane.showMessageDialog(null,
                "Name: " + name +
                        "\nInsurance Type: " + getType() +
                        "\nDescription: " + description +
                        "\nMonthly Cost: $" + getMonthlyCost());
    }
}

// Subclass for Life Insurance
class LifeInsurance extends Insurance {
    protected String name; // Name of the life insurance plan
    protected String description; // Description of the life insurance plan

    // Constructor to initialize life insurance details
    public LifeInsurance(String name, String type, String description) {
        super(type); // Call to the superclass constructor to set the insurance type
        this.name = name;
        this.description = description;
    }

    // Method to set the monthly cost based on the selected life insurance plan
    @Override
    public void setInsuranceCost() {
        // Set monthly cost based on the name of life insurance plan
        switch (name) {
            case "20 Years at $250,000 plan":
                setMonthlyCost(20); // Cost per beneficiary for this specific life insurance plan
                break;
            case "20 Years at $300,000 plan":
                setMonthlyCost(30); // Cost per beneficiary for this specific life insurance plan
                break;
            case "15 Years at $250,000 plan":
                setMonthlyCost(15); // Cost per beneficiary for this specific life insurance plan
                break;
            case "15 Years at $300,000 plan":
                setMonthlyCost(25); // Cost per beneficiary for this specific life insurance plan
                break;
            case "$100,000 plan":
                setMonthlyCost(150); // Cost per beneficiary for this specific life insurance plan
                break;
            case "$150,000 plan":
                setMonthlyCost(250); // Cost per beneficiary for this specific life insurance plan
                break;
            case "Up to $50,000 plan":
                setMonthlyCost(200); // Cost per beneficiary for this specific life insurance plan
                break;
            case "Up to $100,000 plan":
                setMonthlyCost(300); // Cost per beneficiary for this specific life insurance plan
                break;
        }
    }

    // Method to display information about the life insurance plan
    @Override
    public void displayInfo() {
        // Display insurance details in a message dialog
        JOptionPane.showMessageDialog(null,
                "Name: " + name +
                        "\nInsurance Type: " + getType() +
                        "\nDescription: " + description +
                        "\nMonthly Cost: $" + getMonthlyCost());
    }
}
