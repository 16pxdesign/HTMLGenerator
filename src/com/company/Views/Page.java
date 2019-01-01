package com.company.Views;

public class Page {
   private String pageHTML;
   private String filename;


    public Page(String filename, String pageHTML) {
        this.pageHTML = pageHTML;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return pageHTML;
    }
}
