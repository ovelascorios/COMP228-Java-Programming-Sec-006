package exercise3;


// MortgageConstants interface
interface MortgageConstants {
    int SHORT_TERM = 1; // Short term duration in years
    int MEDIUM_TERM = 3; // Medium term duration in years
    int LONG_TERM = 5; // Long term duration in years
    String BANK_NAME = "CityToronto Bank"; // Name of the bank
    double MAX_MORTGAGE_AMOUNT = 300000.0; // Maximum allowed mortgage amount
}

// Abstract class Mortgage implementing the MortgageConstants interface
abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber; // Unique identifier for the mortgage
    protected String customerName; // Name of the customer
    protected double mortgageAmount; // Amount of the mortgage
    protected double interestRate; // Interest rate for the mortgage
    protected int term; // Term duration of the mortgage in years

    // Constructor to initialize mortgage properties
    public Mortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber; // Set the mortgage number
        this.customerName = customerName; // Set the customer name

        // Set the mortgage amount, ensuring it does not exceed the maximum allowed
        if (mortgageAmount > MAX_MORTGAGE_AMOUNT) {
            this.mortgageAmount = MAX_MORTGAGE_AMOUNT; // Cap at maximum amount
        } else {
            this.mortgageAmount = mortgageAmount; // Use the provided amount
        }
        this.interestRate = interestRate; // Set the initial interest rate

        // Validate the term and set to default if invalid
        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
            this.term = SHORT_TERM; // Default to short term if invalid
        } else {
            this.term = term; // Use the provided term
        }
    }

    // Abstract method to set the interest rate based on a prime rate
    public abstract void setInterestRate(double primeRate);

    // Method to get mortgage information as a string
    public String getMortgageInfo() {
        return "Bank Name: " + BANK_NAME +
                "\nMortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nMortgage Amount: $" + String.format("%,.0f",mortgageAmount) +
                "\nTerm: " + term + " years" +
                "\nInterest Rate: " + interestRate + "%" ;
    }
}

// BusinessMortgage subclass extending the Mortgage class
class BusinessMortgage extends Mortgage {

    // Constructor to initialize a BusinessMortgage object
    public BusinessMortgage(String mortgageNumber, String customerName, double mortgageAmount, double primeRate, int term) {
        // Call the superclass constructor, adjusting the interest rate
        super(mortgageNumber, customerName, mortgageAmount, primeRate, term);
    }

    // Implement the setInterestRate method for BusinessMortgage
    @Override
    public void setInterestRate(double primeRate) {this.interestRate = primeRate + 1;} // Set interest rate with an additional 1%
}

// PersonalMortgage subclass extending the Mortgage class
class PersonalMortgage extends Mortgage {
    // Constructor to initialize a PersonalMortgage object
    public PersonalMortgage(String mortgageNumber, String customerName, double mortgageAmount, double primeRate, int term) {
        // Call the superclass constructor, adjusting the interest rate
        super(mortgageNumber, customerName, mortgageAmount, primeRate, term);
    }

    // Implement the setInterestRate method for PersonalMortgage
    @Override
    public void setInterestRate(double primeRate) { this.interestRate = primeRate + 2;} // Set interest rate with an additional 2%
}

