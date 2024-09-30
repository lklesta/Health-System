package Patient;
import java.util.*;

public class Testingpatient {
    public static void main(String[] args) {
    	
    	Patient newPatient = new Patient();
    	
        Scanner myPatient = new Scanner(System.in);
        System.out.println("Welcome to Heart Health Imaging System");
        System.out.println("Do you want to Log in or Sign up? Enter 1 for Log in and 2 for Sign up.");
        
        String enterNum = myPatient.nextLine();
        if(enterNum.equals("1"))
        {
        	System.out.print("Please enter your email: ");
        	String enterEmail = myPatient.nextLine();
        	System.out.print("Please enter your password: ");
        	String enterPass = myPatient.nextLine();
        	newPatient.logIn(enterEmail, enterPass);
        }
        else
        {
        	System.out.print("Please enter your first name: ");
        	String enterFName = myPatient.nextLine();
        	System.out.print("Please enter your last name: ");
        	String enterLName = myPatient.nextLine();
        	System.out.print("Please enter your birthday: ");
        	String enterDay = myPatient.nextLine();
        	System.out.print("Please enter your email: ");
        	String enterEmail = myPatient.nextLine();
        	System.out.print("Please enter your password: ");
        	String enterPass = myPatient.nextLine();
        	newPatient.createAccount(enterFName, enterLName, enterDay, enterEmail, enterPass);
        }
        
        myPatient.close();
    }
}
