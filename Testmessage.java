package Messaging;

public class Testmessage {
	public static void main(String[] args) {
		messages portal = new messages("Patel", "Joe");
		portal.sendMessage("Patel", "Hello Joe, how are you?");
		portal.sendMessage("Patel", "I would like to inform you that you are in good health");
		portal.sendMessage("Joe", "Thank you, doctor");
		System.out.println(portal.toString());
	}
	
}
