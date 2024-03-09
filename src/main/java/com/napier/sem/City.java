package com.napier.sem;

/**
 * Contains columns to be returned from city queries
 */
public class City {
    public String name;
    public String country;
    public String district;
    public String population;

    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString(){
        String result = "City: " + name + " Country: " + name + " District: " + district + " Population: " + population;
        return result;
    }
}


