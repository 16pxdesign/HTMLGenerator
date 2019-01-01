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

public class Main {

    public static void main(String[] args) {

        Init init = new Init();
        //init.displayRawContacts();
        //init.displaySingleContact();
        //init.generateIndexHTML();
        //init.generateDetailPages();

init.saveAllPages();
    }
}
