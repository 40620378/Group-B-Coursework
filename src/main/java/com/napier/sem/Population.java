package com.napier.sem;
import java.math.BigInteger;
/**
 * Contains columns to be returned from population queries
 */
public class Population {
    public String reportName;
    public long totalPopulation;
    public long totalCity;
    public long totalNotCity;
    public float percentageCity;
    public float percentageNotCity;

    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString(){
        String result = "Name: " + reportName + " Population: " + totalPopulation + " City: " + totalCity + " Not City: " + totalNotCity;
        return result;
    }

    public String ToRow(){
        String result = "| " + reportName + " | " + totalPopulation + " | " + totalCity + " | " + totalNotCity + " | " + percentageCity + "% | "  + percentageNotCity + "% |\r\n";
        return result;
    }
}

