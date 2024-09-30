package create_login;
import application.Main;

import Messaging.messages;
import Patient.Patient;
import create_login.doctor;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Patient.Patient;
import application.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class create_login extends Application{
	public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        // Create the top blue bar 
        HBox topBar = createTopBar();

        // Create the login section
        GridPane loginGrid = createLoginGrid(primaryStage);

        // Create the create account section
        GridPane createAccountGrid = createCreateAccountGrid();

        // Create the bottom blue bar
        HBox bottomBar = createBottomBar();

        // Add separator
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        // Align the sections horizontally with separator
        HBox root = new HBox(20, createAccountGrid, separator, loginGrid);
        root.setAlignment(Pos.CENTER);

        // Set padding for the root
        root.setPadding(new Insets(20));

        // Set the background color
        root.setStyle("-fx-background-color: white;");

        // Create the scene with wider width
        VBox mainRoot = new VBox(topBar, root, bottomBar);
        Scene scene = new Scene(mainRoot, 1000, 450); // Extend the window height
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login and Create Account");
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
        titleLabel.setTextFill(Color.WHITE);
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

    // Method to create the login section
    private GridPane createLoginGrid(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER); // Align to the top
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // Title
        Label loginTitle = new Label("Login");
        loginTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setConstraints(loginTitle, 0, 0, 2, 1);

        // ID label and text area
        Label idLabel = new Label("ID:");
        idLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(idLabel, 0, 1);
        TextArea idTextArea = new TextArea();
        idTextArea.setPrefRowCount(1);
        idTextArea.setPrefColumnCount(20);
        GridPane.setConstraints(idTextArea, 1, 1);

        // Password label and password field
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 2);

        // Login button
//        Patient mine = new Patient();
//        mine.createAccount("Kumar", "Pratyusha", "13/3/2004", "pkz@gmail.com", "pass");
        Button loginButton = new Button("Login");
//        loginButton.setOnAction(e -> Main.Dashboard(primaryStage, mine));

        loginButton.setStyle("-fx-background-color: #0077cc; -fx-text-fill: white;");
        GridPane.setConstraints(loginButton, 0, 3, 2, 1);
        loginButton.setOnAction(e -> {
        	if(passwordField.getText().isBlank()) {
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Please make sure your password is correct");
        		b.show();
        	}
        	else {
        		String id = idTextArea.getText();
            	String password = passwordField.getText();
            	if(id.length()==5) {
            		String filename = id+"_patient.bin";
            		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
                        Patient obj = (Patient) objectInputStream.readObject();
                        // Process the object as needed
                        System.out.println("Object read from file: " + obj.getFirstName());
                        Main.Dashboard(primaryStage, obj);
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
            	}
            	else if(id.length()==6){
            		String filename = id+"_Doctor.bin";
            		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
                        doctor obj = (doctor) objectInputStream.readObject();
                        // Process the object as needed
                        System.out.println("Object read from file: " + obj.getFirstName());
                        Main.Dashboard(primaryStage, obj);
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
            		
            	}
            	else {
            		Alert a = new Alert(AlertType.NONE);
            		a.setAlertType(AlertType.INFORMATION);
            		a.setContentText("Please enter a valid id");
            		a.show();
            	}
            	
        		
        	}
        });

        // Add elements to grid
        grid.getChildren().addAll(loginTitle, idLabel, idTextArea, passwordLabel, passwordField, loginButton);

        return grid;
    }

    // Method to create the create account section
    private GridPane createCreateAccountGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // Title
        Label createAccountTitle = new Label("Create Your Account");
        createAccountTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setConstraints(createAccountTitle, 0, 0, 2, 1);

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

        // email label and text area
        Label emailLabel = new Label("Email Address:");
        emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setConstraints(emailLabel, 0, 5);
        TextArea emailField = new TextArea();
        emailField.setPrefRowCount(1);
        emailField.setPrefColumnCount(20);
        GridPane.setConstraints(emailField, 1, 5);

        // create Account button
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-background-color: #0077cc; -fx-text-fill: white;");
        GridPane.setConstraints(createAccountButton, 0, 6, 2, 1);
        createAccountButton.setOnAction(e -> {
        	if(firstNameField.getText().isBlank() || lastNameField.getText().isBlank() || emailField.getText().isBlank() || passwordField.getText().isBlank()) {
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Please fill out all fields");
        		b.show();
        	}
        	else if (!passwordField.getText().equals(reEnterPasswordField.getText())) {
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText(passwordField.getText() + " " + reEnterPasswordField.getText());
        		
        		b.show();
        	}
        	else if(!isValidEmail(emailField.getText())) {
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Please make sure your email is in the correct format");
        		b.show();
        	}
        	else {
        		Random random = new Random();
                int patientID = random.nextInt(90000) + 10000;
                Patient patientObject = new Patient();
                patientObject.createAccount(firstNameField.getText(),lastNameField.getText(), "Date not available", emailLabel.getText(),passwordLabel.getText());

                // serialize to a .bin
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(patientID + "_patient.bin"))) {
                    outputStream.writeObject(patientObject);
                    System.out.println("Patient object saved to file: " + patientID + "_patient.bin");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

        	}
            
        });

        Button createStaffAccountButton = new Button("Create Staff Account");
        createStaffAccountButton.setStyle("-fx-background-color: #0077cc; -fx-text-fill: white;");
        GridPane.setConstraints(createStaffAccountButton, 0, 7, 2, 1);
        createStaffAccountButton.setOnAction(e -> {

            Stage staffAccountStage = new Stage();
            staffAccountStage.setTitle("Create Staff Account");
            create_doctor createDoctorAccount = new create_doctor();
            Scene staffAccountScene = createDoctorAccount.createScene();

            staffAccountStage.setScene(staffAccountScene);
            staffAccountStage.show();

            Stage currentStage = (Stage) createAccountButton.getScene().getWindow();
//            currentStage.close();
        });

        grid.getChildren().addAll(createAccountTitle, firstNameLabel, firstNameField, lastNameLabel, lastNameField,
                passwordLabel	, passwordField, reEnterPasswordLabel, reEnterPasswordField, emailLabel, emailField,
                createAccountButton, createStaffAccountButton);

        return grid;
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
