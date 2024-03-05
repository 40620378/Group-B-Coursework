package com.napier.sem;

import java.sql.*;

/**
 * Entrypoint of program
 */
public class App
{
    /**
     * Connects and disconnects from database.
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Countries App");
        //get instance of SingletonConnection class
        SingletonConnection connectionManager = SingletonConnection.getInstance();
        Connection connection = connectionManager.connect();
        ReportUtil.countryCitiesPopulation(connection);
        connectionManager.disconnect();
    }
}