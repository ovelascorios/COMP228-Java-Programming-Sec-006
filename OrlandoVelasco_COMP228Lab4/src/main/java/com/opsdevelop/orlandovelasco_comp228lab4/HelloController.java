// Define the package name for this controller class
package com.opsdevelop.orlandovelasco_comp228lab4;

// Import necessary JavaFX and utility classes
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
import java.util.List;

// Controller class for handling UI interactions and logic
public class HelloController {

    // FXML fields linked to input fields in the UI for user information
    @FXML
    private TextField nameField, addressField, cityField, provinceField, postalCodeField, phoneNumberField, emailField;

    // FXML fields for radio buttons to select major
    @FXML
    private RadioButton computerScienceRadioButton, businessRadioButton;

    // ComboBox to display a list of available courses
    @FXML
    private ComboBox<String> coursesComboBox;

    // ListView to display selected courses
    @FXML
    private ListView<String> coursesListView;

    // Checkboxes for additional activities
    @FXML
    private CheckBox studentCouncilCheckBox, volunteerWorkCheckBox;

    // TextArea to display output messages for user information
    @FXML
    private TextArea messageTextArea;

    // Toggle group to ensure only one major selection is active at a time
    private final ToggleGroup majorToggleGroup = new ToggleGroup();

    // Observable lists containing course options based on selected major
    private final ObservableList<String> computerScienceCourses = FXCollections.observableArrayList("Python", "Java", "C#", "Data base", "Javascript");
    private final ObservableList<String> businessCourses = FXCollections.observableArrayList("Economics", "Marketing", "Finance", "Business Management", "Accounting");

    // Initialization method called after FXML components are loaded
    @FXML
    private void initialize() {

        // Set up the radio buttons with a toggle group to control major selection
        computerScienceRadioButton.setToggleGroup(majorToggleGroup);
        businessRadioButton.setToggleGroup(majorToggleGroup);

        // Add a listener to detect changes in the major selection
        majorToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            updateCourses();
            clearCoursesListView();
        });

        // Add an action listener to the ComboBox to add courses without duplicates
        coursesComboBox.setOnAction(event -> addSelectedCourse());

    }

    // Method to update course options based on the selected major
    private void updateCourses() {
        if (computerScienceRadioButton.isSelected()) {
            coursesComboBox.setItems(computerScienceCourses);
        } else if (businessRadioButton.isSelected()) {
            coursesComboBox.setItems(businessCourses);
        }
    }

    // Method to add selected course from ComboBox to ListView without duplicates
    private void addSelectedCourse() {
        String selectedCourse = coursesComboBox.getValue();
        if (selectedCourse != null && !coursesListView.getItems().contains(selectedCourse)) {
            coursesListView.getItems().add(selectedCourse);
        }
    }

    // Method to clear the ListView when a new major is selected
    private void clearCoursesListView() {
        coursesListView.getItems().clear();
    }

    // Method to handle the "Display" button click event
    @FXML
    private void onDisplayButtonClick() {
        try {

            // Retrieve user input from text fields
            String name = nameField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String province = provinceField.getText();
            String postalCode = postalCodeField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();
            RadioButton selectedMajor = (RadioButton) majorToggleGroup.getSelectedToggle();

            // Ensure a major is selected
            if (selectedMajor == null) {
                showAlert("Input Error", "Please select a major.");
                return;
            }
            String major = selectedMajor.getText();

            // Check if all required fields have been filled
            if (name.isBlank() || address.isBlank() || city.isBlank() || province.isBlank() || postalCode.isBlank()
                    || phoneNumber.isBlank() || email.isBlank() || major == null) {
                showAlert("Input Error", "Please fill in all fields.");
                return;
            }

            // Verify that at least one course is selected
            if (coursesListView.getItems().isEmpty()) {
                showAlert("Input Error", "Please select at least one course.");
                return;
            }

            // Gather selected activities into a list
            List<String> activities = new ArrayList<>();
            if (studentCouncilCheckBox.isSelected()) activities.add("Student Council");
            if (volunteerWorkCheckBox.isSelected()) activities.add("Volunteer Work");

            // Display user information in the message TextArea
            messageTextArea.clear();
            messageTextArea.appendText(String.format("%s, %s, %s, %s, %s, %s, %s\n", name, address, city, province, postalCode, phoneNumber, email));

            // Display selected major
            messageTextArea.appendText("Major: " + major + "\n");

            // Display selected activities, if any
            if (!activities.isEmpty()) {
                String joinedActivities = String.join(", ", activities);
                messageTextArea.appendText("Activities: " + joinedActivities + "\n");
            }

            // Display list of selected courses
            messageTextArea.appendText("Courses:\n");
            int index = 1;
            for (String course : coursesListView.getItems()) {
                messageTextArea.appendText(" " + index + "- " + course + "\n");
                index++;
            }

            // Clear input fields after displaying information
            nameField.clear();
            addressField.clear();
            cityField.clear();
            provinceField.clear();
            postalCodeField.clear();
            phoneNumberField.clear();
            emailField.clear();
            coursesListView.getItems().clear();
            coursesComboBox.setValue(null);
            majorToggleGroup.selectToggle(null);
            studentCouncilCheckBox.setSelected(false);
            volunteerWorkCheckBox.setSelected(false);

        } catch (Exception e) {
            // Show an error alert if an unexpected exception occurs
            showAlert("Unexpected Error", "An error occurred while processing your request. Please try again.");
        }
    }

    // Utility method to display alert messages
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
