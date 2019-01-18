package com.company;

import com.company.Control.Init;
import com.company.Helpers.Database;
import com.company.Helpers.ErrorLog;
import com.company.Model.Contacts;
import com.company.Model.ContactsList;
import com.company.Model.Countries;
import com.company.Model.CountriesList;
import com.company.Views.Page;
import com.company.Views.PageBuilder;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Main program class in which the program starts.
 */
public class Main {

    /**
     * Main program method in which the program starts.
     * @param args
     */
    public static void main(String[] args) {

        Init init = new Init();
        //init.displayRawContacts();
        //init.displaySingleContact();
        init.displayIndexPage();
        //init.generateDetailPages();


        ArrayList<Page> pages = init.generateDetailPages();
        pages.add(init.generateIndexHTML());
        init.saveAllPages(pages);

    }
}
