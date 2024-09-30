package application;

import Messaging.messages;
import Patient.*;
import create_login.doctor;
import Profile.Profile;

import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class Main {
    public static void main(String[] args) {
//    	Patient myPatient = new Patient();
//    	Stage primaryStage = new Stage();
//    	myPatient.createAccount("Pratyusha", "Kumar", "12/3/2004", "pk@gmail.com", "hello");
//        Dashboard(primaryStage, myPatient);
    }
    
    public static void Dashboard(Stage primaryStage, Object currentUser) {
    	if(currentUser instanceof Patient) {
    		Patient myPatient = (Patient) currentUser;
    		PatientDash(primaryStage, myPatient);
    	}
    	else if(currentUser instanceof doctor){
    		doctor mydoctor = (doctor) currentUser;
    		DoctorDash(primaryStage, mydoctor);
    	}
        
    }
    
    public static void DoctorDash(Stage primaryStage, doctor Doctor) {
    	BorderPane root = new BorderPane();
        
        // Create a VBox on the left side
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(250);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setStyle("-fx-background-color: white;");
        leftBox.setSpacing(10);
        
        // Create buttons
        Button homeButton = new Button("HOME");
        homeButton.setPrefSize(150, 55);
        homeButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        
        Button healthFormButton = new Button("HEALTH FORM");
        healthFormButton.setPrefSize(150, 55);
        healthFormButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        healthFormButton.setOnAction(e -> {
        	Healthform a = new Healthform();
        	a.healthform(primaryStage, Doctor);
//        	System.out.println("hell");
        });
        
        Button messageButton = new Button("MESSAGE");
        messageButton.setPrefSize(150, 55);
        messageButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        Button otherButton = new Button("OTHER");
        otherButton.setPrefSize(150, 55);
        otherButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        HBox blue = new HBox();
        blue.setStyle("-fx-background-color: blue;");
        blue.setMinHeight(60);
        blue.setMinWidth(1000);
        // Add buttons to VBox
        leftBox.getChildren().addAll(homeButton, healthFormButton, messageButton, otherButton);
        
        // Set VBox on the left side of the BorderPane
        root.setLeft(leftBox);
        root.setTop(blue);
        
        
        
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void PatientDash(Stage primaryStage, Patient patient) {
    	BorderPane root = new BorderPane();
        
        // Create a VBox on the left side
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(250);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setStyle("-fx-background-color: white;");
        leftBox.setSpacing(10);
        
        // Create buttons
        Button homeButton = new Button("HOME");
        homeButton.setPrefSize(150, 55);
        homeButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        
        Button healthFormButton = new Button("PROFILE");
        healthFormButton.setPrefSize(150, 55);
        healthFormButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        healthFormButton.setOnAction(e -> 
        	{Profile p = new Profile();
        	p.profile(primaryStage, patient);
        	
        	});
        
        Button messageButton = new Button("MESSAGE");
        messageButton.setPrefSize(150, 55);
        messageButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        
        Button otherButton = new Button("OTHER");
        otherButton.setPrefSize(150, 55);
        otherButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        HBox blue = new HBox();
        blue.setStyle("-fx-background-color: blue;");
        blue.setMinHeight(60);
        blue.setMinWidth(1000);
        // Add buttons to VBox
        leftBox.getChildren().addAll(homeButton, healthFormButton, messageButton, otherButton);
        
        // Set VBox on the left side of the BorderPane
        root.setLeft(leftBox);
        root.setTop(blue);
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}