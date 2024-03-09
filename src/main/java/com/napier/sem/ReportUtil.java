package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Contains methods to generate reports based on queries located in the resources directory.
 */
public class ReportUtil {
    /**
     * Generates a report for the overall population as well as those that live in a city and don't within a country.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> countryCitiesPopulation(Connection connection){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "peopleDistributionCountry.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                pop.reportName = resultSet.getString("reportName");
                pop.totalCity = resultSet.getInt("totalCity");
                pop.totalPopulation = resultSet.getInt("totalPopulation");
                pop.totalNotCity = resultSet.getInt("totalNotCity");
                result.add(pop);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }
}
