package Profile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Profile {
	
	public void profile(Stage primaryStage, Patient patient) {
		// Create a BorderPane as the root node
        BorderPane root = new BorderPane();
        
        // Create content for the left side (1/4 of the scene)
        VBox leftContent = previewView();
        leftContent.setStyle("-fx-background-color: #0000ff;");
        
        GridPane gridpane = detailView(primaryStage, patient);
        gridpane.setStyle("-fx-background-color: white;");
        
        // Set a fixed width for the left side
        leftContent.setPrefWidth(200);
        
        // Add the left content to the left region of the BorderPane
        root.setLeft(leftContent);

        // Add the center content to the center region of the BorderPane
        root.setCenter(gridpane);
        
        // Create a scene and add it to the stage
        Scene scene = new Scene(root, 1030, 700);
        primaryStage.setScene(scene);
        
        // Set the title of the stage and show it
        primaryStage.setTitle("Fixed Size Example");
        primaryStage.show();
	}
	
	
	
	public VBox createVBox() {
		VBox vbox = new VBox();
		Button button = new Button("Button");
		vbox.getChildren().add(button);
		return vbox;
	}
	
	// Create the Personal details side view 
	public GridPane detailView(Stage primaryStage, Patient patient) {
		
		// Create GridPane for each element
		GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
		
		Separator separator = new Separator();
        separator.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(separator, 0, 1, 2, 1);
        
        // SplitView Title 
        Label detailTitle = new Label("Personal Details");
		detailTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        GridPane.setConstraints(detailTitle, 0, 0, 2, 1);
        
		// Name
        Label nameTitle = new Label("Name");
        nameTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        GridPane.setConstraints(nameTitle, 0, 2, 2, 1);
		
        
        Label fName = new Label("First Name");
        fName.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea firstName = new TextArea();
        firstName.setPrefRowCount(1);
        firstName.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(fName, 0, 3);
        GridPane.setConstraints(firstName, 0, 4);
        
        Label lName = new Label("Last Name");
        lName.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea lastName = new TextArea();
        lastName.setPrefRowCount(1); 
        lastName.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(lName, 1, 3);
        GridPane.setConstraints(lastName, 1, 4);
        
//        Button saveName = new Button("Save");
//        saveName.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
//        GridPane.setConstraints(saveName, 0, 5, 2, 1);
        
         // Email 	
        Separator separator1 = new Separator();
        separator.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(separator1, 0, 6, 2, 1);
        
        Label emailTitle = new Label("Email");
        emailTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        GridPane.setConstraints(emailTitle, 0, 7, 2, 1);
		
        
        Label emailAdd = new Label("New Email Address");
        emailAdd.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea emailBox = new TextArea();
        emailBox.setPrefRowCount(1);
        emailBox.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(emailAdd, 0, 8);
        GridPane.setConstraints(emailBox, 0, 9);
        
        Label password = new Label("Password");
        password.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea pwBox = new TextArea();
        pwBox.setPrefRowCount(1); 
        pwBox.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(password, 1, 8);
        GridPane.setConstraints(pwBox, 1, 9);
        
//        Button savePass = new Button("Save");
//        savePass.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
//        GridPane.setConstraints(savePass, 0, 10, 2, 1);

		// Pharmacy 
        Separator separator2 = new Separator();
        separator2.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(separator2, 0, 11, 2, 1);
        
        
        Label pharmacy = new Label("Pharmacy");
        pharmacy.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        GridPane.setConstraints(pharmacy, 0, 12, 2, 1);
		
        
        Label pph = new Label("Preferred Pharmacy");
        pph.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea pphBox = new TextArea();
        pphBox.setPrefRowCount(1);
        pphBox.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(pph, 0, 13);
        GridPane.setConstraints(pphBox, 0, 14);
        
        CheckBox check = new CheckBox("Use Clinic Recommended Pharmacy");
        check.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        
        GridPane.setConstraints(check, 1, 14);
        
//        Button savePhar = new Button("Save");
//        savePhar.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
//        GridPane.setConstraints(savePhar, 0, 15, 2, 1);
        
		// Password
        Separator separator3 = new Separator();
        separator3.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(separator3, 0, 16, 2, 1);
        
        Label pass = new Label("Password");
        pass.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        GridPane.setConstraints(pass, 0, 17, 2, 1);
		
        
        Label oPass = new Label("Old Password");
        oPass.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea oPassBox = new TextArea();
        oPassBox.setPrefRowCount(1);
        oPassBox.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(oPass, 0, 18);
        GridPane.setConstraints(oPassBox, 0, 19);
        
        Label nPass = new Label("New Password");
        nPass.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea nPassBox = new TextArea();
        nPassBox.setPrefRowCount(1); 
        nPassBox.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(nPass, 1, 18);
        GridPane.setConstraints(nPassBox, 1, 19);
        
      
        Button save = new Button("Save");
        save.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
        GridPane.setConstraints(save, 0, 21, 2, 1);
        
        save.setOnAction(e -> {
        	if(!firstName.getText().isBlank()) {
        		patient.setFirstName(firstName.getText());
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Details have been changed");
        	}
        	else if(!lastName.getText().isBlank()) {
        		patient.setLastName(lastName.getText());
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Details have been changed");
        	}
        	else if(!emailBox.getText().isBlank()) {
        		patient.setEmail(emailBox.getText());
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Details have been changed");
        	}
        	else if(!nPassBox.getText().isBlank()) {
        		patient.setPassword(nPassBox.getText());
        		Alert b = new Alert(AlertType.INFORMATION);
        		b.setContentText("Details have been changed");
        	}
        	
        });
        
        Label repass = new Label("Re-enter New Password");
        repass.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        TextArea repassBox = new TextArea();
        repassBox.setPrefRowCount(1); 
        repassBox.setPrefColumnCount(20); // Adjust width as needed
        GridPane.setConstraints(repass, 1, 20);
        GridPane.setConstraints(repassBox, 1, 21);
        
        Button back = new Button("Go Back");
        GridPane.setConstraints(back, 0, 22, 2, 1);
        back.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
        
        back.setOnAction(e -> {
            // close stage
        	Main.PatientDash(primaryStage, patient);
        });
        
        gridPane.getChildren().addAll(
                detailTitle, separator, nameTitle,
                fName, firstName,lName, lastName,
                separator1, emailTitle, emailAdd, emailBox, password, pwBox,
                separator2, pharmacy, pph, pphBox, check,  
                separator3, pass, oPass, oPassBox, nPass, nPassBox, save, repass, repassBox, back);
		
		return gridPane;
	}
	
	// Create the preview view
	public VBox previewView() {
		VBox vbox = new VBox();
		VBox vbox2 = new VBox();
		vbox2.setPadding(new Insets(50));
		vbox.setPadding(new Insets(50));
		vbox2.setAlignment(Pos.CENTER);
		Image image = new Image(getClass().getResourceAsStream("account.png"));
		ImageView imageView = new ImageView(image);
		
		imageView.setFitWidth(150); // Set the width to 200 pixels
        imageView.setFitHeight(150); // Set the height to 200 pixels
		vbox2.getChildren().add(imageView);
        
		Label firstName = new Label("First Name");
		firstName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		firstName.setTextFill(Color.WHITE);
		Label email = new Label("Example@gmail.com");
		email.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		email.setTextFill(Color.WHITE);
		Label role = new Label("Patient");
		role.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		role.setTextFill(Color.WHITE);
		
		vbox.getChildren().addAll(vbox2, firstName, email, role);
		vbox.setAlignment(Pos.CENTER);
		return vbox;
		
	}
	
	
	
}