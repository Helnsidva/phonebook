package phonebook;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
	
	static Vector<Contact> contacts = new Vector<Contact>();
	
	public PhoneBook() {
		
	}
	
	public boolean addContact(String argName) {
		
		//check if the name is empty
		if(argName.length() == 0) 
			return false;
		
		//check if the contact already exists
		if (getContact(argName) == -1) {
			
			Contact newContact = new Contact(argName);
			contacts.addElement(newContact);
			return true;
		
		}
		return false;
		
	}
	
	public boolean removeContact(String argName) {
		
		//check if the contact doesn't exist
		int n = getContact(argName);
		if (getContact(argName) != -1) {
			
			contacts.remove(contacts.get(n));
			return true;
			
		}
		return false;
	}
	
	public static int getContact(String argName) {
		
		//find contact index
		for (int i = 0; i < contacts.size(); i++) {
			
			if (contacts.get(i).getName().equals(argName)) 
				return i;
			
		}
		return -1;
		
	}
	
	public boolean addNumber(String argName, String argNumber) {
		
		//check if the number is correct
		Pattern checkNumber = Pattern.compile("^[0-9+*#-]+$");
		Matcher checkEq = checkNumber.matcher(argNumber);
		if(!checkEq.find()) {
			
			System.out.println("Incorrect phone number format!");
			return false;
			
		}
		
		//check if the contact doesn't exist
		int n = getContact(argName);
		if (n != -1) {
			
			return contacts.get(n).addPhoneNumber(argNumber);
			
		}
		return false;
		
	}
	
	public boolean removeNumber(String argName, String argNumber) {
		
		//check if the contact exists
		int n = getContact(argName);
		if (n != -1) {
			
			return contacts.get(n).removePhoneNumber(argNumber);
			
		}
		return false;
		
	}
	
	public Vector<String> searchNumbers(String argName) {
		
		//check if the contact doesn't exist
		int n = getContact(argName);
		if (n != -1) {
			
			return contacts.get(n).getNumbers();
			
		}
		return null;
		
	}
	
	public String searchName(String argNumber) {
		
		for (int i = 0; i < contacts.size(); i++) {
			
			int n = contacts.get(i).getNumber(argNumber);
			if (n != -1) {
				
				return contacts.get(i).getName();
				
			}
			
		}
		return null;
		
	}
	
}
