package create_login;

import java.util.List;

import Messaging.messages;
import Patient.Patient;
import java.io.Serializable;

public class doctor implements Serializable {
    private String firstName; 
    private String lastName;
    private String prescription;
    private List<messages> portal;

    public doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prescription = "";
    }

    // Getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    // Methods to perform actions
    public void enterReportSummary() {
        // Method implementation to enter report summary
        System.out.println("Doctor " + firstName + " " + lastName + " is entering report summary...");
    }

    public void addPatientMessaging(Patient myPatient){
    	portal.add(new messages(firstName, myPatient.getFirstName()));
    }

    public void respondReceiveMessages() {
        // Method implementation to respond to received messages
        System.out.println("Doctor " + firstName + " " + lastName + " is responding to received messages...");
    }

    public void accessPatientReport() {
        // Method implementation to access patient report
        System.out.println("Doctor " + firstName + " " + lastName + " is accessing patient report...");
    }
}
