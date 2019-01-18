package com.company.Control;

import com.company.Helpers.Database;
import com.company.Model.Contacts;
import com.company.Model.ContactsList;
import com.company.Views.Page;
import com.company.Views.PageBuilder;

import java.io.*;
import java.util.ArrayList;

/**
 * the class responsible for initiating the methods to call
 */
public class Init {
    ArrayList<Contacts> list;

    /**
     * Class constructor which starts creating a list of ContactsList in the program for later use
     */
    public Init() {
        list = ContactsList.getInstance().getList();
    }

    /***
     * Method init generate index HTML code
     */
    public Page generateIndexHTML() {


        Page page = new PageBuilder()
                .setHeader("Raport", "Aleksy Ruszala")
                .addParagraph("Contact list:")
                .addUsersList(list)
                .build();


        return page;


    }

    /***
     * The method displays the content of the page in the console as text
     */
    public void displayIndexPage() {
        Page page = generateIndexHTML();
        System.out.printf(page.toString());
    }

    /***
     * Method init generate and return list of details pages HTML code
     * @return
     */
    public ArrayList<Page> generateDetailPages() {
        ArrayList<Page> pages = new ArrayList<>();
        for (Contacts contact : list) {
            String fullName = contact.getFistName() + " " + contact.getLastName();
            Page page = new PageBuilder()
                    .setHeader(fullName, "Aleksy Ruszala")
                    .addBackLink().addParagraph(fullName)
                    .addUserDetails(contact)
                    .build();
            pages.add(page);
        }
        return pages;
    }

    /**
     * Method generate and display list of detail pages
     */
    public void displayDetailPages() {
        ArrayList<Page> pages = generateDetailPages();
        for (Page page : pages) {
            System.out.println(page.toString());
        }
    }

    /**
     * Method display on screen RAW contacts list from database
     */
    public void displayRawContacts() {
        for (Contacts item : list) {
            System.out.println(item.rawToString());
        }
    }

    /**
     * This method display single Contact from database in RAw format
     */
    public void displaySingleContact() {
        Contacts singleContact = Database.getInstance().getSingleContact();
        String s = singleContact.rawToString();
        System.out.printf(s);
    }

    /**
     * Method generate index page and detail pages and save it on drive in files
     */
    public void saveAllPages(ArrayList<Page> pages) {


        for (Page page : pages) {
            try {
                File file = new File("D:/" + page.getFilename());
                FileWriter writer = new FileWriter(file);
                writer.write(page.toString());
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
