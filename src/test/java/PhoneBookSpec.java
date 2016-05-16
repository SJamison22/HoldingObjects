import com.stevejamison.Contact;
import com.stevejamison.PhoneBook;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/16/16.
 */
public class PhoneBookSpec {

    @Test
    public void addContactTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("FakeName", "5555555555");
        phoneBook.addContact(fakeName);
        String expected = "5555555555";
        String actual = phoneBook.phoneBook.get("FakeName").get(0);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void lookupTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("Fake Name", "5555555555");
        phoneBook.addContact(fakeName);
        String expected = "5555555555\n";
        String actual = phoneBook.lookup("Fake Name");
        assertEquals(expected,actual);
    }

    @Test
    public void addNumberTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("Fake Name", "5555555555");
        phoneBook.addContact(fakeName);
        phoneBook.addNumber("Fake Name", "4444444444");
        String expected = "5555555555\n4444444444\n";
        String actual = phoneBook.lookup("Fake Name");
        assertEquals(expected,actual);
    }

    @Test
    public void removeNumberTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("Fake Name", "5555555555");
        phoneBook.addContact(fakeName);
        Contact fakeAgain = new Contact("Fake Again", "2342342342");
        phoneBook.addContact(fakeAgain);
        phoneBook.addNumber("Fake Name", "4444444444");
        phoneBook.removeNumber("5555555555");
        String expected = "Fake Again :\n2342342342\nFake Name :\n4444444444\n";
        String actual = phoneBook.listContacts();
        assertEquals(expected,actual);
    }

    @Test
    public void listContactsTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("Fake Name", "5555555555");
        phoneBook.addContact(fakeName);
        Contact fakeAgain = new Contact("Fake Again", "2342342342");
        phoneBook.addContact(fakeAgain);
        phoneBook.addNumber("Fake Name", "4444444444");
        String expected = "Fake Again :\n2342342342\nFake Name :\n5555555555\n4444444444\n";
        String actual = phoneBook.listContacts();
        assertEquals(expected,actual);
    }

    @Test
    public void reverseLookupTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("Fake Name", "5555555555");
        phoneBook.addContact(fakeName);
        Contact fakeAgain = new Contact("Fake Again", "2342342342");
        phoneBook.addContact(fakeAgain);
        phoneBook.addNumber("Fake Name", "4444444444");
        String expected = "Fake Again";
        String actual = phoneBook.reverseLookup("2342342342");
        assertEquals(expected,actual);
    }

    @Test
    public void removeRecordTest(){
        PhoneBook phoneBook = new PhoneBook();
        Contact fakeName = new Contact("Fake Name", "5555555555");
        phoneBook.addContact(fakeName);
        Contact fakeAgain = new Contact("Fake Again", "2342342342");
        phoneBook.addContact(fakeAgain);
        phoneBook.addNumber("Fake Name", "4444444444");
        phoneBook.removeRecord("Fake Name");
        String expected = "Fake Again :\n2342342342\n";
        String actual = phoneBook.listContacts();
        assertEquals(expected,actual);
    }

}
