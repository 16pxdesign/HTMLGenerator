package com.company.Helpers;

import com.company.Model.Contacts;
import com.company.Model.ContactsList;
import com.company.Model.Countries;
import com.company.Model.CountriesList;

import java.sql.*;
import java.util.ArrayList;

/***
 * Class responsible for communication with the database
 */
public class Database {
    private static final String dir = System.getProperty("user.dir");
    private String URL = "jdbc:sqlite:" + dir + "\\database file\\contacts2.db";
    private Connection connection = null;
    private static Database instance = null;
    private Statement statement;

    /**
     * Private constructor to avoid client applications to use constructor
     */
    private Database() {
    }

    /**
     * Method return instance of this class
     * @return Instance of this class
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    /**
     * Method to open database connection
     * @return Opened database connection
     */
    private Connection openConnection() {
        try {
            if (connection == null || connection.isClosed() == true) connection = DriverManager.getConnection(this.URL);
        } catch (SQLException e) {
            e.printStackTrace();
            new ErrorLog(e);
        }
        return connection;
    }

    /**
     * This method close database connection if it is open
     */
    private void closeConnection() {
        try {
            if (connection != null || connection.isClosed() != true) connection.close();
            //  if(statement != null || statement.isClosed() != true) statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            new ErrorLog(e);
        }
    }

    /**
     * Run SQL query passed to this method and return all records
     *
     * @param query SQL query to run
     * @return Result of query
     * @throws ErrorLog Throws error if somehow method cannot return ResultSet
     */
    public ResultSet runQuery(String query) throws ErrorLog {
        Connection connection = getInstance().openConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //statement.close();
            //closeConnection();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            new ErrorLog(e);
        }
        throw new ErrorLog("Error: Method not return ResultSet");

    }


    /***
     * Method get list of Countries form database and return as List
     * @see Countries
     * @return
     */
    public ArrayList<Countries> getCountriesList() {
        String query = "select  c2.code_, c2.filename_,c2.flag_png_, c2.name_ from countries c2";
        ArrayList<Countries> list = new ArrayList<>();
        try {

            ResultSet resultSet = runQuery(query);

            if (resultSet.isClosed())
                throw new ErrorLog("Error: ResultSet Closed");

            while (resultSet.next()) {

                Countries country = new Countries(resultSet.getString("code_"), resultSet.getString("filename_"), resultSet.getString("name_"));
                list.add(country);


            }


        } catch (Exception e) {
            e.printStackTrace();
            new ErrorLog(e);
        }

        return list;
    }

    /***
     * Method get list of Contacts form database and return as List
     * @see Contacts
     * @return
     */
    public ArrayList<Contacts> getContacts() {

        //view :: select c1.id, c1.first_name, c1.last_name, c1.email, c1.category, c1.countrycode from contacts c1
        String query = "select * from all_users";
        ArrayList<Contacts> list = new ArrayList<>();
        try {
            ResultSet resultSet = runQuery(query);
            while (resultSet.next()) {
                String countrycode = resultSet.getString("countrycode");

                Countries country = CountriesList.getInstance().findCountry(countrycode);

                Contacts contact = new Contacts(resultSet.getString("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("category"),
                        country);

                ContactsList.getInstance().add(contact);
               list.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
            new ErrorLog(e);
        }
        return list;


    }

    /***
     * Method get single Contact form database and return it
     * @see Contacts
     * @return Single Contact object
     */
    public Contacts getSingleContact() {
        ResultSet resultSet = null;
        Contacts contact = null;
        try {
            resultSet = runQuery("Select * from contacts limit 1");

            while (resultSet.next()) {
                String countrycode = resultSet.getString("countrycode");

                Countries country = CountriesList.getInstance().findCountry(countrycode);

                contact = new Contacts(resultSet.getString("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("category"),
                        country);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ErrorLog errorLog) {
            errorLog.printStackTrace();
        }
        return contact;
    }



}
