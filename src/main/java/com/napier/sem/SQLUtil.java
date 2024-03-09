package com.napier.sem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;

/**
 * Util class for running and validating SQL scripts.
 */
public class SQLUtil {
    /**
     * Runs the desired SQL query against the database.
     * @param connection an established database connection
     * @param sqlFileName the name of the sql file in the resources directory
     * @return the result of the query
     */
    public static ResultSet run(Connection connection, String sqlFileName, String[] queryParams){
        ResultSet result = null;
        try{
            Statement statement = connection.createStatement();
            ClassLoader classLoader = SQLUtil.class.getClassLoader();
            InputStream resourceStream = classLoader.getResourceAsStream(sqlFileName);
            Scanner s = new Scanner(resourceStream).useDelimiter("\\A");
            String query = s.hasNext() ? s.next() : "";
            for(int i = 0; i < queryParams.length; i++){
                System.out.println(queryParams[i]);
                query = query.replaceFirst("\\?", "'" + queryParams[i] + "'");
            }
            result = statement.executeQuery(query);
            System.out.println("Query success");
        }
        catch(SQLException e){
            System.out.println("Statement execution failed!");
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Uses SQl parser to validate queries
     * @param sqlFileName the name of the sql file in the resources directory
     */

    public static void validate(String sqlFileName){
        try{
            ClassLoader classLoader = SQLUtil.class.getClassLoader();
            InputStream resourceStream = classLoader.getResourceAsStream(sqlFileName);
            Scanner s = new Scanner(resourceStream).useDelimiter("\\A");
            String query = s.hasNext() ? s.next() : "";
            CCJSqlParserUtil.parse(query);
            System.out.println("SQL validated");
        }
        catch (JSQLParserException e) {
            System.out.println("Invalid SQL");
        }
    }
}