package create_login;

import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class create_doctor extends Application {

public void start(Stage primaryStage) {
        
        HBox topBar = createTopBar();
        GridPane createDoctorAccountGrid = createDoctorAccountGrid();
        HBox bottomBar = createBottomBar();
        javafx.scene.control.Separator separator = new javafx.scene.control.Separator();
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);

        HBox root = new HBox(20, createDoctorAccountGrid);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f0f0f0;");

        VBox mainRoot = new VBox(topBar, root, bottomBar);
        Scene scene = new Scene(mainRoot, 1000, 450); // Extend the window height
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create Doctor Account");
        primaryStage.show();
    }

    // Method to create the top blue bar
    private HBox createTopBar() {
        HBox topBar = new HBox();
        topBar.setPrefHeight(40);
        topBar.setStyle("-fx-background-color: #0077cc;");
        topBar.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Koala Pediatrics");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        topBar.getChildren().add(titleLabel);

        return topBar;
    }

    // Method to create the bottom blue bar
    private HBox createBottomBar() {
        HBox bottomBar = new HBox();
        bottomBar.setPrefHeight(40);
        bottomBar.setStyle("-fx-background-color: #0077cc;");
        return bottomBar;
    }

    // method to create the create doctor account section
    GridPane createDoctorAccountGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        Label createAccountTitle = new Label("Create Doctor Account");
        createAccountTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setConstraints(createAccountTitle, 0, 0, 2, 1);

        Label warning = new Label("Note: This account creation page is only for clinic staff"); 
        warning.setFont(Font.font("Arial", FontWeight.BOLD, 16)); 
        warning.setTextFill(Color.RED); // Set text fill color to red
        GridPane.setConstraints(warning, 0, 6, 2, 1); 
        
        // First Name label and text area
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(firstNameLabel, 0, 1);
        TextArea firstNameField = new TextArea();
        firstNameField.setPrefRowCount(1);
        firstNameField.setPrefColumnCount(20);
        GridPane.setConstraints(firstNameField, 1, 1);

        // Password label and text area
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 2);

        // Last Name label and text area
        Label lastNameLabel = new Label("Last Name:");
        lastNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(lastNameLabel, 0, 3);
        TextArea lastNameField = new TextArea();
        lastNameField.setPrefRowCount(1);
        lastNameField.setPrefColumnCount(20);
        GridPane.setConstraints(lastNameField, 1, 3);

        // Re-enter Password label and text area
        Label reEnterPasswordLabel = new Label("Re-enter Password:");
        reEnterPasswordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(reEnterPasswordLabel, 0, 4);
        PasswordField reEnterPasswordField = new PasswordField();
        GridPane.setConstraints(reEnterPasswordField, 1, 4);

        // Email label and text area
        Label emailLabel = new Label("Email Address:");
        emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(emailLabel, 0, 5);
        TextArea emailField = new TextArea();
        emailField.setPrefRowCount(1);
        emailField.setPrefColumnCount(20);
        GridPane.setConstraints(emailField, 1, 5);

        // Create Account button
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-background-color: #0077cc; -fx-text-fill: white;");
        GridPane.setConstraints(createAccountButton, 0, 7, 2, 1);
        createAccountButton.setOnAction(e -> {
            // generate a random 6-digit ID
            if(firstNameField.getText().isBlank() || lastNameField.getText().isBlank() || passwordField.getText().isBlank() || emailField.getText().isBlank() || reEnterPasswordField.getText().isBlank()) {
            	Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Please make sure all the fields are filled in");
        		b.show();
            }
            else if (!isValidEmail(emailField.getText())) {
            	Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Please make sure email is correct");
        		b.show();
            }
            else if(!passwordField.getText().equals(reEnterPasswordField.getText())){
            	Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Please make sure passwords are matching");
        		b.show();
        	}
            else {
            	Random random = new Random();
                int doctorID = random.nextInt(900000) + 100000;
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                doctor doctorObject = new doctor(firstName, lastName);

                // serialize to .bin
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(doctorID + "_Doctor.bin"))) {
                    outputStream.writeObject(doctorObject);
                    System.out.println("Doctor object saved to file: " + doctorID + "_Doctor.bin");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                Stage currentStage = (Stage) createAccountButton.getScene().getWindow();
                currentStage.close();

                // OPEN THE DASHBOARD
//                openMainDashboard();
            }
        });

        grid.getChildren().addAll(createAccountTitle, warning, firstNameLabel, firstNameField, lastNameLabel, lastNameField,
                passwordLabel, passwordField, reEnterPasswordLabel, reEnterPasswordField, emailLabel, emailField,
                createAccountButton);

        return grid;
    }
    
//    private void openMainDashboard() {
//        Main main = new Main();
//        Stage mainStage = new Stage();
//        main.start(mainStage);
//    }
    
    public Scene createScene() {
    	HBox topBar = createTopBar();
        GridPane createAccountGrid = createDoctorAccountGrid();
        HBox bottomBar = createBottomBar();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        HBox root = new HBox(20, createAccountGrid);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f0f0f0;");
        VBox mainRoot = new VBox(topBar, root, bottomBar);
        Scene scene = new Scene(mainRoot, 800, 450); // Extend the window height
        return scene;
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}