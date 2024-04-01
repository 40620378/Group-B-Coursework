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
        ArrayList<Population> result = ReportUtil.populationWorld(connection, "Eastern Europe", "9");
         if(result.size() > 0){
            for (int i = 0; i < result.size(); i++){
                Population Result = result.get(i);
                System.out.println((i+1) +". " + Result.ToString());
            }
        }
        else{
            System.out.println("Result empty");
        }

        connectionManager.disconnect();
    }
}
