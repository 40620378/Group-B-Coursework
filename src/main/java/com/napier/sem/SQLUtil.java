package com.napier.sem;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.*;
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
    public static ResultSet run(Connection connection, String sqlFileName){
        ResultSet result = null;
        try{
            Statement statement = connection.createStatement();
            ClassLoader classLoader = SQLUtil.class.getClassLoader();
            URL resource = classLoader.getResource(sqlFileName);
            File sqlFile = new File(resource.toURI());
            String query = Files.readString(sqlFile.toPath());
            System.out.println("Query:");
            System.out.println(query);
            result = statement.executeQuery(query);
            System.out.println("Query success");
        }
        catch(IOException e){
            System.out.println("Provided file doesn't exist in resources directory");
        }
        catch(SQLException e){
            System.out.println("Statement execution failed!");
            System.out.println(e.getMessage());
        }
        catch (URISyntaxException e) {
            System.out.println("URI Syntax Error when finding file:");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void validate(String sqlFileName){
        try{
            ClassLoader classLoader = SQLUtil.class.getClassLoader();
            URL resource = classLoader.getResource(sqlFileName);
            File sqlFile = new File(resource.toURI());
            String query = Files.readString(sqlFile.toPath());
            CCJSqlParserUtil.parse(query);
            System.out.println("SQL validated");
        }
        catch (JSQLParserException e) {
            System.out.println("Invalid SQL");
        }
        catch (IOException e) {
            System.out.println("Provided file doesn't exist in resources directory");
        }
        catch (URISyntaxException e) {
            System.out.println("URI Syntax Error when finding file:");
            System.out.println(e.getMessage());
        }
    }
}
