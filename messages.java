package Messaging;

import java.util.ArrayList;
import java.util.List;


public class messages {
    // ArrayList to store messages in the thread
    private ArrayList<ArrayList<String>> messageThread;
    // List to store people involved in the conversation
    private List<String> people;

    // Constructor
    public messages(String personA, String personB) {
        messageThread = new ArrayList<ArrayList<String>>();
        people = new ArrayList<String>();
        people.add(personA);
        people.add(personB);
    }

    public void sendMessage(String person, String Content) {
    	if(person!=getPerson1() & person!=getPerson2()) {
    		System.out.println("Person does not exist in this thread");
    		return;
    	}
    	ArrayList<String> dict= new ArrayList<String>();
    	dict.add(person);
    	dict.add(Content);
        messageThread.add(dict);
    }

    // Getters and setters for people
    public List<String> getPeople() {
        return people;
    }

 // Getters and setters for people
    public String getPerson1() {
        return people.get(0);
    }
 // Getters and setters for people
    public String getPerson2() {
        return people.get(1);
    }
    
    public String toString() {
    	String value = "";
    	for(int i =0; i<messageThread.size();i++) {
    		ArrayList<String> dict = messageThread.get(i);
    		if(dict.get(0)==getPerson1()) {
    			value += "Dr."+ dict.get(0)+ ": "+ dict.get(1);
    		}
    		else {
    			value += dict.get(0)+": "+ dict.get(1);
    		}
    		value += "\n";
    	}
		return value;
    }
}
