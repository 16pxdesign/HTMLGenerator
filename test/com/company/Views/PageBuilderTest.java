package com.company.Views;

import com.company.Model.Contacts;
import com.company.Model.Countries;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test class to test PageBuilder class functionality
 * @see PageBuilder
 */
public class PageBuilderTest {

    /**
     * Method build simple page and set header options and display it on screen
     */
    @Test
    public void testHeader() {
        Page test = new PageBuilder().setHeader("Title","Author").build();
        System.out.println(test.toString());
    }

    /**
     * Method check is page contain paragraph
     */
    @Test
    public void testAddParagraph() {
        Page test = new PageBuilder().addParagraph("Test").build();
        assertTrue(test.toString().contains("Test"));
    }

    /**
     * Method build simple page with back link and display it on screen
     */
    @Test
    public void testBackLink() {
        Page test = new PageBuilder().addBackLink().build();
        System.out.println(test.toString());
    }

    /**
     * Method build simple index page with some sample data, check is it attached to page and display it on screen
     */
    @Test
    public void testUsersList() {
        ArrayList<Contacts> list = new ArrayList<>();
        list.add(new Contacts("1", "Molly", "Long", "email@w.p", "Team", new Countries("code", "fileName", "Portugal")));
        list.add(new Contacts("2", "Bill", "Fat", "email2@w.p", "Staff", new Countries("code", "fileName", "Poland")));
        Page build = new PageBuilder().addUsersList(list).build();

        System.out.println(build.toString());
        assertTrue(build.toString().contains("Molly"));
        assertTrue(build.toString().contains("Fat"));

    }

    /**
     * Method build simple datail page with some sample data, check is it attached to page and display it on screen
     */
    @Test
    public void testUserDetails() {

        Page build = new PageBuilder().addUserDetails(new Contacts("1", "Molly", "Long", "email@w.p", "Team", new Countries("code", "fileName", "Portugal"))).build();
        System.out.println(build.toString());
        assertTrue(build.toString().contains("Molly"));
        assertTrue(build.toString().contains("email@w.p"));
    }

    /**
     * Method build simple page and display it on screen
     */
    @Test
    public void testBuild() {
        Page test = new PageBuilder().build();
        System.out.println(test.toString());
    }
}