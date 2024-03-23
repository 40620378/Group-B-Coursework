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
        ArrayList<City> result = ReportUtil.citiesContinentByPopulation(connection, "North America");
         if(result.size() > 0){
            for (int i = 1; i < result.size(); i++){
                City Result = result.get(i);
                System.out.println(i+ ". result: " + Result.ToString());
            }
        }
        else{
            System.out.println("Result empty");
        }

        connectionManager.disconnect();
    }
}
