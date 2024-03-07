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
    public void ToString() {
        System.out.println("Country code: " + code + "Country name: " + name + "Continent: " + continent + "Region: " + region + "Population: " + population + "Capital: " + capital);
    }
}
