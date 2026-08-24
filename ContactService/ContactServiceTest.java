package cS320;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("1", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        service.addContact(contact);
        assertNotNull(service.getContact("1"));
    }

    @Test
    public void testAddDuplicateContactThrowsException() {
        Contact contact = new Contact("1", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("1", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }
    
    @Test
    public void testDeleteNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99"));
    }

    @Test
    public void testUpdateContactSuccess() {
        Contact contact = new Contact("1", "Elyssande", "Theron", "1234567890", "24 Silvermoon Ct");
        service.addContact(contact);
        
        service.updateContact("1", "John", "Doe", "0987654321", "456 New Ave");
        
        Contact updatedContact = service.getContact("1");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 New Ave", updatedContact.getAddress());
    }
    
    @Test
    public void testUpdateNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("99", "John", "Doe", "0987654321", "456 New Ave");
        });
    }
}