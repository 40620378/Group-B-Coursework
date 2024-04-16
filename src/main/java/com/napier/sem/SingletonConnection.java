package com.napier.sem;
import java.sql.*;

/**
 * This class manages the connection to the MySQL database.
 * It utilises the singleton design pattern as there will only ever need to be one instance.
 */
public class SingletonConnection {
    private static SingletonConnection instance = null;
    private Connection connection = null;

    private SingletonConnection() {}

    /**
     * Implementation of singleton pattern, ensures only one instance of the class is initialised.
     * @return the single instance of the class
     */
    public static SingletonConnection getInstance() {
        if(instance == null){
            instance = new SingletonConnection();
        }
        return instance;
    }

    private Connection connectDB(String url) {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            //handle unable to find jdbc driver
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        //number of retries permitted
        int retries = 100;
        //loops for number of retries
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection(url, "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {
                //handle connection failure
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                //handle thread interruption
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return con;
    }

    /**
     * Public get method for the DB connection, ensures only one connection exists at a time.
     * @return the DB connection
     */
    public Connection connect(String url){
        //checks if connection exists
        if(connection == null){
            //connects to DB
            connection = connectDB(url);
        }
        return connection;
    }

    /**
     * Disconnects from database if a connection exists.
     */
    public void disconnect(){
        if(connection != null){
            try
            {
                //close connection
                System.out.println("Closing");
                connection.close();
            }
            catch (Exception e)
            {
                //handle failing to close connection
                System.out.println("Error closing connection to database");
            }
        }
    }
}
