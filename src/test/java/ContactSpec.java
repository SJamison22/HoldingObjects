import com.stevejamison.Contact;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/16/16.
 */
public class ContactSpec {

    @Test
    public void getNameTest(){
        Contact fakeName = new Contact("FakeName", "555-555-5555");
        String expected = "FakeName";
        String actual = fakeName.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void getNumbersTest(){
        Contact fakeName = new Contact("FakeName", "555-555-5555");
        String expected = "555-555-5555";
        String actual = fakeName.getNumbers().get(0);
        assertEquals(expected,actual);
    }

}
