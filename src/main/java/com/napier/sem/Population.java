package com.napier.sem;
/**
 * Contains columns to be returned from population queries
 */
public class Population {
    public String reportName;
    public int totalPopulation;
    public int totalCity;
    public int totalNotCity;
    public String ToString(){
        String result = "Name: " + reportName + "Population: " + totalPopulation + "City: " + totalCity + "Not City: " + totalNotCity;
        return result;
    }
}

