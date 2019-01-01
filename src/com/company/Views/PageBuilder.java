package com.company.Views;

import com.company.Model.Contacts;

import java.util.ArrayList;

/***
 * Builder generating code of HTML page depending on the given data
 */
public class PageBuilder implements IIndexPageBuilder, ICurrentContactBuilder {

    private String pageHTML;
    private StringBuilder body = new StringBuilder();
    private StringBuilder footer = new StringBuilder();
    private String author, title;
    private String filename;

    /***
     * Init base construction of HTML page
     */
    public PageBuilder() {

        pageHTML = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n" +
                "<meta name=\"author\" content=\"$author\">\n" +
                "<title>$title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "$body\n" +
                "</body>\n" +
                "<footer>$footer</footer>\n" +
                "</html>";

    }

    /***
     * Method set meta data for building page.
     * @param title Set title for html page
     * @param author Set author for html page
     * @return
     */
    public PageBuilder setHeader(String title, String author) {
        this.author = author;
        this.title = title;
        return this;
    }

    private PageBuilder fillFooter(String string) {
        footer.append(string + "\n");
        return this;
    }

    private PageBuilder fillBody(String string) {
        body.append(string + "\n");
        return this;
    }

    public PageBuilder addParagraph(String text) {
        body.append("<blockquote class=\"blockquote text-center\">\n" +
                "  <p class=\"mb-0\">" + text + "</p>\n" +
                "</blockquote>\n");
        return this;
    }

    /***
     * Method add to HTML code back button to index page
     * @return Instance of Index Builder page
     */
    public ICurrentContactBuilder addBackLink() {
        //TODO: LINK DO INDEX.HTML DLA POD STRON.


        body.insert(0, "<a href=\"index.html\" class=\"btn btn-info\" role=\"button\">Back to Home Page</a> \n");
        return this;
    }

    /**
     * Method add to HTML code list of all Contacts from passed list and hyperlinks to page with details
     *
     * @param list List of Contacts to diplay on Index page
     * @return Instance of Index Builder page
     */
    public IIndexPageBuilder addUsersList(ArrayList<Contacts> list) {
        filename = "index.html";
        //TODO: Wypełnij stronę linkami do kazdej podstrny bazujac na liscie danych.
        String rawTable = "<table class=\"container table table-sm table-hover\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">Full Name</th>\n" +
                "      <th scope=\"col\">Details</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                " <tbody>\n" +
                " $rows" +
                " </tbody>\n" +
                "</table>";
        //init raw html tag
        String rawRow = "<tr>\n" +
                "      <td>$name</td>\n" +
                "      <td><a href=\"$url.html\">See details</a></td>\n" +
                "    </tr>";

        StringBuilder rowsBuilder = new StringBuilder();
        for (Contacts contact : list) {


            //get data
            String fullName = contact.getFistName() + " " + contact.getLastName();
            String id = contact.getID();

            //binding
            String row = rawRow.replace("$name", fullName);
            row = row.replace("$url", id);

            rowsBuilder.append(row);
            rowsBuilder.append("\n");
        }
        //add rows to table
        String table = rawTable.replace("$rows", rowsBuilder.toString());
        //attach table to body
        this.fillBody(table);

        return this;
    }

    /***
     * Method add to HTML code details for specific Contact
     * @return Instance of Curent Contact Builder page
     */
    public ICurrentContactBuilder addUserDetails(Contacts contact) {
        filename = contact.getID() + ".html";
        String rawTable = "<table class=\"container table table-sm table-hover\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">ID</th>\n" +
                "      <th scope=\"col\">$id</th>\n" +
                "   \n" +
                "    </tr>\n" +
                "  </thead>\n" +
                " <tbody>\n" +
                " <tr>\n" +
                "      <td>Name</td>\n" +
                "      <td>$name</td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                "      <td>Surname</td>\n" +
                "      <td>$surname</td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                "      <td>Email</td>\n" +
                "      <td>$email</td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                "      <td>Category</td>\n" +
                "      <td>$category</td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                "      <td>Country</td>\n" +
                "      <td>$country</td>\n" +
                " </tr>\n" +
                "\n" +
                "</table>\n";

        String table = rawTable.replace("$id", contact.getID());
        table = table.replace("$name", contact.getFistName());
        table = table.replace("$surname", contact.getLastName());
        table = table.replace("$email", contact.getEmail());
        table = table.replace("$category", contact.getCategory());
        table = table.replace("$country", contact.getCountry().getName());

        this.fillBody(table);

        return this;
    }

    /***
     * Method build page HTML code including all previous changes and settings and return it as Page
     * @return Page HTML code
     * @see Page
     */
    public Page build() {
        //set header
        pageHTML = pageHTML.replace("$title", title == null ? "" : title);
        pageHTML = pageHTML.replace("$author", author == null ? "" : title);
        pageHTML = pageHTML.replace("$body", body == null ? "" : body.toString());
        pageHTML = pageHTML.replace("$footer", footer == null ? "" : footer.toString());
        return new Page(filename, pageHTML);
    }
}
