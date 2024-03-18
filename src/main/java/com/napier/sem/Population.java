package com.napier.sem;
/**
 * Contains columns to be returned from population queries
 */
public class Population {
    public String reportName;
    public int totalPopulation;
    public int totalCity;
    public int totalNotCity;

    public float percentageCity;

    public float percentageNotCity;
    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString(){
        String result = "Name: " + reportName + " Population: " + totalPopulation + " City: " + totalCity + "(" + percentageCity + ") Not City: " + totalNotCity + "(" + percentageNotCity + ")";
        return result;
    }
}

