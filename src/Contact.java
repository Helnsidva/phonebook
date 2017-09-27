package phonebook;

import java.util.Vector;

public class Contact {
	
	String name;
	Vector<String> phoneNumbers = new Vector<String>();

	public Contact(String argName) {
		
		name = argName;
		
	}
	
	public String getName () {
		
		return name;
		
	}
	
	public boolean addPhoneNumber(String argNumber) {
		
		//check if the number already exists
		int n = getNumber(argNumber);
		if (n == -1) {
			
			phoneNumbers.addElement(argNumber);
			return true;
			
		}
		return false;
		
	}
	
	public boolean removePhoneNumber(String argNumber) {
		
		//check if the number doesn't exists
		int n = getNumber(argNumber);
		if (n != -1) {
			
			phoneNumbers.remove(phoneNumbers.get(n));
			return true;
			
		}
		return false;
		
	}
	
	public int getNumber(String argNumber) {
		
		for(int i = 0; i < phoneNumbers.size(); i++) {
			
			if (phoneNumbers.get(i).equals(argNumber))
				return i;
			
		}
		return -1;
		
	}
	
	public Vector<String> getNumbers() {
		
		return phoneNumbers;
		
	}
	
}
