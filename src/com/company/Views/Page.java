package com.company.Views;

/**
 * Page
 */
public class Page {
   private String pageHTML;
   private String filename;

    /**
     * Page constructor
     * @param filename Name of file
     * @param pageHTML Represents html code of pafe
     */
    public Page(String filename, String pageHTML) {
        this.pageHTML = pageHTML;
        this.filename = filename;
    }

    /**
     * Method return name of file
     * @return file name
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Method sets file name
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Method return page code as string
     * @return page html code
     */
    @Override
    public String toString() {
        return pageHTML;
    }
}
