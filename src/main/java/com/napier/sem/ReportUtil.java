package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportUtil {
    public void countryCitiesPopulation(Connection connection){
        try {
            ArrayList<Population> result = new ArrayList<Population>();
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "peopleDistributionCountry.sql", params);
            if (resultSet.next()) {
                Population pop = new Population();
                pop.reportName = resultSet.getString("reportName");
                pop.totalNotCity = resultSet.getInt("totalNotCity");
                pop.totalCity = resultSet.getInt("totalCity");
                pop.totalPopulation = resultSet.getInt("totalPopulation");
                result.add(pop);
            }
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
