package com.napier.sem;

public class TotalPopulation extends Population{
    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */

    public String ToString(){
        String result = "Name: " + reportName + " totalPopulation: " + totalPopulation;
        return result;
    }

    public String ToRow(){
        String result = "| " + reportName + " | " + totalPopulation + " |\r\n";
        return result;
    }
}