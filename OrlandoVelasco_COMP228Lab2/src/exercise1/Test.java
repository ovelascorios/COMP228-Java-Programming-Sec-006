package exercise1;

// Import of necessary packages for user interaction
import javax.swing.JOptionPane;
import java.util.Random;

// Class definition
public class Test {
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private Random randomObject = new Random(); // Random number generator
    private boolean quizCompleted = true; // Flag to check if quiz was completed

    // Array of questions and answers
    private String[][] questions = {
            {"Which of the following statements is false about Java method statements?",
                    "A) Statements in a method body is written only once.",
                    "B) Statements in a method body are not hidden from other methods.",
                    "C) Statements in a method body use existing classes and methods as building blocks to create new programs.",
                    "D) Statements in a method body determine the behavior of an object.",
                    "B"},
            {"Method arguments may be______________________________.",
                    "A) only constants",
                    "B) only variables",
                    "C) constants, variables, or expressions",
                    "D) only strings",
                    "C"},
            {"Class variables must be declared as___________.",
                    "A) final",
                    "B) static",
                    "C) const",
                    "D) var",
                    "B"},
            {"A method’s parameters are____________________________",
                    "A) instance variables that are not shared by all objects",
                    "B) class variables and shared by all the objects",
                    "C) local variables of that method and can be used only in that method’s body",
                    "D) global variables and can be used from anywhere inside the application source code",
                    "C"},
            {"What is the main function of a Java compiler?",
                    "A) It translates the Java source code into bytecodes that represent the tasks to execute.",
                    "B) It executes the bytecodes.",
                    "C) It places the program in memory to execute it.",
                    "D) It examines the bytecodes to ensure that they are valid and do not violate Java’s security restrictions.",
                    "A"}
    };

    // Method to display questions and validate user answers
    public void simulateQuestions(String userInput, int questionIndex) {
        // Fetch the correct answer from the question set
        String correctAnswer = questions[questionIndex][5];

        if (userInput != null) { // Check if the user give an answer
            String userAnswer = userInput.toUpperCase(); // Convert to uppercase to handle case sensitivity
            checkAnswer(correctAnswer, userAnswer); // Check the answer
        } else {
            // Handle the case when the user presses cancel
            quizCompleted = false;
            JOptionPane.showMessageDialog(null, "You canceled the quiz.");
        }

        // After the last question, check if the quiz was completed successfully and show the results
        if (questionIndex == questions.length - 1 && quizCompleted) {
            double totalQuestions = questions.length;
            double percentage = (correctAnswers / totalQuestions) * 100 ;
            JOptionPane.showMessageDialog(null, "Test Completed!\nCorrect Answers: " + correctAnswers +
                    "\nIncorrect Answers: " + incorrectAnswers + "\nPercentage of correct answers: " + percentage + "%");
        }
    }


    // Method to receive user input and pass it to simulateQuestions
    public void inputAnswer() {
        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            String[] question = questions[i];

            // Prompt user for an answer
            String input = JOptionPane.showInputDialog(null, question[0] + "\n" + question[1] + "\n" + question[2] + "\n" + question[3] + "\n" + question[4]);

            // Pass the input and question index to simulateQuestions for validation
            simulateQuestions(input, i);

            // Break the loop if the quiz was canceled
            if (!quizCompleted) {
                break;
            }
        }
    }

    // Check if the user's answer is correct
    public void checkAnswer(String correctAnswer, String userAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            correctAnswers++; // Increment correct answers
            generateMessage(true); // Show random message for correct answer
        } else {
            incorrectAnswers++; // Increment incorrect answers
            generateMessage(false); // Show random message for incorrect answer
            JOptionPane.showMessageDialog(null, "The correct answer is: " + correctAnswer); //show the correct answer
        }
    }

    // Generate random messages based on correctness
    public void generateMessage(boolean isCorrect) {
        String message;

        // Use a switch statement for correct answers
        if (isCorrect) {
            switch (randomObject.nextInt(4)) {
                case 0:
                    message = "Excellent!";
                    break;
                case 1:
                    message = "Good!";
                    break;
                case 2:
                    message = "Keep up the good work!";
                    break;
                default:
                    message = "Nice work!";
                    break;
            }
        } else {
            // Use a switch statement for incorrect answers
            switch (randomObject.nextInt(4)) {
                case 0:
                    message = "No. Please try again.";
                    break;
                case 1:
                    message = "Wrong. Try once more.";
                    break;
                case 2:
                    message = "Don't give up!";
                    break;
                default:
                    message = "No. Keep trying.";
                    break;
            }
        }

        // Display the message
        JOptionPane.showMessageDialog(null, message);
    }

    // Main method to start the test
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Java Programming's Test");
        JOptionPane.showMessageDialog(null, "Instructions:\n In this test, there are 5 multiple-choice questions. To answer, you must enter (A, B, C, or D) corresponding to your desired option.\nGood luck, and let’s begin!");
        Test test = new Test(); // Create a Test object

        // Call the inputAnswer method to start receiving answers
        test.inputAnswer();
    }
}
