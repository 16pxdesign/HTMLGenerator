package com.company.Model;

import com.company.Helpers.Database;
import java.util.ArrayList;

public class CountriesList {

    private static CountriesList instance;
    private static ArrayList<Countries> list = new ArrayList<>();

    /**
     * Private constructor to avoid client applications to use constructor
     */
    private CountriesList() {
    }

    /**
     * Method return instance of this class
     * @return Instance of this class
     */
    public static CountriesList getInstance() {
        if(instance == null){
            instance = new CountriesList();

            if (list.isEmpty() || list == null)
            Database.getInstance().fillCountriesList();
        }
        return instance;
    }

    /**
     * Method add new object to static list in this class
     * @param item Country to add to list
     */
    public void add(Countries item){
        list.add(item);
    }


    /**
     * Find Country object in static list and if exit return it
     * @param code Primary key to refer to searching country object
     * @return Object of found Country
     */
    public Countries findCountry(String code){
        Countries ps = list.stream().filter(p -> p.getCode().equals(code)).findFirst().get();
        return ps;
    }

    public static ArrayList<Countries> getList() {
        return list;
    }
}
