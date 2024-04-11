package com.napier.sem;

import java.lang.reflect.Method;
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
        ArrayList<City> citiesEuropeByPopulation = ReportUtil.citiesContinentByPopulation(connection, "Europe");
        callGenerateMarkdown(citiesEuropeByPopulation, "citiesEuropeByPopulation");
        ArrayList<CapitalCity> capitalWorldByPopulation = ReportUtil.capitalWorldByPopulation(connection);
        callGenerateMarkdown(capitalWorldByPopulation, "capitalWorldByPopulation");
        connectionManager.disconnect();
    }

    private static void callGenerateMarkdown(ArrayList<?> result, String name) {
        ArrayList<Object> resultObject = new ArrayList<Object>();
        for(int i = 0; i < result.size(); i++) {
            resultObject.add(result.get(i));
        }
        ReportUtil.generateMarkdown(resultObject, name);
    }
}
