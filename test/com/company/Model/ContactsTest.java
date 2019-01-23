package com.company.Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class to test Contacts class functionality
 * @see Contacts
 */
public class ContactsTest {

    private Contacts sample = new Contacts("1", "Molly", "Long", "email@w.p", "Team", new Countries("code", "fileName", "Portugal"));

    /***
     *  Method test is FirstName is same as for created object
     */
       @Test
    public void testFistName() {
        assertEquals("Molly", sample.getFistName());
    }

    /**
     * Method test is email is same as for created object
     */
    @Test
    public void testEmail() {
        assertEquals("email@w.p", sample.getEmail());
    }
}