package com.company.Model;

import java.util.ArrayList;


public class Countries {
    private String code;
    private String fileName;
    private String name;
     private String flagPNG; //skip it

    public Countries(String code, String fileName, String name) {
        this.code = code;
        this.fileName = fileName;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
