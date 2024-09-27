package exercise3;

public class OverloadedMethods {

    // First method: Adds two integers
    public static double arithmeticOperations(int a, int b) {

        return a + b;
    }

    // Second method: Subtract two integers
    public static double arithmeticOperations(double a, double b) {

        return a -b ;
    }

    // Third method: Multiply two integers
    public static  double arithmeticOperations(int a, double b) {

        return a * b;
    }

    // Main method to test the overloaded methods
    public static void main(String[] args) {
        // Calling overloaded methods
        double result1 = arithmeticOperations(10, 5);       // Adds two integers
        double result2 = arithmeticOperations(10.0, 5.0);     // Subtract two integers
        double result3 = arithmeticOperations(10, 5.0); // Multiply two integers

        // Display results
        System.out.printf("The result of adding 10 and 5 is equal to: %.0f%n", result1);
        System.out.printf("The result of subtracting 10 and 5 is equal to: %.0f%n", result2);
        System.out.printf("The result of multiplying 10 and 5 is equal to: %.0f%n",  result3);
    }
}


