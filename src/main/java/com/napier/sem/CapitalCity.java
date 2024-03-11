package com.napier.sem;

public class CapitalCity extends City{
    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString(){
        String result = "City: " + name + " Country: " + country  + " Population: " + population;
        return result;
    }
}
