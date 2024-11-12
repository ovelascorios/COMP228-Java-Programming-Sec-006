// Defines the package where this file belongs
package com.opsdevelop.orlandovelasco_comp228lab4;

// Import necessary JavaFX classes
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

// Main class for the application, extending JavaFX Application
public class HelloApplication extends Application {

    // Override start method to set up and display the main stage
    @Override
    public void start(Stage stage) throws IOException {

        // Load the FXML layout for the main interface from hello-view.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Load the root VBox element from the FXML file
        VBox  root = fxmlLoader.load();

        // Set white background for the VBox layout
        root.setStyle("-fx-background-color: white;");

        // Create a new Scene object using the VBox layout as the root
        Scene scene = new Scene(root);

        // Set an icon for the application window from a URL
        Image icon = new Image("https://upload.wikimedia.org/wikipedia/en/c/cc/JavaFX_Logo.png");
        stage.getIcons().add(icon);

        // Set the title of the application window
        stage.setTitle("Student information details");

        // Apply the scene to the stage (main window)
        stage.setScene(scene);

        // Show the stage, making the application window visible
        stage.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch();
    }
}