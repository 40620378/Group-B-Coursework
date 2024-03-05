package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportUtil {
    public static void countryCitiesPopulation(Connection connection){
        try {
            ArrayList<Population> result = new ArrayList<Population>();
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "peopleDistributionCountry.sql", params);
            if (resultSet.next()) {
                Population pop = new Population();
                //pop.reportName = resultSet.getString("reportName");
                //System.out.println("Report name: " + pop.reportName);
                System.out.println("Code:" + resultSet.getString("code"));
                pop.totalCity = resultSet.getInt("totalCity");
                System.out.println("Total city:" + pop.totalCity);
                pop.totalPopulation = resultSet.getInt("totalPopulation");
                System.out.println("Population:" + pop.totalPopulation);
                pop.totalNotCity = resultSet.getInt("totalNotCity");
                System.out.println("Not city:" + pop.totalNotCity);
                result.add(pop);
            }
            System.out.println(result.size());
            for(Population p : result){
                p.toString();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }
}
