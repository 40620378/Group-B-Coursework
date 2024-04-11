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
        ArrayList<City> result = ReportUtil.citiesContinentByPopulation(connection, "Europe");
        ArrayList<Object> resultObject = new ArrayList<Object>();
        for(int i = 0; i < result.size(); i++) {
            System.out.println("Result Loop");
            resultObject.add(result.get(i));
        }
        ReportUtil.generateMarkdown(resultObject, "citiesEuropeByPopulation");
        connectionManager.disconnect();
    }
}
