package com.company.Helpers;

import java.util.ArrayList;

/**
 * The class represents errors has been created while the program was running and store it itself in log
 */
public class ErrorLog extends Exception {

    private static ArrayList<ErrorLog> log= new ArrayList<>();

    /**
     * Constructor get message and add new object to log list.
     * @param msg Error message received in catch block
     */
    public ErrorLog(String msg) {
        super(msg);
        log.add(this);
        System.out.printf(log.toString());
    }

    /**
     * Constructor get object of Exception, cast it to ErrorLog object add new object to log list
     * @param e Exception parameter
     */
    public ErrorLog(Exception e) {

        super(e.getMessage());
        log.add(this);
    }

    /**
     * This method return string message of error
     * @return String of error message
     */
    @Override
    public String toString() {
        return super.getMessage().toString();
    }

    /**
     * This method return whole list of log
     * @return List of logged errors.
     */
    public static ArrayList<ErrorLog> getLog() {
        return log;
    }
}
