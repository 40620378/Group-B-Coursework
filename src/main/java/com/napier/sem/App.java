package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Entrypoint of program
 */
public class App
{
    /**
     * Connects to DB and gets result of a report.
     * @param args
     */
    public static void main(String[] args)
    {

        System.out.println("Countries App");
        //get instance of SingletonConnection class
        SingletonConnection connectionManager = SingletonConnection.getInstance();
        Connection connection = connectionManager.connect();
        ArrayList<Population> result = ReportUtil.countryCitiesPopulation(connection);
        Population firstResult = result.get(0);
        System.out.println("First result: \n" + firstResult.ToString());
        connectionManager.disconnect();
    }
}