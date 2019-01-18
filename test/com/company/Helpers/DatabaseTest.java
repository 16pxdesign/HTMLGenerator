package com.company.Helpers;

import com.company.Model.Contacts;
import com.company.Model.ContactsList;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test class to test Database class functionality
 * @see Database
 */
public class DatabaseTest {

    private static final String dir = System.getProperty("user.dir");
    private String URL = "jdbc:sqlite:" + dir + "\\database file\\contacts2.db";
    private Connection connection = null;
    private Statement statement;


    /**
     * Method to open database connection
     * @return Opened database connection
     */
    private Connection openConnection() {
        try {
            if (connection == null || connection.isClosed() == true) connection = DriverManager.getConnection(this.URL);
        } catch (SQLException e) {
            e.printStackTrace();
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
        }
    }

    /**
     * Run SQL query passed to this method and return all records
     * @param query SQL query to run
     * @return Result of query
     */
    private ResultSet runQuery(String query) {
        Connection connection = this.openConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //statement.close();
            //closeConnection();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * The method created for testing purposes. The method counts and returns the number of Contacts record in the database
     * @return number of records in database
     * @throws Exception returns an error when the sql query is incorrect
     */
    private int countContactRows() throws Exception{
        String query = "SELECT count(*) FROM CONTACTS";
        try {
            ResultSet resultSet = runQuery(query);
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new Exception();
    }

    /***
     * Test method check database connection and return values of example query
     */
    @Test
    public void query(){
        String query = "SELECT count(*) FROM CONTACTS";

        int result = 0, expect = 0;
        try {
            expect = countContactRows();
            result = Database.getInstance().runQuery(query).getInt(1);
        } catch (ErrorLog errorLog) {
            errorLog.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(expect,result);
    }

    /***
     * The method checks if the number of objects created in the list is as expected
     */
    @Test
    public void contactList(){
        ArrayList<Contacts> contacts = Database.getInstance().getContacts();
        String query = "SELECT count(*) FROM CONTACTS";

        int sizeResult = contacts.size();
        int sizeExpected = 0;
        try {
            sizeExpected = Database.getInstance().runQuery(query).getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ErrorLog errorLog) {
            errorLog.printStackTrace();
        }

        assertEquals(sizeExpected,sizeResult);

    }

    /***
     * The method checks the correctness of the variable type for the received list of contacts.
     */
    @Test
    public void contactListType(){
        assertEquals(true,    Database.getInstance().getContacts().get(0) instanceof Contacts);
        assertEquals(true,    Database.getInstance().getContacts() instanceof ArrayList);

    }








}