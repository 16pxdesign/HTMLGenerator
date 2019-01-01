package com.company.Model;

import java.sql.Connection;

public class Contacts {
    private String ID;
    private String fistName;
    private String lastName;
    private String Email;
    private String Category;
    private Countries country;


    public Contacts(String ID, String fistName, String lastName, String email, String category, Countries country) {
        this.ID = ID;
        this.fistName = fistName;
        this.lastName = lastName;
        Email = email;
        Category = category;
        this.country = country;
    }

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
