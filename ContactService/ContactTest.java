package cS320;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("12345", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        assertEquals("12345", contact.getContactId());
        assertEquals("Elyssande", contact.getFirstName());
        assertEquals("Theron", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("24 Silvermoon Ct", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Elyssandeee", "Theron", "1234567890", "24 Silvermoon Ct");
        });
    }

    @Test
    public void testPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Elyssande", "Theron", "123456789", "24 Silvermoon Ct");
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct but it is way too long now");
        });
    }
    
    @Test
    public void testNullFields() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        });
    }
}