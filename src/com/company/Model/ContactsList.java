package com.company.Model;

import com.company.Helpers.Database;

import java.util.ArrayList;

/**
 * class responsible for storing and managing the contact list
 */
public class ContactsList {

    private static ContactsList instance;
    private static ArrayList<Contacts> list = new ArrayList<>();

    /**
     * Private constructor to avoid client applications to use constructor
     */
    private ContactsList() {

    }

    /**
     * Method return instance of this class
     * @return Instance of this class
     */
    public static ContactsList getInstance() {
        if(instance == null){
            instance = new ContactsList();

            if (list.isEmpty() || list == null)
                //Database.getInstance().fillContacts();
                list = Database.getInstance().getContacts();

        }


        return instance;
    }

    /**
     * Method add new object to static list in this class
     * @param item Contact to add to list
     */
    public void add(Contacts item){
        list.add(item);
    }

    /**
     * Method return list of all saved Contacts
     * @return list of Contacts
     */
    public static ArrayList<Contacts> getList() {
        return list;
    }


}
