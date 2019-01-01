package com.company.Control;

import com.company.Helpers.Database;
import com.company.Model.Contacts;
import com.company.Model.ContactsList;
import com.company.Views.Page;
import com.company.Views.PageBuilder;

import java.io.*;
import java.util.ArrayList;

public class Init {
    ArrayList<Contacts> list;

    public Init() {
        list = ContactsList.getInstance().getList();
    }

    /***
     * Method init generate index HTML
     */
    private Page generateIndexHTML() {


        Page page = new PageBuilder()
                .setHeader("Raport", "Aleksy Ruszala")
                .addParagraph("Contact list:")
                .addUsersList(list)
                .build();


        return page;


    }

    public void displayIndexPage() {
        Page page = generateIndexHTML();
        System.out.printf(page.toString());
    }

    private ArrayList<Page> generateDetailPages() {
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

    public void displayDetailPages() {
        ArrayList<Page> pages = generateDetailPages();
        for (Page page : pages) {
            System.out.println(page.toString());
        }
    }

    public void displayRawContacts() {
        for (Contacts item : list) {
            System.out.println(item.rawToString());
        }
    }

    public void displaySingleContact() {
        Contacts singleContact = Database.getInstance().getSingleContact();
        String s = singleContact.rawToString();
        System.out.printf(s);
    }

    public void saveAllPages() {
        ArrayList<Page> pages = generateDetailPages();
        pages.add(generateIndexHTML());

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
