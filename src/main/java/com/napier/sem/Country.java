package com.napier.sem;

/**
 * Contains columns to be returned from country queries
 */
public class Country {
    public String code;
    public String name;
    public String continent;
    public String region;
    public String population;
    public String capital;
    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString() {
        String result = "Country code: " + code + " Country name: " + name + " Continent: " + continent + " Region: " + region + " Population: " + population + " Capital: " + capital;
        return result;
    }

    public String ToRow() {
        String result = "| " + code + " | " + name + " | " + continent + " | " + region + " | " + population + " | " + capital + " |\r\n";
        return result;
    }
}
