package Patient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import application.Main;
import create_login.doctor;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Healthform {

    public void healthform(Stage primaryStage, doctor mydoctor) {
        // Create a BorderPane as the root node
        BorderPane root = new BorderPane();
        
        // Create content for the left side (1/4 of the scene)
        VBox leftContent = previewView();
        leftContent.setStyle("-fx-background-color: #0000ff;");
         
        GridPane gridpane = detailView(primaryStage, mydoctor);
        gridpane.setStyle("-fx-background-color: white;");
        
        // Set a fixed width for the left side
        leftContent.setPrefWidth(200);
        
        // Add the left content to the left region of the BorderPane
        root.setLeft(leftContent);
        
        // Create content for the center (remaining space)
        VBox centerContent = new VBox();
        centerContent.getChildren().addAll(
            new Label("Center"),
            new Label("Content")
        );
        
        // Add padding to the center content
        centerContent.setPadding(new Insets(10));
        
        // Add the center content to the center region of the BorderPane
        root.setCenter(gridpane);
        
        // Create a scene and add it to the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setScene(scene);
        
        // Set the title of the stage and show it
        primaryStage.setTitle("Fixed Size Example");
        primaryStage.show();
    }
    
	public VBox previewView() {
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		vbox1.setPadding(new Insets(30));
		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox2.setPadding(new Insets(30));
		vbox2.setAlignment(Pos.TOP_LEFT);
		Image image = new Image(getClass().getResourceAsStream("account.png"));
		ImageView imageView = new ImageView(image);
		
		imageView.setFitWidth(100); // Set the width to 200 pixels
        imageView.setFitHeight(100); // Set the height to 200 pixels
		vbox2.getChildren().add(imageView);
        
		Label firstName = new Label("First Name");
		firstName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		firstName.setTextFill(Color.WHITE);
		Label email = new Label("Example@gmail.com");
		email.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		email.setTextFill(Color.WHITE);
		Label role = new Label("Ph.no");
		role.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		role.setTextFill(Color.WHITE);
		
		Button checkpre = new Button("Check Pre-records.");
		checkpre.setStyle("-fx-background-color: white; -fx-text-fill: #0000ff;");
		
		VBox vbox3 = new VBox();
		vbox3.setPadding(new Insets(10));
		vbox3.setAlignment(Pos.TOP_CENTER);
		vbox3.getChildren().add(checkpre);
		
		
		vbox1.getChildren().addAll(vbox2, firstName, email, role, vbox3);
		
		return vbox1;
		
	}
    
	public GridPane detailView(Stage primaryStage, doctor mydoctor) {
			
			// Create GridPane for each element
			GridPane gridPane = new GridPane();
	        gridPane.setPadding(new Insets(10));
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);
			
	        // SplitView Title 
	        Label detailTitle = new Label("Medical History");
			detailTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
	        GridPane.setConstraints(detailTitle, 0, 0, 2, 1);
	        detailTitle.setTextFill(Color.BLUE);
	        
			Separator separator = new Separator();
	        separator.setMaxWidth(Double.MAX_VALUE);
	        GridPane.setConstraints(separator, 0, 1, 2, 1);
	        
	        // SplitView Title 
	        Label check = new Label("Please check any of the following that apply to you");
	        check.setFont(Font.font("Arial", FontWeight.BOLD, 18));
	        GridPane.setConstraints(check, 0, 2, 2, 1);
	        
	        
	        CheckBox a = new CheckBox("Allergies");
	        CheckBox chronic = new CheckBox("Chronic illnesses");
	        CheckBox other = new CheckBox("Other Medical Conditions");
	        CheckBox pre = new CheckBox("Previous Ailments");
	        CheckBox sup = new CheckBox("Supplements");
	        CheckBox fam = new CheckBox("Family Medical History");
	        
	        // Create an HBox for the first line of checkboxes
	        HBox hbox1 = new HBox(20); // Set spacing between checkboxes
	        hbox1.getChildren().addAll(a, chronic, other);
	        
	        // Create an HBox for the second line of checkboxes
	        HBox hbox2 = new HBox(20); // Set spacing between checkboxes
	        hbox2.getChildren().addAll(pre, sup, fam);

	        // Create a VBox to hold both lines of checkboxes
	        VBox vbox = new VBox(10); // Set spacing between lines
	        vbox.setPadding(new Insets(20)); // Add padding around the VBox
	        vbox.getChildren().addAll(hbox1, hbox2);
	        GridPane.setConstraints(vbox, 0, 3, 2, 1);
	        
	        // Create a HBox to hold allergies and prescriptions
	        Label allergies = new Label("Allergies");
	        allergies.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        Label prescriptions = new Label("Prescriptions");
	        prescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        
	        TextArea allergiesBox = new TextArea();
	        allergiesBox.setPrefRowCount(1);
	        allergiesBox.setMaxWidth(200);
	        TextArea prescriptionsBox = new TextArea();
	        prescriptionsBox.setPrefRowCount(1);
	        prescriptionsBox.setMaxWidth(200);
	        
	        HBox hbox3 = new HBox(20);
	        hbox3.getChildren().addAll(allergies, allergiesBox, prescriptions, prescriptionsBox);
	        GridPane.setConstraints(hbox3, 0, 4, 2, 1);
	        
	        // Create a Hbox to hold any previous ailments
	        Label preail = new Label("Any previous ailments");
	        preail.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        
	        TextArea preailBox = new TextArea();
	        preailBox.setPrefRowCount(1);
	        
	        HBox hbox4 = new HBox(20);
	        hbox4.getChildren().addAll(preail, preailBox);
	        GridPane.setConstraints(hbox4, 0, 5, 2, 1);
	        
	        
			// Create a Hbox to hold height and blood pressure
	        Label height = new Label("Height");
	        height.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        Label blood = new Label("Blood Pressure");
	        blood.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        
	        TextArea heightBox = new TextArea();
	        heightBox.setPrefRowCount(1);
	        heightBox.setMaxWidth(200);
	        TextArea bloodBox = new TextArea();
	        bloodBox.setPrefRowCount(1);
	        bloodBox.setMaxWidth(200);
	        
	        HBox hbox5 = new HBox(20);
	        hbox5.getChildren().addAll(height, heightBox, blood, bloodBox);
	        GridPane.setConstraints(hbox5, 0, 6, 2, 1);
	        
	        // Create a Hbox to hold weight and body temp
	        Label weight = new Label("Weight");
	        weight.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        Label temp = new Label("Body Temp");
	        temp.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        
	        TextArea weightBox = new TextArea();
	        weightBox.setPrefRowCount(1);
	        weightBox.setMaxWidth(200);
	        TextArea tempBox = new TextArea();
	        tempBox.setPrefRowCount(1);
	        tempBox.setMaxWidth(200);
	        
	        HBox hbox6 = new HBox(20);
	        hbox6.getChildren().addAll(weight, weightBox, temp, tempBox);
	        GridPane.setConstraints(hbox6, 0, 7, 2, 1);
	        
	        // Create a Hbox to hold insurance and policy
	        Label insurance = new Label("Insurance Provider");
	        insurance.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        Label policy = new Label("Policy Number");
	        policy.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        
	        TextArea insuBox = new TextArea();
	        insuBox.setPrefRowCount(1);
	        insuBox.setMaxWidth(200);
	        TextArea policyBox = new TextArea();
	        policyBox.setPrefRowCount(1);
	        policyBox.setMaxWidth(200);
	        
	        HBox hbox7 = new HBox(20);
	        hbox7.getChildren().addAll(insurance, insuBox, policy, policyBox);
	        GridPane.setConstraints(hbox7, 0, 8, 2, 1);
	        
	        HBox hbox9 = new HBox(20);
	        TextArea ID = new TextArea();
	        ID.setPrefRowCount(1);
	        ID.setMaxWidth(200);
	        Label IDE = new Label("Patient ID");
	        IDE.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	        
	        Button save = new Button("Save");
	        GridPane.setConstraints(save, 0, 11, 2, 1);
	        save.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
	        save.setOnAction(e ->{

		        String filename = ID.getText()+"_patient.bin";
				try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
		            Patient obj = (Patient) objectInputStream.readObject();
		            System.out.println("Object read from file: " + obj.getFirstName());
		            Main.Dashboard(primaryStage, obj);
		            String report = "Allergies: " + allergiesBox.getText() + "\nPrescriptions: " + prescriptionsBox.getText();
		            report += "Previous Ailments: " + preailBox.getText() + "\nHeight: " + heightBox.getText() + "\nBloodPressure: " + bloodBox.getText();
		            report += "Weight: " + weightBox.getText() + "Body Temp.: " + tempBox.getText() + "InsuranceID: " +  insuBox.getText();
		            report += "Policy Number: " + policyBox.getText();
		            obj.addHistory(report);
		            System.out.println(report);
		            Main.Dashboard(primaryStage, mydoctor);
		        } catch (IOException | ClassNotFoundException ex) {
		            ex.printStackTrace();
		            Alert b = new Alert(AlertType.NONE);
            		b.setAlertType(AlertType.INFORMATION);
            		b.setContentText("Please enter a valid id");
            		b.show();
		        }
	        }
	        		);
	        
	        Button back = new Button("Go Back");
	        GridPane.setConstraints(back, 0, 12, 2, 1);
	        back.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
	        
	        back.setOnAction(e -> Main.Dashboard(primaryStage, mydoctor));
	        
	        
	        
	        hbox9.getChildren().addAll(IDE, ID);
	        GridPane.setConstraints(hbox9, 0, 10, 2, 1);
	        
	        
	        gridPane.getChildren().addAll(
	                detailTitle, separator, check,
	                vbox, hbox3,hbox4, hbox5,hbox6,
	                hbox7,hbox9, save, back);
			
			return gridPane;
		}
	
//    private void openMainDashboard() {
//        Main main = new Main();
//        Stage mainStage = new Stage();
//        main(mainStage);
//    }
}
