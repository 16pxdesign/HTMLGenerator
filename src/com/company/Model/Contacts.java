package com.company.Model;

import java.sql.Connection;

/**
 * The class that represents the contact and its data structure
 */
public class Contacts {
    private String ID;
    private String fistName;
    private String lastName;
    private String Email;
    private String Category;
    private Countries country;

    /**
     * Contact constructor to create new object od contact
     * @param ID It`s contact identifier
     * @param fistName First name of contact
     * @param lastName Last name of contact
     * @param email Email of contact
     * @param category Category of contact
     * @param country Reference to country object of contact
     */
    public Contacts(String ID, String fistName, String lastName, String email, String category, Countries country) {
        this.ID = ID;
        this.fistName = fistName;
        this.lastName = lastName;
        Email = email;
        Category = category;
        this.country = country;
    }

    /**
     * Return Id of contact
     * @return
     */
    public String getID() {
        return ID;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getCategory() {
        return Category;
    }

    public Countries getCountry() {
        return country;
    }

    /**
     * Return string of contact in RAW format
     * @return Raw String
     */
    public String rawToString() {
        return "Contacts{" +
                "ID='" + ID + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Category='" + Category + '\'' +
                ", country=" + country.getCode() +
                '}';
    }
}
