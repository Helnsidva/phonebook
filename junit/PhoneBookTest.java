package phonebook;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class PhoneBookTest {

	@Test
	public void test() {
		
		PhoneBook phoneBook = new PhoneBook();
		
		//adding contacts and phone numbers
		phoneBook.addContact("David Lynch");
		phoneBook.addNumber("David Lynch", "228-832-0083");
		phoneBook.addContact("Hideo Kojima");
		phoneBook.addNumber("Hideo Kojima", "608-429-7913");
		phoneBook.addContact("Jim Morrison");
		phoneBook.addNumber("Jim Morrison", "619-208-7180");
		phoneBook.addContact("Dexter Morgan");
		phoneBook.addNumber("Dexter Morgan", "713-993-7287");
		phoneBook.addContact("Christopher Nolan");
		phoneBook.addNumber("Christopher Nolan", "305-342-2479");
		phoneBook.addContact("Tim Skold");
		phoneBook.addNumber("Tim Skold", "806-674-4528");
		phoneBook.addContact("Arthas Menethil");
		phoneBook.addNumber("Arthas Menethil", "901-969-8888");
		phoneBook.addContact("Jon Snow");
		phoneBook.addNumber("Jon Snow", "847-647-0984");
		phoneBook.addNumber("David Lynch", "323-943-4881");
		phoneBook.addNumber("Arthas Menethil", "609-496-5239");
		phoneBook.addNumber("Jon Snow", "570-414-2663");
		phoneBook.addNumber("Jim Morrison", "402-256-4599");
		phoneBook.addNumber("Tim Skold", "989-293-4889");
		phoneBook.addNumber("Tim Skold", "630-647-8872");
		
		//check empty contact name
		assertEquals(false, phoneBook.addContact(""));
		
		//check name search
		assertEquals("Christopher Nolan", phoneBook.searchName("305-342-2479"));
		assertEquals("Jim Morrison", phoneBook.searchName("402-256-4599"));
		
		//check number search
		Vector<String> checkNumber = new Vector<String>();
		checkNumber.add("806-674-4528");
		checkNumber.add("989-293-4889");
		checkNumber.add("630-647-8872");
		assertEquals(checkNumber, phoneBook.searchNumbers("Tim Skold"));
		
		//check number removing
		assertEquals("Tim Skold", phoneBook.searchName("630-647-8872"));
		phoneBook.removeNumber("Tim Skold", "630-647-8872");
		assertEquals(null, phoneBook.searchName("630-647-8872"));
		
		//check contact removing
		assertEquals("Arthas Menethil", phoneBook.searchName("901-969-8888"));
		phoneBook.removeContact("Arthas Menethil");
		assertEquals(null, phoneBook.searchName("901-969-8888"));
		
		//check allowable phone number characters
		phoneBook.addContact("check");
		assertEquals(true, phoneBook.addNumber("check", "123456789+*#-"));
		assertEquals(false, phoneBook.addNumber("check", "123456789+*# -"));
		assertEquals(false, phoneBook.addNumber("check", "1@23456789*#-"));
		assertEquals(true, phoneBook.addNumber("check", "123+*#-456789"));
		assertEquals(true, phoneBook.addNumber("check", "##+*-"));
		assertEquals(false, phoneBook.addNumber("check", " "));
		
	}

}
